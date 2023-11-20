import api from '../api';

export async function getProducts() {

    try {
        const response = await api.get('/products');
        return response?.data || [];
    } catch (error) {
        console.error(error);
    }
}