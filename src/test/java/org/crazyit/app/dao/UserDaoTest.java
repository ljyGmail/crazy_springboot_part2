package org.crazyit.app.dao;

import org.crazyit.generated.tables.records.UserInfRecord;
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
    @CsvSource({"周星驰, 123456, 60", "吴孟达, 665544, 70"})
    public void testSave(String name, String password, int age) {
        var user = new UserInfRecord(null, name, password, age);
        System.out.println("插入的记录条数: " + userDao.save(user));
    }

    @ParameterizedTest
    @CsvSource({"包龙星, foo123, 13", "方唐镜, bar123, 14"})
    public void testUpdateById(String name, String password, Integer id) {
        System.out.println("更新的记录条数: " + userDao.updateById(name, password, id));
    }

    @ParameterizedTest
    @CsvSource({"猪八戒, zhu123", "白鼠精, bai1234"})
    public void testFindByNameAndPassword(String name, String password) {
        userDao.findByNameAndPassword(name, password)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"18, 20", "22,  25"})
    public void testFindByAgeBetween(int startAge, int endAge) {
        userDao.findByAgeBetween(startAge, endAge)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {500, 600})
    public void testFindNameByAgeGreatThan(int startAge) {
        userDao.findNameByAgeGreatThan(startAge)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 22})
    public void testFindNamePasswordByAgeLessThan(int endAge) {
        userDao.findNamePasswordByAgeLessThan(endAge)
                .forEach(System.out::println);
    }
}
