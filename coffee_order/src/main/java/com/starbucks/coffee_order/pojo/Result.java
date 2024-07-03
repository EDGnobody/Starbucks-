package com.starbucks.coffee_order.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T>{

    private ResultResponse<T> data;

    public static Result<String> success(){
        return new Result<String>(ResultResponse.success());
    }

    public static <E> Result<E> success(E data){
        return new Result<E>(ResultResponse.success(data));
    }

    public static Result<String> error(Integer code, String message){
        return new Result<String>(ResultResponse.error(code, message));
    }

    public static <E> Result<E> error(Integer code, String message, E data){
        return new Result<E>(ResultResponse.error(code, message, data));
    }

}
