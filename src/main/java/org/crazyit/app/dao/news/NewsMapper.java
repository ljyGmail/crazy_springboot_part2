package org.crazyit.app.dao.news;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.crazyit.app.domain.news.News;

@Mapper
public interface NewsMapper {

    @Insert("insert into news_inf (news_title, news_content)" +
            " values (#{title}, #{content})")
    Integer save(News news);

    @Update("update news_inf set news_title = #{title} where news_id = #{id}")
    Integer updateTitleById(String title, Integer id);
}
