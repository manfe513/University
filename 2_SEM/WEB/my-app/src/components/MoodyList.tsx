
import Alert from "antd/lib/alert";
import List from "antd/lib/list";
import React from "react";
import { useItemsQuery } from "../network/apiHooks";
import { ListItem } from "./ListItem";

export const MoodyList: React.FC = React.memo(() => {

    const { data: items, isLoading, isError, error } = useItemsQuery();

    if (isError) {
      return <Alert message={error?.message} type="error" />
    }

    return <List
          dataSource={items}
          loading={isLoading}
          renderItem={item => (

            <ListItem item={item} />
          )}
        />
})