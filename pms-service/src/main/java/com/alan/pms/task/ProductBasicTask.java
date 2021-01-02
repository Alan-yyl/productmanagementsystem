package com.alan.pms.task;

import com.alan.pms.model.ProductBasicInformation;
import com.alan.pms.service.base.MapperBase;

import java.util.List;

/**
 * @Author: Alan
 * @Date: 2021/1/1 15:37
 */
public class ProductBasicTask extends MapperBase {

    public static void main(String[] args) {
        ProductBasicTask task = new ProductBasicTask();
        task.refreshProductName();
    }

    public void refreshProductName(){
        List<ProductBasicInformation> list=productBasicMapper.findAll(0,1000,null,null,null);
        System.out.println(list);
    }

}
