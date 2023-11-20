import React from "react";
import Link from "next/link";
import {
  Card,
  Divider,
  CardBody,
  CardFooter,
  Button,
} from "@nextui-org/react";
import { getBudget } from "@/services/Budgets/get-budget";
import { getCartProducts } from "@/services/Products/get-cart-product";
import { getCurrProductOnList } from "@/utils/functions/getProductOnList";
import { getServerSession } from "next-auth";
import { authConfig, loginIsRequiredServer } from "@/lib/auth";
import OrderStatus from "./OrderStatus";

interface ReceiptProps {
  order: string;
}

async function Receipt({ order }: ReceiptProps) {

  loginIsRequiredServer();

  const session = await getServerSession(authConfig);

  if(!session?.user) return <>Error</>;
  
  const budget = await getBudget(order, session.user);
  const products = await getCartProducts(budget.items);

  return (
    <div className="flex items-center justify-center h-screen relative translate-y-[-150px]">
      {budget && (
        <Card className="max-w-[500px]">
          <OrderStatus isBudgetDone={budget.done}/>
          <Divider />
          <CardBody>
            <p>Pedido #{budget?.orderId}</p>
            <p className="text-tiny font-semibold">Itens:</p>
            {budget &&
              budget.items.map((item, index) => {
                const currProduct = getCurrProductOnList(
                  item.productId,
                  products
                );
                return (
                  <p key={index} className="text-sm">
                    {item.amount}x {currProduct?.description}
                  </p>
                );
              })}
          </CardBody>
          <Divider />
          <CardFooter className="flex justify-between gap-3">
            <Button
              as={Link}
              href="/orders"
              color="primary"
              variant="bordered"
              className="w-1/2"
            >
              Meus Pedidos
            </Button>
            <Button as={Link} href="/" color="primary" className="w-1/2">
              Ir para início
            </Button>
          </CardFooter>
        </Card>
      )}
    </div>
  );
}

export default Receipt;
