package com.alan.pms.service.base;

import com.alan.pms.mapper.customer.CustomerMapper;
import com.alan.pms.mapper.product.ProductBasicMapper;
import com.alan.pms.mapper.sale.ProductSaleRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:42
 */
public abstract class MapperBase {
    @Autowired
    public ProductBasicMapper productBasicMapper;
    @Autowired
    public CustomerMapper customerMapper;
    @Autowired
    public ProductSaleRecordMapper productSaleRecordMapper;
}
