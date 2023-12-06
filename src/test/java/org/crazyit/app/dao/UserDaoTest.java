package org.crazyit.app.dao;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @ParameterizedTest
    @ValueSource(ints = {15, 16})
    public void testDelete(Integer id) {
        System.out.println("受影响的记录条数: " + userDao.delete(id));
    }

    @ParameterizedTest
    @CsvSource({"18, 20", "22, 25"})
    public void testFindByAgeBetween(int startAge, int endAge) {
        userDao.findByAgeBetween(startAge, endAge).forEach(System.out::println);
    }
}
