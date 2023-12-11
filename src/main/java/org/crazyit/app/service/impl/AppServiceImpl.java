package org.crazyit.app.service.impl;

import org.crazyit.app.dao.news.NewsMapper;
import org.crazyit.app.dao.user.UserMapper;
import org.crazyit.app.domain.news.News;
import org.crazyit.app.domain.user.User;
import org.crazyit.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppServiceImpl implements AppService {

    private UserMapper userMapper;
    private NewsMapper newsMapper;

    @Autowired
    public AppServiceImpl(UserMapper userMapper, NewsMapper newsMapper) {
        this.userMapper = userMapper;
        this.newsMapper = newsMapper;
    }

    // 全局事务，自动注入容器中Primary的JTA全局事务管理器
    @Transactional
    @Override
    public void saveUserAndNews() {
        var news = new News("bbbb", "bbbbbbbbbbbbbbbbbbb");
        newsMapper.save(news);

        var user = new User("aaaa", "aaaaaaaaaa", 21);
        userMapper.save(user);
    }

    // 全局事务，自动注入容器中Primary的JTA全局事务管理器
    @Transactional
    @Override
    public void updateUserAndNews() {
        System.out.println(newsMapper.updateTitleById("two", 2));
        System.out.println(userMapper.updateNameById("three", 2));
    }
}
