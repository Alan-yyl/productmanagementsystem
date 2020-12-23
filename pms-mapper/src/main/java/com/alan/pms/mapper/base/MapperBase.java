package com.alan.pms.mapper.base;

import java.util.List;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:49
 */
public interface MapperBase<T> {

    /**
     * 分页批量查询某一个实体类的所有数据
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @param basicBean 查询的实体类
     * @param searchValue 搜索框的值
     * @return
     */
    List<T> findAll(Integer pageNum, Integer pageSize, T basicBean, String searchValue, String[] timeRange);

    /**
     * 查询符合T的记录总数
     * @param basicBean T
     * @param searchValue 搜索框的值
     * @param timeRange 时间范围
     * @return
     */
    Long findTotalWithCondition(T basicBean,String searchValue,String[] timeRange);

    /**
     * 查询符合表中的记录总数
     * @return
     */
    Long findTotal() ;

    /**
     * 通过ID查询数据
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * 通过ID删除数据
     * @param id
     * @return
     */
    Integer deleteById(String id);

    /**
     * 插入/更新T
     * @param basicBean
     * @return
     */
    Integer insertOrUpdate(T basicBean);
}
