import { createContext, useCallback, useState } from "react";
import { Cart, CartItem } from "@/utils/types/Cart";

type CartContextType = {
  cart: Cart;
  handleRemoveCartItem: (id: number) => void;
  handleAddCartItem: (newItem: CartItem) => void;
  handleIncrementCartItem: (id: number) => void;
  handleDecrementCartItem: (id: number) => void;
  isCartEmpty: () => boolean;
  clearCart: () => void;
};

export const CartContext = createContext<CartContextType>({
  cart: { itemList: [] },
  handleRemoveCartItem: () => {},
  handleAddCartItem: () => {},
  handleIncrementCartItem: () => {},
  handleDecrementCartItem: () => {},
  isCartEmpty: () => false,
  clearCart: () => {}
});

export const CartProvider = ({ children }: { children: React.ReactNode }) => {
  const [cart, setCart] = useState<Cart>({ itemList: [] });

  const updateItemAmount = (
    listToUpdate: CartItem[],
    idToUpdate: number,
    amount: number
  ): CartItem[] => {
    return listToUpdate.map((item) => ({
      ...item,
      amount: item.productId === idToUpdate
        ? Math.max(item.amount + amount, 0)  // Ensure the amount is non-negative
        : item.amount,
    }));
  };

  const handleRemoveCartItem = useCallback((productId: number) => {
    setCart((prevCart) => ({
      ...prevCart,
      itemList: prevCart.itemList.filter(
        (item) => item.productId !== productId
      ),
    }));
  }, []);

  const handleAddCartItem = useCallback((newItem: CartItem) => {
    setCart((prevCart) => {
      const itemAlreadyOnCart = prevCart.itemList.find(
        (item) => item.productId === newItem.productId
      );

      if (itemAlreadyOnCart) {
        return {
          ...prevCart,
          itemList: updateItemAmount(prevCart.itemList, newItem.productId, 1),
        };
      } else {
        return {
          ...prevCart,
          itemList: [...prevCart.itemList, newItem],
        };
      }
    });
  }, []);

  const handleIncrementCartItem = useCallback((productId: number) => {
    setCart((prevCart) => ({
      ...prevCart,
      itemList: updateItemAmount(prevCart.itemList, productId, 1),
    }));
  }, []);

  const handleDecrementCartItem = useCallback((productId: number) => {
    setCart((prevCart) => {
      const updatedItemList = updateItemAmount(prevCart.itemList, productId, -1);
  
      // Remove the item if the quantity reaches 0
      const updatedCart = {
        ...prevCart,
        itemList: updatedItemList.filter(item => item.amount > 0),
      };
  
      return updatedCart;
    });
  }, []);

  const isCartEmpty = useCallback((): boolean => {
    return cart.itemList.length === 0;
  }, [cart.itemList]);

  const clearCart = (): void => {
    setCart({ itemList: [] }); 
  };

  return (
    <CartContext.Provider
      value={{
        cart,
        handleRemoveCartItem,
        handleAddCartItem,
        handleIncrementCartItem,
        handleDecrementCartItem,
        isCartEmpty,
        clearCart
      }}
    >
      {children}
    </CartContext.Provider>
  );
};
