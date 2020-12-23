package com.alan.pms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/21 20:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaleRecord {
    private String id;
    private double total;
    private Long count;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Timestamp saleTime;
    private String customerId;
    private Integer productId;
}
