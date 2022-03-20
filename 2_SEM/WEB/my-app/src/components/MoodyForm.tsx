import Button from "antd/lib/button";
import Checkbox from "antd/lib/checkbox";
import Form from "antd/lib/form";
import Input from "antd/lib/input";
import React from "react";
import { SubmitHandler, useController, UseFormReturn } from "react-hook-form";
import { Item } from "./Item";

export const MoodyForm: React.FC<{
    
    form: UseFormReturn<Item, any>,
    onSubmit: SubmitHandler<Item>

}> = React.memo(({form, onSubmit}) => {

    const {
        field,
        fieldState
      } = useController({
        name: 'title',
        control: form.control,
        rules: { required: 'Обязательное поле' },
      });
    

    return <Form
      labelCol={{ span: 8 }}
      wrapperCol={{ span: 16 }}
      onFinish={form.handleSubmit(onSubmit)}
      autoComplete="off"
    >
      <Form.Item
        label="Название"
        requiredMark
        status={fieldState.invalid ? 'error' : undefined}
        validateStatus={fieldState.invalid ? 'error' : undefined}
        help={fieldState.error?.message}
      >
        <Input {...field}/>
      </Form.Item>

    </Form>
})