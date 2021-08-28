package com.misaka.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 517
 * @date 2021-08-16 - 23:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T Data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
