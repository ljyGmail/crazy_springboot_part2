package org.crazyit.app.dao;

import org.crazyit.app.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface StudentDao extends CrudRepository<Student, Integer>, QueryByExampleExecutor<Student> {
}
