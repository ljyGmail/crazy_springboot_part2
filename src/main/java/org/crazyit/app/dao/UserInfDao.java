package org.crazyit.app.dao;

import org.crazyit.app.domain.UserInf;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// PagingAndSortingRepository继承了CrudRepository，它增加了排序和分页的功能
public interface UserInfDao extends CrudRepository<UserInf, Integer>, UserInfDaoCustom {

    // 下面几个方法都是方法名关键字查询
    List<UserInf> findByName(String name);

    List<UserInf> findByPasswordLike(String passPattern);

    List<UserInf> findByAgeBetween(int start, int end);

    List<UserInf> findByNameContainsAndPasswordStartsWith(String subName, String passPrefix);

    // 通过@Query指定查询语句
    @Query("select * from user_inf where name like :namePattern and age > :minAge")
    List<UserInf> findBySql(String namePattern, int minAge);

    @Query("update user_inf set name = :name where user_id = :id")
    @Modifying
        // 增加@Modifying注解表明该方法会修改数据
    int updateNameById(String name, Integer id);
}
