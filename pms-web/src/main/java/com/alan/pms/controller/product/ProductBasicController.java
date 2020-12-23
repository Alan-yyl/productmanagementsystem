package com.alan.pms.controller.product;

import com.alan.pms.service.product.ProductBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alan.pms.model.*;


/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/18 22:12
 */
@RestController
@RequestMapping("/productBasic")
public class ProductBasicController {
    @Autowired
    ProductBasicService productBasicService;

    /**
     * 分页查询商品基本信息
     * @param pageNum 当前页码
     * @param pageSize 页面大小
     * @param product 商品实体类
     * @return 包含商品实体类的分页信息
     */
    @ResponseBody
    @GetMapping("/")
    public ResponseBean<ResponsePageBean> getAllProductBasic(ProductBasicInformation product, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, String searchValue,String[] timeRange){
        return productBasicService.getProductInformationByPage(pageNum,pageSize,product,searchValue,timeRange);
    }

    /**
     * 通过ID查询商品基本信息
     * @param pid
     * @return
     */
    @ResponseBody
    @GetMapping("/edit/{pid}")
    public ResponseBean<ProductBasicInformation> findProductById(@PathVariable("pid")String pid){
        return productBasicService.findProductById(pid);
    }

    @ResponseBody
    @DeleteMapping("/delete/{pid}")
    public ResponseBean<String> deleteProductById(@PathVariable("pid")String pid){
        return productBasicService.deleteById(pid);
    }

    @ResponseBody
    @PostMapping("/insertOrUpdate")
    public ResponseBean<String> insertOrUpdateProduct(@RequestBody ProductBasicInformation product){
        return productBasicService.insertOrUpdateProduct(product);
    }
}


