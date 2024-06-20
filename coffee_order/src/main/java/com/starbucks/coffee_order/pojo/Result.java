package com.starbucks.coffee_order.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T>{
    private Integer code;//响应状态码
    private String message;//响应信息
    private T data;//返回数据

    public static <E> Result<E> success(E data){
        return new Result<>(101, "操作成功", data);
    }

    public static Result success(){
        return new Result<>(101, "操作成功", null);
    }

    public static Result error(Integer error_code,String error_message){
        return new Result<>(error_code, error_message, null);
    }
}
