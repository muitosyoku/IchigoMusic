package com.ichigo.imserver.util;

/**
 * 用于与前端沟通的五位状态码
 * 最后一位代表操作是否成功：
 * 1：成功
 * 0：失败
 * ---------------------------------------------------------
 * 倒数第二位代表操作种类
 * 0：查询
 * 1：插入
 * 2：修改
 * 3：删除
 * ---------------------------------------------------------
 * 倒数第三位代表返回类型
 * 0：普通对象
 * 1：集合
 * ---------------------------------------------------------
 * 倒数第四位代表操作对象
 * 0：管理员
 * 1：歌手
 * 2：用户
 * 3：歌曲
 * 4：歌单
 * 5：评论
 */
public class Code {

    //管理员登录状态码
    public static final Integer ADMIN_LOGIN_SUCCESS = 40001;
    public static final Integer ADMIN_LOGIN_FAIL = 40000;

    //歌手操作状态码
    public static final Integer SINGER_INSERT_SUCCESS = 41011;
    public static final Integer SINGER_INSERT_FAIL = 41010;

    public static final Integer SINGERAVATOR_UPLOAD_SUCCESS = 41111;
    public static final Integer SINGERAVATOR_UPLOAD_FAIL = 41110;

    public static final Integer SINGER_UPDATE_SUCCESS = 41021;
    public static final Integer SINGER_UPDATE_FAIL = 41020;

    public static final Integer SINGER_DELETE_SUCCESS = 41031;
    public static final Integer SINGER_DELETE_FAIL = 41030;

    public static final Integer SINGER_SELECT_SUCCESS = 41001;
    public static final Integer SINGER_SELECT_FAIL = 41000;
}
