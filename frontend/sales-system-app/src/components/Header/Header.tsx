"use client";

import {
  Navbar,
  NavbarBrand,
  NavbarContent,
  NavbarItem,
  Button,
} from "@nextui-org/react";
import Link from "next/link";
import { CartContext } from "@/context/CartContext";

import { FiShoppingCart } from "react-icons/fi";
import logo from "/public/lojinha_logo.png";

import { Badge } from "@nextui-org/react";
import { useContext, useState, useEffect } from "react";
import { useSession } from "next-auth/react";
import Image from "next/image";
import UserPopover from "./UserPopover";

function Header() {
  const { cart } = useContext(CartContext);
  const { data: session } = useSession();

  const [isBadgeInvisible, setBadgeInvisible] = useState(true);

  useEffect(() => {
    setBadgeInvisible(cart.itemList.length > 0 ? false : true);
  }, [cart]);

  return (
    <Navbar>
      <NavbarBrand>
        <Link href="/">
          <div className="flex flex-row items-center gap-2">
            <Image className="w-8 h-8" src={logo} alt={"Logo Lojinha"} />
            <p className="font-bold text-inherit">Lojinha</p>
          </div>
        </Link>
      </NavbarBrand>
      <NavbarContent className="hidden sm:flex gap-4" justify="center">
        <NavbarItem>
          <Link color="foreground" href="#">
            Novidades
          </Link>
        </NavbarItem>
        <NavbarItem isActive>
          <Link href="/" aria-current="page">
            Produtos
          </Link>
        </NavbarItem>
      </NavbarContent>
      <NavbarContent justify="end">
        <NavbarItem>
          {session?.user ? (
            <UserPopover />
          ) : (
            <Button
              as={Link}
              href="/api/auth/signin"
              color="primary"
              variant="flat"
            >
              Login
            </Button>
          )}
        </NavbarItem>
        <NavbarItem>
          <Badge
            isInvisible={isBadgeInvisible}
            content={cart.itemList.length}
            shape="circle"
            color="danger"
          >
            <Button
              href="/cart"
              as={Link}
              radius="full"
              isIconOnly
              variant="light"
            >
              <FiShoppingCart className="h-8 w-8" />
            </Button>
          </Badge>
        </NavbarItem>
      </NavbarContent>
    </Navbar>
  );
}

export default Header;
