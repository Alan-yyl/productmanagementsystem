package com.alan.pms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/18 21:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBasicInformation {
    private Integer id;
    private String pid;
    private String productName;
    private String price;
    private String purchasePrice;
    private String stock;
    private String sale;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp storageTime=new Timestamp(System.currentTimeMillis());
    private String type;
    private String shop;
    private String image;
    private String productAddress;

}
