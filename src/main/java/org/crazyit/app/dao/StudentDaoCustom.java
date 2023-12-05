package org.crazyit.app.dao;

import org.crazyit.app.domain.Student;

import java.util.List;

public interface StudentDaoCustom {
    List<Student> customQuery(String namePattern);

    List<Student> customSqlQuery(int startAge, int endAge);
}
