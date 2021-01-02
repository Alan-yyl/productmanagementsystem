package com.alan.pms.mapper.authority;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Author: Alan
 * @Date: 2021/1/2 10:39
 */
public interface LoginMapper {
    /**
     * 登录验证
     * @param loginForm
     * @return
     */
    Integer doLogin(@Param("loginForm") Map<String,String> loginForm);
}
