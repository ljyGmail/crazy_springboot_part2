package org.crazyit.app.dao;

import org.crazyit.app.domain.User;

import java.util.List;

public interface UserDao {
    User get(Integer id);

    int save(User user);

    int update(User user);

    int delete(User user);

    int delete(Integer id);

    List<String> findNameByAgeBetween(int startAge, int endAge);

    List<User> findByNameLike1(String name);

    List<User> findByNameLike2(String name);
}
