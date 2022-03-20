import { Popconfirm } from "antd"
import Button, { ButtonProps } from "antd/lib/button"
import React from "react"
import { useDeteltItemMutation } from "../network/apiHooks"

export const RemoveTodoButton: React.FC<
    ButtonProps & {
        itemId: number
    }
> = React.memo(({itemId, ...props}) => {

    const deleteMutation = useDeteltItemMutation()

    
    const onConfirmDeletion = () => {
        deleteMutation.mutateAsync(itemId)
    }

    return <Popconfirm
        title="Удалить?"
        onConfirm={onConfirmDeletion}
        okText="Да"
        cancelText="Нет">

        <Button 
            loading={deleteMutation.isLoading}
            {...props}
        >Удалить</Button>

    </Popconfirm>

})