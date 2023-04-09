package com.ichigo.imserver.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    /**
     * 验证账户密码是否正确
     * */
    public int verifyPassword(String username, String password);
}
