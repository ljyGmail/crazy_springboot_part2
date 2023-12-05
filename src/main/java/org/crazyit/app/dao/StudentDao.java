package org.crazyit.app.dao;

import org.crazyit.app.domain.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
}
