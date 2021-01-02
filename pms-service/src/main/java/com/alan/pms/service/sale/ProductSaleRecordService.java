package com.alan.pms.service.sale;

import com.alan.pms.model.ProductSaleRecord;
import com.alan.pms.model.ResponseBean;
import com.alan.pms.model.ResponsePageBean;

import java.util.List;
import java.util.Map;


/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:33
 */
public interface ProductSaleRecordService {
    /**
     * 分页获取商品基本相信
     * @param pageNum 当页的编号
     * @param pageSize 每页的大小
     * @param productSaleRecord 商品实体类
     * @param timeRange 时间范围
     * @param searchValue 模糊查询值
     * @return 返回分页结果
     */
    ResponseBean<ResponsePageBean> queryProductSaleRecordByPage(Integer pageNum, Integer pageSize, Map<String,Object> productSaleRecord, String searchValue, String[] timeRange);

    /**
     * 通过ID查询ProductBasicInformation
     * @param id 数据库中的id字段
     * @return
     */
    ResponseBean<Map<String,Object>> findProductSaleRecordById(String id);

    /**
     * 通过ID删除ProductSaleRecord
     * @param id 数据库中的id字段
     * @return 统一响应实体
     */
    ResponseBean<String> deleteById(String id);

    /**
     * 插入ProductSaleRecord信息
     * @param productSaleRecord ProductSaleRecord实体类
     * @return 统一响应实体
     */
    ResponseBean<String> updateProductSaleRecord(ProductSaleRecord productSaleRecord);

    /**
     * 获取销售实时数据
     * @return
     */
    ResponseBean<List<Map<String,String>>> saleRecordRealTimeData();
}
