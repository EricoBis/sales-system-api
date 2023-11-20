'use client';

import React, { useContext, useEffect, useState } from "react";
import { Card, CardHeader, CardBody, Divider, Button } from "@nextui-org/react";
import { getLastBudget } from "@/services/Budgets/get-last-budget";
import { User } from "@/utils/types/User";
import { Product } from "@/utils/types/Product";
import { getCartProducts } from "@/services/Products/get-cart-product";
import CheckoutItemCard from "./CheckoutItemCard";
import { Budget } from "@/utils/types/Budget";
import { LuPackage } from "react-icons/lu";
import { setBudgetDone } from "@/services/Budgets/set-budget-done";
import { useRouter } from "next/navigation";
import { formatValue } from "@/utils/functions/formatting";
import { CartContext } from "@/context/CartContext";
import { getCurrProductOnList } from "@/utils/functions/getProductOnList";
import Link from "next/link";

interface CheckoutContentProps {
  user: User;
}

function CheckoutContent({ user }: CheckoutContentProps) {
  const { clearCart } = useContext(CartContext);
  const [cartProducts, setCartProducts] = useState<Product[]>([]);
  const [budget, setBudget] = useState<Budget>();
  const [isBtnLoading, setIsBtnLoading] = useState(false);

  const router = useRouter();

  useEffect(() => {
    clearCart();
    const fetchData = async () => {
      return await getLastBudget(user);
    };
    if (user) fetchData().then((budget) => setBudget(budget));
  }, []);

  useEffect(() => {
    if (budget)
      getCartProducts(budget.items).then((products) => {
        setCartProducts(products);
      });
  }, [budget]);

  const handleFinalizeOrder = async () => {
    setIsBtnLoading(true);
    if (user && budget) {
      try {
        await setBudgetDone(budget.orderId, user);
        router.replace(`/cart/checkout/receipt/${budget.orderId}`);
      } catch (error) {
        localStorage.setItem("checkout_error", (error as Error).message);
        router.replace(`/cart/checkout/receipt/${budget.orderId}`);
      }
    }
  };

  return (
    <>
      {budget && (
        <div className="lg:flex gap-2">
          <div className="lg:w-2/3 lg:pr-4">
            <Card className="py-4">
              <CardHeader className="pb-0 pt-2 px-4 flex-col items-start">
                <div className="flex flex-row items-center">
                  <LuPackage className="h-6 w-6" />
                  <h1 className="ml-2 font-bold text-large">Itens do Pedido</h1>
                </div>
              </CardHeader>
              <CardBody className="overflow-visible py-2">
                <Divider />
                <div className="flex flex-row gap-2 ml-4 mt-6">
                  {budget.items &&
                    budget.items.map((item, index) => {
                      const currProduct = getCurrProductOnList(
                        item.productId,
                        cartProducts
                      );
                      return (
                        <CheckoutItemCard
                          key={index}
                          product={currProduct}
                          amount={item.amount}
                        />
                      );
                    })}
                </div>
              </CardBody>
            </Card>
          </div>
          <div className="lg:w-1/3">
            <Card>
              <CardHeader>
                <h1 className="ml-4 mt-3 font-bold text-large">
                  Resumo do Pedido
                </h1>
              </CardHeader>
              <CardBody>
                <Divider />
                <p className="text-base text-gray-500 text-right mt-3 mb-1 mr-4">
                  {`Total produtos: ${formatValue(budget.orderCost)}`}
                </p>
                <p className="text-base text-gray-500 text-right my-1 mr-4">
                  {`Imposto: ${formatValue(budget.taxCost)}`}
                </p>
                <p className="text-base text-gray-500 text-right my-1 mr-4">
                  {`Desconto: ${formatValue(budget.discount)}`}
                </p>
                <p className="text-2xl text-right my-3 mr-4">
                  {`Valor total: ${formatValue(budget.totalCost)}`}
                </p>
                <Button
                  isLoading={isBtnLoading}
                  onPress={handleFinalizeOrder}
                  className="text-base font-extrabold"
                  color="primary"
                >
                  Efetivar compra
                </Button>
                <Button
                  as={Link}
                  href="/"
                  className="text-base font-bold text-slate-500 mt-1"
                  variant="bordered"
                >
                  Efetivar mais tarde
                </Button>
                <p className="text-tiny text-center text-slate-500 mt-2">
                  A compra ficará disponível em "Meus Pedidos" por um tempo
                  limitado até ser efetivada.
                </p>
              </CardBody>
            </Card>
          </div>
        </div>
      )}
    </>
  );
}

export default CheckoutContent;
