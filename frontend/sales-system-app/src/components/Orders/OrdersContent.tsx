"use client";

import React from "react";
import {
  Accordion,
  AccordionItem,
  Button,
  Chip,
  Link,
} from "@nextui-org/react";
import { FaRegCheckCircle } from "react-icons/fa";
import { AiOutlineInfoCircle } from "react-icons/ai";
import { LuPackage } from "react-icons/lu";
import AccordionItemContent from "./AccordionItemContent";
import { Budget } from "@/utils/types/Budget";

interface OrdersContentProps {
  budgetList: Budget[];
} 

async function OrdersContent({ budgetList }: OrdersContentProps) {

  const getChipStatus = (isBudgetDone: boolean) => {
    return isBudgetDone ? (
      <Chip
        className="mt-2"
        startContent={<FaRegCheckCircle />}
        variant="bordered"
        color="success"
      >
        Pedido efetivado
      </Chip>
    ) : (
      <Chip
        className="mt-2"
        startContent={<AiOutlineInfoCircle />}
        variant="bordered"
        color="warning"
      >
        Agurdando ser efetivado
      </Chip>
    );
  };

  return (
    <>
      {budgetList.length > 0 ? (
        <div className="grid grid-cols-1 gap-4 items-start justify-center mx-auto max-w-4xl">
          <div className="flex flex-row align-middle">
            <LuPackage className="w-8 h-8" />
            <h1 className="text-xl font-semibold ml-2">Meus Pedidos</h1>
          </div>
          <Accordion variant="shadow">
            {budgetList &&
              budgetList.map((budget, index) => (
                <AccordionItem
                  key={index}
                  subtitle={getChipStatus(budget.done)}
                  title={`Pedido: #${budget.orderId}`}
                >
                  <AccordionItemContent budget={budget} />
                </AccordionItem>
              ))}
          </Accordion>
        </div>
      ) : (
        <div className="flex flex-col items-center mt-32 mb-10">
          <LuPackage className="text-gray-300 w-52 h-52" />
          <h1 className="font-bold m-5">
            Você ainda não possui pedidos! Continue explorando
          </h1>
          <Button href="/" as={Link} color="primary" variant="shadow">
            Continuar explorando
          </Button>
        </div>
      )}
    </>
  );
}
export default OrdersContent;
