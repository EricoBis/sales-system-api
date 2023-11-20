import React from "react";
import { Chip } from "@nextui-org/react";
import { AiOutlineInfoCircle } from "react-icons/ai";

interface ErrorProps {
  message: string;
}

export default function Error({ message }: ErrorProps) {
  return (

    <Chip
    className="flex self-center"
      startContent={<AiOutlineInfoCircle size={18} />}
      color="danger"
      variant="bordered"
      radius="sm"
      size="lg"
    >
      {message}
    </Chip>
  );
}
