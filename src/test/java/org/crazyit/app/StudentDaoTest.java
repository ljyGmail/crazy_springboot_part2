package org.crazyit.app;

import jakarta.transaction.Transactional;
import org.crazyit.app.dao.StudentDao;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @ParameterizedTest
    @ValueSource(strings = {"%训练营", "%基础班"})
    public void testFindByClazzNameJPQL(String clazzName) {
        studentDao.findByClazzNameJPQL(clazzName).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%就业班", "%提高班"})
    public void testFindByClazzNameNative(String clazzName) {
        studentDao.findByClazzNameNative(clazzName).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%训练营", "%基础班"})
    public void testFindNameAndGenderByClazzNameJPQL1(String clazzName) {
        studentDao.findNameAndGenderByClazzNameJPQL1(clazzName).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"%训练营", "%基础班"})
    public void testFindNameAndGenderByClazzNameJPQL2(String clazzName) {
        studentDao.findNameAndGenderByClazzNameJPQL2(clazzName).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%训练营", "%基础班"})
    public void testFindNameAndGenderByClazzNameJPQL3(String clazzName) {
        studentDao.findNameAndGenderByClazzNameJPQL3(clazzName).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%训练营", "%基础班"})
    public void testFindNameAndGenderByClazzNameJPQL4(String clazzName) {
        studentDao.findNameAndGenderByClazzNameJPQL4(clazzName)
                .forEach(map -> map.forEach((key, val) -> System.out.println(key + "-->" + val)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"%训练营", "%基础班"})
    public void testFindNameAndGenderByClazzNameJPQL5(String className) {
        studentDao.findNameAndGenderByClazzNameJPQL5(className).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }


    @Transactional
    @ParameterizedTest
    @CsvSource({"Spring企业开发, 1", "Spring Boot提高班, 2"})
//    @Rollback(value = false)
    public void testUpdateClazzNameById(String clazzName, Integer id) {
        System.out.println(studentDao.updateClazzNameById(clazzName, id));
    }

    @Transactional
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
//    @Rollback(value = false)
    public void testDeleteClazzById(Integer id) {
        System.out.println(studentDao.deleteClazzById(id));
    }

    @ParameterizedTest
    @CsvSource({"%提高班, 女", "%基础班, 女"})
    public void testNamedJpql(String clazzNamePattern, char gender) {
        studentDao.namedJpql(clazzNamePattern, gender).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%训练营", "%基础班"})
    public void testNamedSql(String clazzNamePattern) {
        studentDao.namedSql(clazzNamePattern).forEach(System.out::println);
    }
}