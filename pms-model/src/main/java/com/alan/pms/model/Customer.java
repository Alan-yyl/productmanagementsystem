package com.alan.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/21 20:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String personId;
    private String personName;
    private String address;
}
