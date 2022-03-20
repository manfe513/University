import Checkbox from "antd/lib/checkbox"
import List from "antd/lib/list"
import Typography from "antd/lib/typography"
import React from "react"
import { useSaveItemMutation } from "../network/apiHooks"
import { Item } from "./Item"
import { RemoveTodoButton } from "./RemoveItemButton"

export const ListItem: React.FC<{

    item: Item

}> = React.memo(({item}) => {

    const saveItemMutation = useSaveItemMutation()

    return <List.Item key={item.id}>

        <List.Item.Meta
            avatar={
                <Checkbox 
                    disabled={saveItemMutation.isLoading}
                    checked={item.completed} 
                    onChange={e => {
                        saveItemMutation.mutateAsync({
                            ...item,
                            completed: e.target.checked
                        })
                    }} 
                />
            }
            title={ 
                <Typography.Text 
                    disabled={item.completed}
                    delete={item.completed}
                >
                    {item.title}
                </Typography.Text> 
            }
        />

        <RemoveTodoButton itemId={item.id}>Удалить</RemoveTodoButton>
        
    </List.Item>
})