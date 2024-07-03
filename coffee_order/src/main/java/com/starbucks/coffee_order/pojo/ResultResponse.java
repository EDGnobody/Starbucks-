package com.starbucks.coffee_order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultResponse<T> {

    private Integer code;//响应状态码
    private String message;//响应信息
    private T data;//返回数据

    public static <E> ResultResponse<E> success(E data){
        return new ResultResponse<>(101, "操作成功", data);
    }

    public static ResultResponse<String> success(){
        return new ResultResponse<>(101, "操作成功", null);
    }

    public static ResultResponse<String> error(Integer error_code,String error_message){
        return new ResultResponse<>(error_code, error_message, null);
    }

    public static <E> ResultResponse<E> error(Integer error_code,String error_message, E data){
        return new ResultResponse<>(error_code,error_message,data);
    }

}
