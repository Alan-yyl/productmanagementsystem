package com.alan.pms.mapper.customer;

import com.alan.pms.mapper.base.MapperBase;
import com.alan.pms.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:44
 */
public interface CustomerMapper extends MapperBase<Customer> {
    /**
     * 分页查询Customer
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @param customer 查询的实体类
     * @param searchValue 搜索框的值
     * @param timeRange 时间范围
     * @return Customer列表
     */
    @Override
    List<Customer> findAll(@Param("pageNum")Integer pageNum, @Param("pageSize") Integer pageSize, @Param("customer") Customer customer, String searchValue, String[] timeRange);


    /**
     * 查询customer_basic_information中符合要求的的总数
     * @param customer 查询要求
     * @param searchValue 搜索框的值
     * @param timeRange 时间范围
     * @return 数量
     */
    @Override
    Long findTotalWithCondition(Customer customer, String searchValue,String[] timeRange);

    /**
     *  通过ID查询Customer
     * @param id
     * @return
     */
    @Override
    Customer findById(String id);

    /**
     * 通过ID删除Customer
     * @param id
     * @return
     */
    @Override
    Integer deleteById(String id);

    /**
     * 向表中插入/更新数据
     * @param customer
     * @return
     */
    @Override
    Integer insertOrUpdate(@Param("customer") Customer customer);
}
