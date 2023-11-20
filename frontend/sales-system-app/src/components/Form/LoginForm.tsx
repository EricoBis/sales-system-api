"use client";

import React, { useEffect, useState } from "react";
import { Card, Spacer, Button, Input, Divider } from "@nextui-org/react";
import { HiOutlineMail, HiOutlineLockClosed } from "react-icons/hi";
import Image from "next/image";
import logo from "/public/lojinha_logo.svg";
import { signIn } from "next-auth/react";
import { useRouter } from "next/navigation";
import Link from "next/link";
import Error from "./Error";
import SuccessAlert from "../Alert/SuccessAlert";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const router = useRouter();

  useEffect(() => {
    localStorage.removeItem("showAlert");
  }, []);

  useEffect(() => {
    if (error) setError("");
  }, [email, password]);

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    try {
      const res = await signIn("credentials", {
        email,
        password,
        redirect: false,
      });

      if (res && res.error) {
        setError("Email ou senha incorretos");
        return;
      }

      router.replace("/");
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      <form
        onSubmit={handleSubmit}
        className="flex items-center justify-center min-h-unit-10"
      >
        <Card className="w-full max-w-md p-5 sm:p-20">
          <div className="flex flex-col items-center">
            <Image src={logo} width={80} height={80} alt="Logo da loja" />
            <h1 className="text-left text-large font-bold mb-10 mt-5">
              Login - Lojinha
            </h1>
          </div>
          <div className="flex flex-col gap-3">
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
            Fazer login
          </Button>
          {error && (
            <>
              <Spacer y={4} />
              <Error message={error} />
            </>
          )}
          <Divider className="my-4" />
          <p className="text-center text-gray-600 text-sm">
            Ainda não tem uma conta?
          </p>
          <Spacer y={2} />
          <Button as={Link} href="/register" color="primary" variant="bordered">
            Registrar-se
          </Button>
        </Card>
      </form>

      {localStorage.getItem("showAlert") &&
        localStorage.getItem("showAlert") === "true" && (
          <SuccessAlert message="Usuário registrado com sucesso!" />
        )}
    </>
  );
}
