package com.ichigo.imserver.daotest;

import com.ichigo.imserver.dao.AdminMapper;
import com.ichigo.imserver.dao.SingerMapper;
import com.ichigo.imserver.domain.Singer;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
@MapperScan("com.ichigo.imserver.dao")
public class SingerMapperTest {
    @Autowired
    private SingerMapper singerMapper;
    @Test
    public void insertTest(){
        Singer singer = new Singer();
        Date date;
        String birthday = "1999-08-25";
        String[] birthDivide = birthday.split("-");
        Calendar c = Calendar.getInstance();
        int year = Integer.parseInt(birthDivide[0].trim());//去掉空格
        int month = Integer.parseInt(birthDivide[1].trim());
        int day = Integer.parseInt(birthDivide[2].trim());
        c.set(year,month,day);
        date = c.getTime();
        singer.setName("test");
        singer.setSex((byte) 1);
        singer.setBirth(date);
        singer.setPic("../assets/img");
        singer.setLocation("Chongqing");
        singer.setIntroduction("this is a test data");
        int cnt = singerMapper.insert(singer);
        System.out.println(cnt);
    }

    @Test
    public void updateTest(){
        Singer singer = new Singer();
        singer.setId(1);
        singer.setName("test");
        singer.setSex((byte) 1);
        singer.setPic("../assets/img");
        singer.setLocation("Chongqing");
        singer.setIntroduction("this is a test data2");
        int cnt = singerMapper.update(singer);
        System.out.println(cnt);
    }

    @Test
    public void deleteTest(){
        int cnt = singerMapper.delete(1);
        System.out.println(cnt);
    }
}
