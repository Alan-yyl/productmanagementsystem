package com.alan.pms.service.authority;

import com.alan.pms.model.ResponseBean;

import java.util.Map;

/**
 * @Author: Alan
 * @Date: 2021/1/2 10:36
 */
public interface LoginService {
    /**
     * 登录
     * @param loginForm
     * @return
     */
    ResponseBean<String> doLogin(Map<String,String> loginForm);
}
