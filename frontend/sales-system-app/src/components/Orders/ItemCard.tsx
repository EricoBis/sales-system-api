import React from "react";
import { Card, CardBody, CardFooter, Image } from "@nextui-org/react";
import { Product } from "@/utils/types/Product";

interface ItemCardProps {
  product: Product | undefined;
  amount: number;
}

function ItemCard({ product, amount }: ItemCardProps) {
  return (
    <Card shadow="sm">
      <CardBody className="overflow-visible p-0">
        <Image
          shadow="sm"
          radius="lg"
          width="100%"
          alt={product ? product.description : "No description"}
          className="w-full object-cover h-[100px]"
          src={product ? product.image : ""}
        />
      </CardBody>
      <CardFooter className="text-small justify-between">
        <b>{amount}x</b>
      </CardFooter>
    </Card>
  );
}

export default ItemCard;