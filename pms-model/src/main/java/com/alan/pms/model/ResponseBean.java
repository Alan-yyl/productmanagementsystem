package com.alan.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/18 22:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean<T> {
    private String msg;
    private Integer statusCode;
    private T data;
    private Boolean isFlag;
}
