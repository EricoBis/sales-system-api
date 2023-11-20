"use client";

import { CardHeader } from "@nextui-org/react";
import React from "react";
import { FaRegCheckCircle } from "react-icons/fa";
import { VscError } from "react-icons/vsc";

interface OrderStatusProps {
  isBudgetDone: boolean;
}

function OrderStatus({ isBudgetDone }: OrderStatusProps) {
  const getOrderStatus = () => {
    if (isBudgetDone) {
      return (
        <CardHeader className="flex gap-3 bg-green-200">
          <div className="flex flex-row items-center">
            <FaRegCheckCircle className="text-green-700" />
            <p className="text-lg text-green-700 ml-2">
              Compra efetivada com Sucesso!
            </p>
          </div>
        </CardHeader>
      );
    } else {
      const error =
        localStorage.getItem("checkout_error") ||
        "Não foi possível efetivar a venda!";
      return (
        <CardHeader className="flex gap-3 bg-red-200">
          <div className="flex flex-row items-center">
            <VscError className="text-red-700" />
            <p className="text-lg text-red-700 ml-2">{error}</p>
          </div>
        </CardHeader>
      );
    }
  };

  return <>{getOrderStatus()}</>;
}

export default OrderStatus;
