package org.crazyit.app.dao;

import org.crazyit.app.domain.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer> {

    List<Student> findByAddress(String addr);

    List<Student> findByAgeGreaterThan(int start);

    List<Student> findByNameStartsWith(String namePrefix);

    List<Student> findByAgeBetweenAndAddress(int start, int end, String addr);

    // 使用属性路径的形式根据关联实体的属性进行查询
    List<Student> findByClazzNameLike(String clazzPattern);

    // 根据地址删除实体
    int deleteByAddress(String addr);

    // 传入分页参数进行分页查询
    // 通过传入Pageable, Sort等参数
    List<Student> findByClazzNameLike(String clazzPattern, Pageable pageable);

    // 同时根据多个属性，即关联属性执行查询
    List<Student> findByGenderAndAgeBetweenOrClazzNameLike(char gender, int start, int end, String clazzPattern);
}
