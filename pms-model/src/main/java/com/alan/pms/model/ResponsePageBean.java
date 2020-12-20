package com.alan.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePageBean<T> {
    private Long total;
    private List<T> dataList;
}
