package com.alan.pms.mapper.sale;

import com.alan.pms.mapper.base.MapperBase;
import com.alan.pms.model.ProductSaleRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:44
 */
public interface ProductSaleRecordMapper extends MapperBase<ProductSaleRecord> {
    /**
     * 分页查询ProductBasicInformation
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @param saleRecord 查询的实体类
     * @param searchValue 搜索框的值
     * @param timeRange 时间范围
     * @return ProductSaleRecord列表
     */
    List<Map<String,String>> queryAll(@Param("pageNum")Integer pageNum, @Param("pageSize") Integer pageSize, @Param("saleRecordMap") Map<String,Object> saleRecordMap, String searchValue, String[] timeRange);


    /**
     * 查询common_product_basic_information中符合要求的的总数
     * @param saleRecord 查询要求
     * @param searchValue 搜索框的值
     * @param timeRange 时间范围
     * @return 数量
     */
    Long queryTotalWithCondition(Map<String,Object> saleRecordMap, String searchValue,String[] timeRange);

    /**
     *  通过ID查询ProductSaleRecord
     * @param id
     * @return
     */
    @Override
    ProductSaleRecord findById(String id);

    /**
     * 通过ID查询ProductSaleRecord
     * @param id
     * @return
     */
    Map<String,Object> queryById(String id);

    /**
     * 通过ID删除ProductSaleRecord
     * @param id
     * @return
     */
    @Override
    Integer deleteById(String id);

    /**
     * 向表中更新数据
     * @param saleRecord
     * @return
     */
    Integer updateSaleRecord(@Param("saleRecord") ProductSaleRecord saleRecord);

}
