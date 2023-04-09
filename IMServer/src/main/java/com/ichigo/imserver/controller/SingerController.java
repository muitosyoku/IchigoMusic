package com.ichigo.imserver.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ichigo.imserver.domain.PageResult;
import com.ichigo.imserver.domain.Singer;
import com.ichigo.imserver.service.SingerService;
import com.ichigo.imserver.util.Code;
import com.ichigo.imserver.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @PostMapping
    public Result addSinger(@RequestBody Singer singer){
        Result res = new Result();
        boolean flag = singerService.insert(singer);
        if(flag){
            res.setCode(Code.SINGER_INSERT_SUCCESS);
            res.setMsg("歌手插入成功");
        }else{
            res.setCode(Code.SINGER_INSERT_FAIL);
            res.setMsg("歌手插入失败");
        }
        return res;
    }

    @PutMapping
    public Result updateSinger(@RequestBody Singer singer){
        boolean flag = singerService.update(singer);
        if(flag){
            return new Result(Code.SINGER_UPDATE_SUCCESS,"","歌手修改成功");
        }else{
            return new Result(Code.SINGER_UPDATE_FAIL,null,"歌手修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result deleteSinger(@PathVariable Integer id){
        boolean flag = singerService.delete(id);
        if(flag){
            return new Result(Code.SINGER_DELETE_SUCCESS,"","歌手删除成功");
        }else{
            return new Result(Code.SINGER_DELETE_FAIL,null,"歌手删除失败");
        }
    }

    @GetMapping("/{id}")
    public Result selectSingerById(@PathVariable Integer id){
        Singer singer = singerService.selectById(id);
        if(singer != null){
            return new Result(Code.SINGER_SELECT_SUCCESS,singer,"歌手查询成功");
        }else{
            return new Result(Code.SINGER_SELECT_FAIL,"","歌手查询失败");
        }
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public Result selectSingers(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        //pagehelper用于分页查询，mybatis里正常写sql就可以达到分页查询的效果
        PageHelper.startPage(pageNum,pageSize);
        List<Singer> singers = singerService.selectAll();
        //pageInfo为查询的结果信息
        PageInfo pageInfo = new PageInfo(singers);
        //PageResult为自己封装的查询结果及数据量信息
        PageResult pageResult = new PageResult();
        pageResult.setPages(pageInfo.getPages());//总页数
        pageResult.setTotals(pageInfo.getTotal());//总数量
        pageResult.setCurrentPage(pageInfo.getPageNum());//当前页
        pageResult.setCurrentPageSize(pageInfo.getSize());//当前页的数量
        pageResult.setDatas(singers);//查询得到的数据
//        System.out.println(pageInfo);
        return new Result(Code.SINGER_SELECT_SUCCESS,pageResult,"歌手查询成功");
    }

    @GetMapping("/name/{name}")
    public Result selectSingersByName(@PathVariable String name){
            List<Singer> singers = singerService.selectByName("%" + name + "%");
            return new Result(Code.SINGER_SELECT_SUCCESS,singers,"歌手查询成功");
    }

    @GetMapping("/sex/{sex}")
    public Result selectSingersBySex(@PathVariable Integer sex){
        List<Singer> singers = singerService.selectBySex(sex);
        return new Result(Code.SINGER_SELECT_SUCCESS,singers,"歌手查询成功");
    }

    @PostMapping("/avatorupload")
    public Result avatorUpload(@RequestParam("file")MultipartFile avatorfile){
        if(avatorfile == null){
            return new Result(Code.SINGERAVATOR_UPLOAD_FAIL,"","头像上传失败！空文件");
        }
        //新的文件名=毫秒数+文件原始名
        String filename = System.currentTimeMillis() + avatorfile.getOriginalFilename();

        //存储的文件实际路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" +
                System.getProperty("file.separator") + "singerPic";
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }

        File realfile = new File(filePath + System.getProperty("file.separator") + filename);

        //数据库中存储的相对路径
        String dbFilePath = "img/singerPic/" + filename;
        try {
            //传输文件
            avatorfile.transferTo(realfile);
            return new Result(Code.SINGERAVATOR_UPLOAD_SUCCESS,dbFilePath,"头像上传成功");
        } catch (IOException e) {
            return new Result(Code.SINGERAVATOR_UPLOAD_FAIL,"","头像上传失败！空文件");
        }
    }
}
