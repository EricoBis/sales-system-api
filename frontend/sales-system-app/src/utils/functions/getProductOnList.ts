import { Product } from "../types/Product";

export const getCurrProductOnList = (id: number, productList: Product[]): Product | undefined => {
    return productList.find((product) => product.id === id);
  };