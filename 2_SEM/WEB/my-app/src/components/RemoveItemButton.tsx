import Button, { ButtonProps } from "antd/lib/button"
import React from "react"
import { useDeteltItemMutation } from "../network/apiHooks"

export const RemoveTodoButton: React.FC<
    ButtonProps & {
        itemId: number
    }
> = React.memo(({itemId, ...props}) => {

    const deleteMutation = useDeteltItemMutation()

    return <Button 
    onClick={ () => deleteMutation.mutateAsync(itemId) }
    loading={deleteMutation.isLoading}
        {...props}
    >Удалить</Button>
})