package com.ichigo.imserver.service.impl;

import com.ichigo.imserver.dao.AdminMapper;
import com.ichigo.imserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    /**
     * 验证用户密码是否正确
     *
     * @param username :用户名
     * @param password :密码
     * @return 是否匹配
     */
    @Override
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username,password) > 0;
    }
}
