export interface CartItem {
    productId: number;
    amount: number;
}

export interface Cart {
    itemList: CartItem[];
}