package com.alan.pms.controller.authority;

import com.alan.pms.model.ResponseBean;
import com.alan.pms.service.authority.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author alan
 */
@RestController
@RequestMapping("/doLogin")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/")
    @ResponseBody
    public ResponseBean<String> doLogin(@RequestBody Map<String,String> loginForm){
        return loginService.doLogin(loginForm);
    }
}
