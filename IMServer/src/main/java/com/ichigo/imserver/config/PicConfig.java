package com.ichigo.imserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class PicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //定位歌手头像
        registry.addResourceHandler("img/singerPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img" +
                        System.getProperty("file.separator") + "singerPic" + System.getProperty("file.separator")
        );
        //定位歌曲头像
        registry.addResourceHandler("img/songPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img" +
                        System.getProperty("file.separator") + "songPic" + System.getProperty("file.separator")
        );
        //定位歌单头像
        registry.addResourceHandler("img/songListPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img" +
                        System.getProperty("file.separator") + "songListPic" + System.getProperty("file.separator")
        );
        //定位歌曲
        registry.addResourceHandler("song/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "song" +
                        System.getProperty("file.separator")
        );
    }
}
