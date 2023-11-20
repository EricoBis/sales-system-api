import React, { useContext, useEffect, useState } from "react";

import { Card, CardHeader, Divider, CardBody, Button } from "@nextui-org/react";
import CartItemCard from "../CartItem/CartItemCard";
import { BsCart2 } from "react-icons/bs";

import { CartContext } from "@/context/CartContext";
import { getCartProducts } from "@/services/Products/get-cart-product";
import { Product } from "@/utils/types/Product";
import { CartItem } from "@/utils/types/Cart";
import { useSession } from "next-auth/react";
import { useRouter } from "next/navigation";
import { createBudget } from "@/services/Budgets/create-budget";
import { formatValue } from "@/utils/functions/formatting";
import { getCurrProductOnList } from "@/utils/functions/getProductOnList";

function CartContent() {
  const { cart } = useContext(CartContext);
  const [cartProducts, setCartProducts] = useState<Product[]>([]);
  const [orderValue, setOrderValue] = useState<number>(0);
  const [isBtnLoading, setIsBtnLoading] = useState(false);

  const { data: session } = useSession();
  const router = useRouter();

  useEffect(() => {
    getCartProducts(cart.itemList).then((products) => {
      setCartProducts(products);
    });
  }, [cart]);

  useEffect(() => {
    setOrderValue(getOrderValue(cart.itemList));
  }, [cart, cartProducts]);

  const getOrderValue = (itemList: CartItem[]): number => {
    return itemList.reduce((total, item) => {
      const currProduct = getCurrProductOnList(item.productId, cartProducts);
      return currProduct ? total + item.amount * currProduct.price : total;
    }, 0);
  };

  const handleProceedToCheckout = async () => {
    setIsBtnLoading(true);
    if (session?.user) {
       await createBudget(cart, session.user).then(() => {
        localStorage.setItem('showAlert', 'true');
        router.push("/cart/checkout");
      })
    }
    else router.push("api/auth/signin");
  };

  return (
    <div className="lg:flex gap-2">
      <div className="lg:w-2/3 lg:pr-4">
        <Card className="py-4">
          <CardHeader className="pb-0 pt-2 px-4 flex-col items-start">
            <div className="flex flex-row">
              <BsCart2 className="h-6 w-6" />
              <h1 className="ml-4 font-bold text-large">Meu carrinho</h1>
            </div>
          </CardHeader>
          <CardBody className="overflow-visible py-2">
            {cart.itemList &&
              cart.itemList.map((item, index) => {
                const currProduct = getCurrProductOnList(item.productId, cartProducts);
                return (
                  <CartItemCard
                    key={index}
                    product={currProduct}
                    amount={item.amount}
                  />
                );
              })}
          </CardBody>
        </Card>
      </div>
      <div className="lg:w-1/3">
        <Card>
          <CardHeader>
            <h1 className="ml-4 mt-3 font-bold text-large">Resumo do Pedido</h1>
          </CardHeader>
          <CardBody>
            <Divider />
            <p className="text-2xl text-right my-3 mr-4">
              {formatValue(orderValue)}
            </p>
            <Button
              isLoading={isBtnLoading}
              onPress={handleProceedToCheckout}
              className="text-base font-extrabold"
              color="primary"
            >
              Solicitar Orçamento
            </Button>
            <p className="text-tiny text-center text-slate-500 mt-2">
              Verifique em detalhes o valor final incluindo impostos e descontos
              na próxima etapa.
            </p>
          </CardBody>
        </Card>
      </div>
    </div>
  );
}

export default CartContent;
