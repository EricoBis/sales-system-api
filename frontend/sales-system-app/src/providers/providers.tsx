"use client";

import { NextUIProvider } from "@nextui-org/react";
import { CartProvider } from "../context/CartContext";
import { SessionProvider } from "next-auth/react";

export function Providers({ children }: { children: React.ReactNode }) {
  return (
    <NextUIProvider>
      <SessionProvider>
        <CartProvider>{children}</CartProvider>
      </SessionProvider>
    </NextUIProvider>
  );
}
