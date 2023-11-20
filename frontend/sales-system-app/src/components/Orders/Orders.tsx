import React from "react";
import Link from "next/link";
import OrdersContent from "./OrdersContent";
import { Button } from "@nextui-org/react";
import { getServerSession } from "next-auth";
import { authConfig } from "@/lib/auth";
import { getAllBudgets } from "@/services/Budgets/get-all-client-budgets";

async function Orders() {
  const session = await getServerSession(authConfig);

  if (session?.user) {
    const budgetList = await getAllBudgets(session.user);
    return (
      <>
        <OrdersContent budgetList={budgetList} />
      </>
    );
  }

  return (
    <div className="flex flex-col items-center mt-32 mb-10">
      <h1 className="mb-5">Você não está logado em sua conta!</h1>
      <Button
        href="/api/auth/signin"
        as={Link}
        color="primary"
        variant="shadow"
      >
        Fazer login
      </Button>
    </div>
  );
}

export default Orders;
