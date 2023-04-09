package com.ichigo.imserver.dao;

import com.ichigo.imserver.domain.Singer;
import com.ichigo.imserver.domain.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

//歌手dao
@Repository
public interface SongMapper {
    /**
     * 增加歌曲
     */
    public int insert(Song song);

    /**
     * 修改歌曲
     */
    public int update(Song song);

    /**
     * 删除歌曲
     */
    public int delete(Integer id);

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
