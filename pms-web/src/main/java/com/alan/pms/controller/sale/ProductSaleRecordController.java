package com.alan.pms.controller.sale;

import com.alan.pms.model.ProductSaleRecord;
import com.alan.pms.model.ResponseBean;
import com.alan.pms.model.ResponsePageBean;
import com.alan.pms.service.sale.ProductSaleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/18 22:12
 */
@RestController
@RequestMapping("/saleRecord")
public class ProductSaleRecordController {
    @Autowired
    ProductSaleRecordService productSaleRecordService;

    /**
     * 分页查询商品基本信息
     * @param pageNum 当前页码
     * @param pageSize 页面大小
     * @param saleRecord 商品销售记录实体类
     * @return 包含商品实体类的分页信息
     */
    @ResponseBody
    @PostMapping("/")
    public ResponseBean<ResponsePageBean> getAllProductSaleRecordBasic(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,@RequestParam(value = "searchValue",required = false) String searchValue,@RequestParam(value = "timeRange",required = false) String[] timeRange,@RequestBody Map<String,Object> saleRecord){
        return productSaleRecordService.queryProductSaleRecordByPage(pageNum,pageSize,saleRecord,searchValue,timeRange);
    }

    /**
     * 通过ID查询商品基本信息
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/edit/{id}")
    public ResponseBean<Map<String,Object>> findProductSaleRecordById(@PathVariable("id")String id){
        return productSaleRecordService.findProductSaleRecordById(id);
    }

    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public ResponseBean<String> deleteProductSaleRecordById(@PathVariable("id")String id){
        return productSaleRecordService.deleteById(id);
    }

    @ResponseBody
    @PostMapping("/update")
    public ResponseBean<String> updateProductSaleRecord(@RequestBody ProductSaleRecord saleRecord){
        return productSaleRecordService.updateProductSaleRecord(saleRecord);
    }


    @ResponseBody
    @GetMapping("/saleRecordRealTimeData")
    public ResponseBean<List<Map<String,String>>> getSaleRecordRealTimeData(){
        return productSaleRecordService.saleRecordRealTimeData();
    }
}


