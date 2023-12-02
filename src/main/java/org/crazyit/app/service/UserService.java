package org.crazyit.app.service;

import org.crazyit.app.dao.UserDao;
import org.crazyit.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class UserService implements CommandLineRunner {
    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("dataSource1")
    private DataSource dataSource1;
    @Qualifier("dataSource2")
    private DataSource dataSource2;

    @Override
    public void run(String... args) throws Exception {
        testSave();
    }

    public void testSave() {
        System.out.println("---> " + dataSource1);
        System.out.println("---> " + dataSource2);
        for (var i = 1; i < 6; i++) {
            var user = new User("multi" + i, '女', 50 + i);
            userDao.save(user);
        }
    }
}
