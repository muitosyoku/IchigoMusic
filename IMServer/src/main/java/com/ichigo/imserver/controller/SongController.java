package com.ichigo.imserver.controller;

import com.ichigo.imserver.domain.Song;
import com.ichigo.imserver.service.SongService;
import com.ichigo.imserver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping()
    public Result addSong(@RequestBody Song song){
        boolean flag = songService.insert(song);
        if(flag){
            return new Result(44444,"","添加歌曲成功");
        }
        return new Result(40000,"","添加歌曲失败");
    }
}
