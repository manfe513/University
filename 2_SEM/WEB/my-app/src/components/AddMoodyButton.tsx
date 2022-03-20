import Button from "antd/lib/button";
import Modal from "antd/lib/modal";
import React, { useEffect, useState } from "react";
import { SubmitHandler, useForm } from "react-hook-form";
import { useSaveItemMutation } from "../network/apiHooks";
import { Item } from "./Item";
import { MoodyForm } from "./MoodyForm";

export const AddMoodyButton: React.FC = React.memo(() => {

    const [isModalVisible, setIsModalVisible] = useState(false)

    const form = useForm<Item>()
    const saveItemMutation = useSaveItemMutation()

    useEffect(() => { form.reset() }, [isModalVisible])

    const onSubmit: SubmitHandler<Item> = async (item) => {
        await saveItemMutation.mutateAsync(item)

        setIsModalVisible(false)
    }

    return <>

        <Button onClick={() => { setIsModalVisible(true) }}>Добавить</Button>

        <Modal title="Создание" 
            visible={isModalVisible} 
            onOk={form.handleSubmit(onSubmit)} 
            confirmLoading={saveItemMutation.isLoading}
            onCancel={() => setIsModalVisible(false) }
            >
                <MoodyForm form={form} onSubmit={onSubmit}/>
        </Modal>
    </> 
})