import api from '../api';
import { AxiosResponse } from 'axios';
import { Budget } from '@/utils/types/Budget';
import { Cart } from '@/utils/types/Cart';
import { User } from '@/utils/types/User';

export async function createBudget(cart: Cart, user: User): Promise<Budget> {

    const response = await api
        .post("/budgets", {
            "clientId": user.id,
            "itemList": cart.itemList
        },
            {
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": user.token
                },
            }
        ).catch(function (error) {
            console.log(error);
        }) as AxiosResponse;

    return response.data as Budget;
}
