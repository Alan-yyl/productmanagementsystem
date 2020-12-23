package com.alan.pms.service.product;

import com.alan.pms.model.*;



/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:33
 */
public interface ProductBasicService {
    /**
     * 分页获取商品基本相信
     * @param pageNum 当页的编号
     * @param pageSize 每页的大小
     * @param product 商品实体类
     * @return 返回分页结果
     */
    ResponseBean<ResponsePageBean> getProductInformationByPage(Integer pageNum, Integer pageSize, ProductBasicInformation product, String searchValue, String[] timeRange);

    /**
     * 通过ID查询ProductBasicInformation
     * @param id 数据库中的id字段
     * @return
     */
    ResponseBean<ProductBasicInformation> findProductById(String id);

    /**
     * 通过ID删除ProductBasicInformation
     * @param id 数据库中的id字段
     * @return 统一响应实体
     */
    ResponseBean<String> deleteById(String id);

    /**
     * 插入ProductBasicInformation信息
     * @param product ProductBasicInformation实体类
     * @return 统一响应实体
     */
    ResponseBean<String> insertOrUpdateProduct(ProductBasicInformation product);
}
