package com.ichigo.imserver.service.impl;

import com.ichigo.imserver.dao.SongMapper;
import com.ichigo.imserver.domain.Song;
import com.ichigo.imserver.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;
    /**
     * 增加歌曲
     *
     * @param song
     */
    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song) > 0;
    }

    /**
     * 修改歌曲
     *
     * @param song
     */
    @Override
    public boolean update(Song song) {
        return songMapper.update(song) > 0;
    }

    /**
     * 删除歌曲
     *
     * @param id
     */
    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id) > 0;
    }

    /**
     * 根据id查询歌曲
     *
     * @param id
     */
    @Override
    public Song selectById(Integer id) {
        return songMapper.selectById(id);
    }

    /**
     * 查询所有歌曲
     */
    @Override
    public List<Song> selectAllSong() {
        return songMapper.selectAllSong();
    }

    /**
     * 根据歌曲名模糊查询
     *
     * @param name
     */
    @Override
    public List<Song> selectByName(String name) {
        return songMapper.selectByName(name);
    }

    /**
     * 根据歌手性别查询
     *
     * @param singerId
     */
    @Override
    public List<Song> selectBySingerId(Integer singerId) {
        return songMapper.selectBySingerId(singerId);
    }
}
