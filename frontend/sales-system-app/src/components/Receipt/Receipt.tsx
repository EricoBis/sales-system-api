import React from "react";
import Link from "next/link";
import {
  Card,
  CardHeader,
  Divider,
  CardBody,
  CardFooter,
  Button,
} from "@nextui-org/react";
import { FaRegCheckCircle } from "react-icons/fa";
import { VscError } from "react-icons/vsc";
import { getBudget } from "@/services/Budgets/get-budget";
import { getCartProducts } from "@/services/Products/get-cart-product";
import { getCurrProductOnList } from "@/utils/functions/getProductOnList";
import { getServerSession } from "next-auth";
import { authConfig, loginIsRequiredServer } from "@/lib/auth";

interface ReceiptProps {
  order: string;
}

async function Receipt({ order }: ReceiptProps) {

  loginIsRequiredServer();

  const session = await getServerSession(authConfig);

  if(!session?.user) return <>Error</>;
  
  const budget = await getBudget(order, session.user);
  const products = await getCartProducts(budget.items);


  const getOrderStatus = () => {
    if (budget?.done) {
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

  return (
    <div className="flex items-center justify-center h-screen relative translate-y-[-150px]">
      {budget && (
        <Card className="max-w-[500px]">
          {getOrderStatus()}
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
