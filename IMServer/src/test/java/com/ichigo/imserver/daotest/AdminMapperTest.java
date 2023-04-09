package com.ichigo.imserver.daotest;

import com.ichigo.imserver.dao.AdminMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.ichigo.imserver.dao")
public class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;
    @Test
    public void verifyPasswordTest(){
        int num = adminMapper.verifyPassword("admin", "123456");
        System.out.println(num);
    }
}
