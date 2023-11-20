"use client";

import React, { useContext } from "react";
import { CartContext } from "@/context/CartContext";
import { Product } from "@/utils/types/Product";

import RemoveItemModal from "./Modal/RemoveItemModal";
import { Button, Divider, Image, useDisclosure } from "@nextui-org/react";
import { HiTrash } from "react-icons/hi";
import { BiPlus, BiMinus } from "react-icons/bi";

interface CartItemProps {
  product: Product | undefined;
  amount: number;
}

function CartItemCard(props: CartItemProps) {
  const { product, amount } = props;
  const { handleIncrementCartItem, handleDecrementCartItem, handleRemoveCartItem } =
    useContext(CartContext);
  const { isOpen, onOpen, onClose } = useDisclosure();

  const handleDecrementItemBtn = () => {
    if (amount - 1 <= 0) onOpen();
    else if (product) handleDecrementCartItem(product.id);
  };

  const removeCartItem = () => {
    if(product) handleRemoveCartItem(product.id)
  }

  return (
    <>
      <Divider className="my-4" />
      <div className="flex flex-row justify-between">
        <div className="flex fle-row ml-2">
          <>
            <Image
              width={100}
              src={product ? product.image : ""}
              alt={product ? product.description : "No description"}
            />
          </>
          <div className="flex flex-col justify-between ml-4">
            <div>
              <b>
                {product ? product.description : "No description available"}
              </b>
              <p className="text-green-600 font-medium text-lg">
                {product ? `R$${product.price}` : "Price not available"}
              </p>
            </div>
            <div className="flex flex-row items-center">
              <Button
                isIconOnly
                size="sm"
                radius="full"
                onPress={() => handleDecrementItemBtn()}
              >
                <BiMinus className="w-4 h-4" />
              </Button>
              <p className="mx-2">{amount}</p>
              <Button
                isIconOnly
                size="sm"
                radius="full"
                onPress={() => product && handleIncrementCartItem(product.id)}
              >
                <BiPlus className="w-4 h-4" />
              </Button>
            </div>
          </div>
        </div>
        <Button
          size="sm"
          color="default"
          variant="bordered"
          endContent={<HiTrash className="text-gray-500 h-4 w-4" />}
          onPress={() => onOpen()}
        >
          Remover
        </Button>
      </div>
      <RemoveItemModal isOpen={isOpen} onClose={onClose} removeCartItem={removeCartItem} />
    </>
  );
}

export default CartItemCard;
