import React from "react";
import {
  Popover,
  PopoverTrigger,
  Button,
  PopoverContent,
  Spacer,
  Divider,
} from "@nextui-org/react";
import { signOut, useSession } from "next-auth/react";
import { CgProfile } from "react-icons/cg";

import { LuPackage } from "react-icons/lu";
import Link from "next/link";

function UserPopover() {
  const { data: session } = useSession();
  const fullName = session?.user.name;
  const firstName = fullName?.substring(0, fullName.indexOf(' '));

  return (
    <Popover
      className="text-black"
      backdrop="opaque"
      placement="bottom"
      showArrow={true}
    >
      <PopoverTrigger>
        <Button radius="full" variant="light">
          <p className="text-base font-medium">{firstName}</p>
          <CgProfile className="h-8 w-8" />
        </Button>
      </PopoverTrigger>
      <PopoverContent className="">
        <div className="w-52 px-2 py-3">
          <p className="text-small font-bold">Olá, {fullName}</p>
          <Divider className="my-2" />
          <Link color="foreground" href="/orders">
            <div className="flex flex-row items-center gap-1 text-base">
              <LuPackage />
              <p>Meus Pedidos</p>
            </div>
          </Link>
          <Divider className="my-2" />
          <Button
            className=""
            size="sm"
            color="danger"
            variant="light"
            onPress={() => signOut()}
          >
            Sair
          </Button>
        </div>
      </PopoverContent>
    </Popover>
  );
}

export default UserPopover;
