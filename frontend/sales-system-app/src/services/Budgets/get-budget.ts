import api from "../api";
import { AxiosResponse } from "axios";
import { Budget } from "@/utils/types/Budget";
import { User } from "@/utils/types/User";


export async function getBudget(orderId: string | string[], user: User): Promise<Budget> {

    const response = await api
        .get(`/budgets/${orderId}`,
            {
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": user.token
                },
            }
        ).
        
        catch(function (error) {
            console.log(error);
        }) as AxiosResponse

    return response.data as Budget;
}