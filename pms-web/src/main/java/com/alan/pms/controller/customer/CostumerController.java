package com.alan.pms.controller.customer;

import com.alan.pms.model.Customer;
import com.alan.pms.model.ResponseBean;
import com.alan.pms.model.ResponsePageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alan.pms.service.customer.CustomerService;


/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/18 22:12
 */
@RestController
@RequestMapping("/customerBasic")
public class CostumerController {
    @Autowired
    CustomerService costumerService;

    /**
     * 分页查询商品基本信息
     * @param pageNum 当前页码
     * @param pageSize 页面大小
     * @param customer 商品实体类
     * @return 包含商品实体类的分页信息
     */
    @ResponseBody
    @GetMapping("/")
    public ResponseBean<ResponsePageBean> getAllCustomerBasic(Customer customer, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, String searchValue){
        return costumerService.getCustomerByPage(pageNum,pageSize,customer,searchValue);
    }

    /**
     * 通过ID查询顾客基本信息
     * @param personId
     * @return
     */
    @ResponseBody
    @GetMapping("/edit/{personId}")
    public ResponseBean<Customer> findProductById(@PathVariable("personId")String personId){
        return costumerService.findCustomerById(personId);
    }

    @ResponseBody
    @DeleteMapping("/delete/{personId}")
    public ResponseBean<String> deleteProductById(@PathVariable("personId")String personId){
        return costumerService.deleteById(personId);
    }

    @ResponseBody
    @PostMapping("/insertOrUpdate")
    public ResponseBean<String> insertOrUpdateProduct(@RequestBody Customer customer){
        return costumerService.insertOrUpdateCustomer(customer);
    }
}


