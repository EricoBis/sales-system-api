"use client";

import React, { useEffect, useState } from "react";
import api from "@/services/api";
import { Card, Spacer, Button, Input, Divider } from "@nextui-org/react";
import { HiOutlineMail, HiOutlineLockClosed, HiUser } from "react-icons/hi";
import Image from "next/image";
import logo from "/public/lojinha_logo.svg";
import { useRouter } from "next/navigation";
import Link from "next/link";
import Error from "./Error";

function RegisterForm() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  
  const router = useRouter();

  useEffect(() => {
    if (error) setError("");
  }, [name, email, password]);

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if (!name || !email || !password) {
      setError("Todos os campos são necessários!");
      return;
    }

    await api
      .post(
        "/auth/register",
        {
          name: name,
          email: email,
          password: password,
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then(function (response) {
        localStorage.setItem('showAlert', 'true');
        router.push("api/auth/signin");
      })
      .catch(function (error) {
        if (error.response) {;
          setError("Usuário com este email já existe");
        } else if (error.request) {
          console.log("Error during registration: ", error);
          setError("Erro durante o registro");
        } else {
          console.log("Unexpected error: ", error);
        }
      });
  };

  return (
    <form
      onSubmit={(e) => handleSubmit(e)}
      className="flex items-center justify-center min-h-unit-10"
    >
      <Card className="w-full max-w-md p-5 sm:p-20">
        <div className="flex flex-col items-center">
          <Image src={logo} width={80} height={80} alt="Logo da loja" />
          <h1 className="text-left text-large font-bold mb-10 mt-5">
            Registro - Lojinha
          </h1>
        </div>
        <div className="flex flex-col gap-3">
          <Input
            onChange={(e) => setName(e.target.value)}
            size="lg"
            type="text"
            label="Nome Completo"
            labelPlacement="outside"
            startContent={
              <HiUser className="text-2xl text-default-400 pointer-events-none flex-shrink-0" />
            }
          />
          <Input
            onChange={(e) => setEmail(e.target.value)}
            size="lg"
            type="email"
            label="Email"
            placeholder="you@email.com"
            labelPlacement="outside"
            startContent={
              <HiOutlineMail className="text-2xl text-default-400 pointer-events-none flex-shrink-0" />
            }
          />
          <Input
            onChange={(e) => setPassword(e.target.value)}
            size="lg"
            type="password"
            label="Senha"
            labelPlacement="outside"
            startContent={
              <HiOutlineLockClosed className="text-2xl text-default-400 pointer-events-none flex-shrink-0" />
            }
          />
        </div>
        <Spacer y={5} />
        <Button type="submit" size="lg" color="primary">
          Fazer registro
        </Button>
        {error && (
          <>
            <Spacer y={4} />
            <Error message={error} />
          </>
        )}
        <Divider className="my-4" />
        <p className="text-center text-gray-600 text-sm">
          Já possui uma conta?
        </p>
        <Spacer y={2} />
        <Button
          as={Link}
          href="/api/auth/signin"
          color="primary"
          variant="bordered"
        >
          Efetuar Login
        </Button>
      </Card>
    </form>
  );
}

export default RegisterForm;
