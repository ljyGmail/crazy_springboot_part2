package org.crazyit.app;

import org.crazyit.app.dao.StudentDao;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @ParameterizedTest
    @ValueSource(strings = {"孙%", "白%"})
    public void testCustomQuery(String namePattern) {
        studentDao.customQuery(namePattern).forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"18, 20", "20, 25"})
    public void testCustomSqlQuery(int startAge, int endAge) {
        studentDao.customSqlQuery(startAge, endAge)
                .forEach(System.out::println);
    }
}
