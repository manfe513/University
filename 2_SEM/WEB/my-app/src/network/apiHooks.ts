import axios, { Axios, AxiosError } from "axios";
import { url } from "inspector";
import { useMutation, useQuery, useQueryClient } from "react-query";
import { Item } from "../components/Item";

function delay(durationMillis: number) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve(null)
        }, durationMillis);
    })
};

export const useItemsQuery = () => {

    return useQuery<Item[], AxiosError>('items', async () => {

        await delay(2000)

        const response = await axios.get<Item[]>("/items")
        return response.data;
    })
}

export const useSaveItemMutation = () => {

    const queryClient = useQueryClient()

    return useMutation<Item, AxiosError, Item>('items', async (data) => {

        await delay(2000)

        const isNew = data.id == null

        const response = await axios.request({
            url: `/items/${isNew ? '' : data.id}`, 
            method: isNew ? 'post' : 'put',
            data: data
        })
        return response.data;
    }, {
        onSuccess(data, inputData) {
            queryClient.setQueryData<Item[]>('items', items => {

                const isNew = inputData.id == null
                
                if(isNew) {
                    items.push(data)
                } else {
                    const index = items.findIndex(t => t.id == inputData.id)
                    items[index] = data
                }
                
                return [...items]
            })
        }
    })
}

export const useDeteltItemMutation = () => {

    const queryClient = useQueryClient()

    return useMutation<Item, AxiosError, number>('items', async (id) => {

        await delay(2000)

        const response = await axios.delete<Item>(`/items/${id}`)
        return response.data;
    }, {
        onSuccess(data, id) {
            queryClient.setQueryData<Item[]>('items', items => {
                const index = items.findIndex(t => t.id = id)
                items.splice(index, 1)
                return [... items]
            })
        }
    })
}