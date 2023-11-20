"use client";

import React, { useContext } from "react";
import CartContent from "@/components/Cart/CartContent/CartContent";
import EmptyCart from "@/components/Cart/CartContent/EmptyCart";
import { CartContext } from "@/context/CartContext";
import CartRecommendation from "./CartContent/CartRecommendation";

export default function Cart() {
  const { isCartEmpty } = useContext(CartContext);

  return (
    <>
      {isCartEmpty() ? (
        <>
          <EmptyCart />
          <CartRecommendation />
        </>
      ) : (
        <CartContent />
      )}
    </>
  );
}
