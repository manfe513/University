import Typography from "antd/lib/typography"
import React from "react"
import { useItemsQuery } from "../network/apiHooks"

export const Counter: React.FC = React.memo(() => {

    const { data: items } = useItemsQuery();

    const total = items.length
    const completed = items.filter(item => item.completed ).length

    return <Typography.Text>
        Всего/Завершено: {total} / {completed}
    </Typography.Text> 
})