package org.crazyit.app.dao;

import org.crazyit.app.domain.User;

import java.util.List;

public interface UserDao {
    int delete(Integer id);

    List<User> findByAgeBetween(int startAge, int endAge);
}
