package org.crazyit.app.dao;

import org.crazyit.app.domain.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void testGet(Integer id) {
        System.out.println(userMapper.get(id));
    }

    @ParameterizedTest
    @CsvSource({"fkjava, fkjava123, 23", "crazyit, crazyit23, 24"})
    public void testSave(String name, String password, int age) {
        var user = new User(name, password, age);
        System.out.println("受影响的记录条数: " + userMapper.save(user));
    }

    @ParameterizedTest
    @CsvSource({"19, foo", "20, bar"})
    public void testUpdate(Integer id, String name) {
        var user = userMapper.get(id);
        user.setName(name);
        System.out.println("受影响的记录条数: " + userMapper.update(user));
    }

    @ParameterizedTest
    @ValueSource(ints = {19, 20})
    public void testDelete(Integer id) {
        System.out.println("受影响的记录条数: " + userMapper.delete(id));
    }

    @ParameterizedTest
    @CsvSource({"18, 20", "22, 25"})
    public void testFindByAgeBetween(int startAge, int endAge) {
        userMapper.findByAgeBetween(startAge, endAge).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"玉面%", "白%"})
    public void testFindByNameLike(String name) {
        userMapper.findByNameLike(name)
                .forEach(System.out::println);
    }
}
