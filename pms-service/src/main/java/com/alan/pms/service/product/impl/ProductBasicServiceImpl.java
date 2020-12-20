package com.alan.pms.service.product.impl;

import com.alan.pms.model.ProductBasicInformation;
import com.alan.pms.model.ResponseBean;
import com.alan.pms.model.ResponsePageBean;
import com.alan.pms.service.product.ProductBasicService;
import com.alan.pms.service.product.impl.base.MapperBase;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/19 12:40
 */
@Service
public class ProductBasicServiceImpl extends MapperBase implements ProductBasicService {
    @Override
    public ResponseBean<ResponsePageBean> getProductInformationByPage(Integer pageNum, Integer pageSize, ProductBasicInformation product, String searchValue, String[] timeRange) {
        ResponseBean<ResponsePageBean> responseBean = new ResponseBean();
        Long total=productBasicMapper.findTotalWithCondition(product,searchValue,timeRange);
        if (total>=0){
            //总数
            ResponsePageBean<ProductBasicInformation> pageBean = new ResponsePageBean<>();
            pageBean.setTotal(total);
            //数据
            pageNum=(pageNum-1)*pageSize;
            //提前拼接searchValue
            List<ProductBasicInformation> list=productBasicMapper.findAll(pageNum,pageSize,product,searchValue,timeRange);
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
}
