import api from '../api';
import { CartItem } from '@/utils/types/Cart';
import { Product } from '@/utils/types/Product';


export async function getCartProducts(items: CartItem[]): Promise<Product[]> {

  const productPromises = items.map(async (item) => {
    const productId = item.productId;
    try {
      const response = await api.get(`/products/${productId}`);
      return response.data;
    } catch (error) {
      console.error(`Erro ao buscar informações para o produto com ID ${productId}:`, error);
      return null; 
    }
  });

  // Wait for all promises to complete
  const products = await Promise.all(productPromises);

  return products.filter((product) => product !== null);
}
