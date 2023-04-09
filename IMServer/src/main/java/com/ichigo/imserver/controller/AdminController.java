package com.ichigo.imserver.controller;

import com.ichigo.imserver.service.AdminService;
import com.ichigo.imserver.util.Code;
import com.ichigo.imserver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/login/status")
    public Result loginStatus(HttpSession session,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password){
        boolean flag = adminService.verifyPassword(username,password);
        if(flag){
            session.setAttribute("username",username);
            return new Result(Code.ADMIN_LOGIN_SUCCESS,"","Login Successfully!");
        }
        return new Result(Code.ADMIN_LOGIN_FAIL,"","Username or Password is wrong");
    }
}
