package org.crazyit.app.service;

import org.crazyit.app.dao.UserDao;
import org.crazyit.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class UserService implements CommandLineRunner {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        testSave();
    }

    public void testSave() {
        System.out.println("===== " + dataSource);
        for (var i = 1; i < 6; i++) {
            var user = new User("c3p0-customize", '女', 40 + i);
            userDao.save(user);
        }
    }
}
