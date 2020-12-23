package com.alan.pms.service.customer;

import com.alan.pms.model.Customer;
import com.alan.pms.model.ResponseBean;
import com.alan.pms.model.ResponsePageBean;


/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:33
 */
public interface CustomerService {
    /**
     * 分页获取商品基本相信
     * @param pageNum 当页的编号
     * @param pageSize 每页的大小
     * @param customer 顾客实体类
     * @param searchValue 模糊查询条件
     * @return 返回分页结果
     */
    ResponseBean<ResponsePageBean> getCustomerByPage(Integer pageNum, Integer pageSize, Customer customer, String searchValue);

    /**
     * 通过ID查询Customer
     * @param id 数据库中的id字段
     * @return
     */
    ResponseBean<Customer> findCustomerById(String id);

    /**
     * 通过ID删除Customer
     * @param id 数据库中的id字段
     * @return 统一响应实体
     */
    ResponseBean<String> deleteById(String id);

    /**
     * 插入Customer信息
     * @param customer Customer实体类
     * @return 统一响应实体
     */
    ResponseBean<String> insertOrUpdateCustomer(Customer customer);
}
