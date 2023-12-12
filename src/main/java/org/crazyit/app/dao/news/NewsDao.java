package org.crazyit.app.dao.news;

import org.crazyit.app.domain.news.News;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NewsDao extends CrudRepository<News, Integer> {
    @Query("update News n set n.title = ?1 where n.id = ?2")
    @Modifying
    Integer updateTitleById(String title, Integer id);
}
