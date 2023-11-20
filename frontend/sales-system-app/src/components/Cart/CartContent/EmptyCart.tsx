import { Button } from "@nextui-org/react";
import Link from "next/link";
import React from "react";
import { BsCartFill } from "react-icons/bs";

function EmptyCart() {
  return (
    <>
      <div className="flex flex-col items-center mt-32 mb-10">
        <BsCartFill className="text-gray-300 w-52 h-52" />
        <h1 className="font-bold m-5">Carrinho vazio? Continue explorando</h1>
        <Button href="/" as={Link} color="primary" variant="shadow">
          Continuar explorando
        </Button>
      </div>
    </>
  );
}

export default EmptyCart;
