export interface Budget {
    orderId: number;
    orderCost: number;
    taxCost: number;
    discount: number;
    totalCost: number;
    done: boolean;
    clientId: number;
    date: string;
    expirationDate: string;
    items: OrderItem[];
}

export interface OrderItem {
  productId: number,
  amount: number
}