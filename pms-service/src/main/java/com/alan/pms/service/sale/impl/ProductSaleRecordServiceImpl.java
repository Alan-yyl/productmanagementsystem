package com.alan.pms.service.sale.impl;

import com.alan.pms.model.ProductSaleRecord;
import com.alan.pms.model.ResponseBean;
import com.alan.pms.model.ResponsePageBean;
import com.alan.pms.service.base.MapperBase;
import com.alan.pms.service.sale.ProductSaleRecordService;
import com.alan.pms.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:40
 */
@Service
public class ProductSaleRecordServiceImpl extends MapperBase implements ProductSaleRecordService {

    @Override
    public ResponseBean<ResponsePageBean> queryProductSaleRecordByPage(Integer pageNum, Integer pageSize, Map<String,Object> productSaleRecord, String searchValue, String[] timeRange) {
        ResponseBean<ResponsePageBean> responseBean = new ResponseBean();
        Long total=productSaleRecordMapper.queryTotalWithCondition(productSaleRecord,searchValue,timeRange);
        if (total>=0){
            //总数
            ResponsePageBean<Map<String,String>> pageBean = new ResponsePageBean<>();
            pageBean.setTotal(total);
            //数据
            pageNum=(pageNum-1)*pageSize;
            //提前拼接searchValue
            List<Map<String,String>> list=productSaleRecordMapper.queryAll(pageNum,pageSize,productSaleRecord,searchValue,timeRange);
            //构造响应信息
            pageBean.setDataList(list);
            responseBean.setStatusCode(200);
            responseBean.setMsg("分页查询ProductBasicInformation成功");
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
    public ResponseBean<Map<String,Object>> findProductSaleRecordById(String id) {
        ResponseBean<Map<String,Object>> responseBean = new ResponseBean<>();
        Map<String,Object>  productSaleRecord= productSaleRecordMapper.queryById(id);
        if (productSaleRecord!=null){
            responseBean.setIsFlag(true);
            responseBean.setMsg("findProductById查询成功");
            responseBean.setStatusCode(200);
            responseBean.setData(productSaleRecord);
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
        }if (productSaleRecordMapper.deleteById(id)>0){
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
    public ResponseBean<String> updateProductSaleRecord(ProductSaleRecord productSaleRecord) {
        ResponseBean<String> responseBean = new ResponseBean<>();
        if (productSaleRecord!=null){
            if (productSaleRecordMapper.updateSaleRecord(productSaleRecord)>0){
                responseBean.setIsFlag(true);
                responseBean.setMsg("销售记录更新成功");
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
