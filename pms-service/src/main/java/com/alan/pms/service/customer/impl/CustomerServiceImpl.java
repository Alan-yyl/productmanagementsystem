package com.alan.pms.service.customer.impl;

import com.alan.pms.model.Customer;
import com.alan.pms.model.ResponseBean;
import com.alan.pms.model.ResponsePageBean;
import com.alan.pms.service.base.MapperBase;
import com.alan.pms.service.customer.CustomerService;
import com.alan.pms.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:40
 */
@Service
public class CustomerServiceImpl extends MapperBase implements CustomerService {
    @Override
    public ResponseBean<ResponsePageBean> getCustomerByPage(Integer pageNum, Integer pageSize, Customer customer, String searchValue) {
        ResponseBean<ResponsePageBean> responseBean = new ResponseBean();
        Long total=customerMapper.findTotalWithCondition(customer,searchValue,null);
        if (total>=0){
            //总数
            ResponsePageBean<Customer> pageBean = new ResponsePageBean<>();
            pageBean.setTotal(total);
            //数据
            pageNum=(pageNum-1)*pageSize;
            //提前拼接searchValue
            List<Customer> list=customerMapper.findAll(pageNum,pageSize,customer,searchValue,null);
            //构造响应信息
            pageBean.setDataList(list);
            responseBean.setStatusCode(200);
            responseBean.setMsg("分页查询Customer成功");
            responseBean.setIsFlag(true);
            responseBean.setData(pageBean);
        }else{
            responseBean.setData(null);
            responseBean.setIsFlag(false);
            responseBean.setMsg("没有查到任何数据");
            responseBean.setStatusCode(500);
        }

        return responseBean;
    }

    @Override
    public ResponseBean<Customer> findCustomerById(String id) {
        ResponseBean<Customer> responseBean = new ResponseBean<>();
        Customer customer = customerMapper.findById(id);
        if (customer!=null){
            responseBean.setIsFlag(true);
            responseBean.setMsg("findCustomerById查询成功");
            responseBean.setStatusCode(200);
            responseBean.setData(customer);
        }else{
            responseBean.setIsFlag(false);
            responseBean.setMsg("未查询到id="+id+"的信息");
            responseBean.setStatusCode(500);
            responseBean.setData(null);
        }
        return responseBean;
    }

    @Override
    public ResponseBean<String> deleteById(String id) {
        ResponseBean<String> responseBean = new ResponseBean<>();
        if ("".equals(StringUtils.safeString(id))){
            responseBean.setIsFlag(false);
            responseBean.setMsg("删除id="+id+"的数据失败，id为空");
            responseBean.setStatusCode(500);
        }if (customerMapper.deleteById(id)>0){
            responseBean.setIsFlag(true);
            responseBean.setMsg("成功删除id="+id+"的数据");
            responseBean.setStatusCode(200);
        }else{
            responseBean.setIsFlag(false);
            responseBean.setMsg("删除id="+id+"的数据失败，id不合法");
            responseBean.setStatusCode(500);
        }
        responseBean.setData("");
        return responseBean;
    }

    @Override
    public ResponseBean<String> insertOrUpdateCustomer(Customer customer) {
        ResponseBean<String> responseBean = new ResponseBean<>();
        if (customer!=null){
            if (customerMapper.insertOrUpdate(customer)>0){
                responseBean.setIsFlag(true);
                responseBean.setMsg("商品信息插入/更新成功");
                responseBean.setStatusCode(200);
                responseBean.setData(null);
            }
        }else{
            responseBean.setIsFlag(false);
            responseBean.setMsg("插入的商品信息为空");
            responseBean.setStatusCode(500);
            responseBean.setData(null);
        }
        return responseBean;
    }
}
