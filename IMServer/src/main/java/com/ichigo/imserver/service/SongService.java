package com.ichigo.imserver.service;

import com.ichigo.imserver.domain.Singer;
import com.ichigo.imserver.domain.Song;

import java.util.List;

public interface SongService {
    /**
     * 增加歌曲
     */
    public boolean insert(Song song);

    /**
     * 修改歌曲
     */
    public boolean update(Song song);

    /**
     * 删除歌曲
     */
    public boolean delete(Integer id);

    /**
     * 根据id查询歌曲
     */
    public Song selectById(Integer id);

    /**
     * 查询所有歌曲
     */
    public List<Song> selectAllSong();

    /**
     * 根据歌曲名模糊查询
     */
    public List<Song> selectByName(String name);

    /**
     * 根据歌手性别查询
     */
    public List<Song> selectBySingerId(Integer singerId);
}
