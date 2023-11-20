import type { Metadata } from "next";

import "./globals.css";
import { Providers } from "../providers/providers";

import Header from "../components/Header/Header";
import ContentContainer from "@/components/Container/ContentContainer";
import { Suspense } from "react";
import Loading from "./loading";

export const metadata: Metadata = {
  title: "Lojinha",
  description: "Serviço de Vendas - Fundamentos de Desenvolvimento de Software",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en" className="light">
      <head>
        <link rel='icon' href='/lojinha_logo.ico'/>
      </head>
      <body>
        <Providers>
          <main className="text-foreground bg-background">
            <Header />
            <ContentContainer>
              <Suspense fallback={<Loading />}>{children}</Suspense>
            </ContentContainer>
          </main>
        </Providers>
      </body>
    </html>
  );
}
