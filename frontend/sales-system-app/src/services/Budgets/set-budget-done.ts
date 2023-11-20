import api from '../api';
import { User } from '@/utils/types/User';

export async function setBudgetDone(orderId: number, user: User) {
    await api
        .put(`/budgets/${orderId}`,
            {
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": user.token
                },
            }
        ).then(function (response) {
            return response.data;
        }).catch(function (error) {
            if (error.response) {
                throw new Error(error.response.data);
            }
            else {
                console.log(error.message);
            }
        })
}


