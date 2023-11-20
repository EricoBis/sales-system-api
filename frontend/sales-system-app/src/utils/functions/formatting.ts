export const formatValue = (value: number): string => {
    return value.toLocaleString("pt-BR", {
        style: "currency",
        currency: "BRL",
    });
};