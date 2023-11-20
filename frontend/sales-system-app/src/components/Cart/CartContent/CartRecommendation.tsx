import ProductCard from "@/components/Card/Product/ProductCard";
import { getProducts } from "@/services/Products/get-all-products";
import { Product } from "@/utils/types/Product";
import React, { useEffect, useState } from "react";


export default function CartRecommendation() {
  const [randomProducts, setRandomProducts] = useState<Product[]>();

  const chooseRandomProducts = (products: Product[], n: number): Product[] => {
    const result: Product[] = [];
    if(!products) return result;
  
    const arrayClone = [...products];
  
    for (let i = 0; i < n && arrayClone.length > 0; i++) {
      const randomIndex = Math.floor(Math.random() * arrayClone.length);
      const chosenProduct = arrayClone.splice(randomIndex, 1)[0];
      result.push(chosenProduct);
    }
  
    return result;
  };
  
  useEffect(() => {
    const fetchData = async () => {
      return await getProducts();
    }
    fetchData().then(products => setRandomProducts(chooseRandomProducts(products, 6)));
  }, [])

  return (
    <>
      <h1 className="font-bold mb-5">Você vai adorar</h1>
      <div className="gap-8 grid sm:grid-cols-cardlist">
        {randomProducts &&
          randomProducts.map((product: Product) => (
            <ProductCard key={product.id} product={product} />
          ))}
      </div>
    </>
  );
}
