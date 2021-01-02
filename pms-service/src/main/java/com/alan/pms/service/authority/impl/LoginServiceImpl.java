package com.alan.pms.service.authority.impl;

import com.alan.pms.model.ResponseBean;
import com.alan.pms.service.authority.LoginService;
import com.alan.pms.service.base.MapperBase;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: Alan
 * @Date: 2021/1/2 10:38
 */
@Service
public class LoginServiceImpl extends MapperBase implements LoginService {
    @Override
    public ResponseBean<String> doLogin(Map<String, String> loginForm) {
        ResponseBean<String> responseBean = new ResponseBean<>();
        if (loginMapper.doLogin(loginForm) == 1) {
            responseBean.setIsFlag(true);
            responseBean.setMsg("登录成功");
            responseBean.setData("200");
            responseBean.setData(loginForm.toString());
        }else {
            responseBean.setIsFlag(false);
            responseBean.setMsg("登录失败，用户名或密码错误");
            responseBean.setData("500");
        }
        responseBean.setData(loginForm.toString());
        return responseBean;
    }
}
