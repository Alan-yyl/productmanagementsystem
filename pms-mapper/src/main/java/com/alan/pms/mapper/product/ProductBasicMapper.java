package com.alan.pms.mapper.product;

import com.alan.pms.mapper.base.MapperBase;
import com.alan.pms.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:44
 */
public interface ProductBasicMapper extends MapperBase<ProductBasicInformation> {
    /**
     * 分页查询ProductBasicInformation
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @param product 查询的实体类
     * @param searchValue 搜索框的值
     * @return ProductBasicInformation列表
     */
    @Override
    List<ProductBasicInformation> findAll(@Param("pageNum")Integer pageNum, @Param("pageSize") Integer pageSize, @Param("product") ProductBasicInformation product, String searchValue, String[] timeRange);


    /**
     * 查询common_product_basic_information中符合要求的的总数
     * @param basicBean 查询要求
     * @param searchValue 搜索框的值
     * @return 数量
     */
    @Override
    Long findTotalWithCondition(ProductBasicInformation product, String searchValue,String[] timeRange);

    /**
     *  通过ID查询ProductBasicInformation
     * @param id
     * @return
     */
    @Override
    ProductBasicInformation findById(String id);

    /**
     * 通过ID删除ProductBasicInformation
     * @param id
     * @return
     */
    @Override
    Integer deleteById(String id);

    /**
     * 向表中插入/更新数据
     * @param product
     * @return
     */
    @Override
    Integer insertOrUpdate(@Param("product") ProductBasicInformation product);
}
