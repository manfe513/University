import { Alert, Checkbox, Space } from "antd";
import Button from "antd/lib/button";
import React from "react";
import { useItemsQuery } from "../network/apiHooks";
import { AddMoodyButton } from "./AddMoodyButton";
import { MoodyList } from "./MoodyList";

export const MoodyApp: React.FC = React.memo(() => {

    const { data: items, isLoading, isError, error } = useItemsQuery();

    if (isError) {
      return <Alert message={error?.message} type="error" />
    }

    return <Space direction="vertical" style={{width: '100%' }}>

        <AddMoodyButton />

        <MoodyList/>

    </Space>
})