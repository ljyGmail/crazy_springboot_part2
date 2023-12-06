package org.crazyit.app.dao;

import org.apache.ibatis.annotations.*;
import org.crazyit.app.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select(value = "select user_id id, name, password, age from "
            + "user_inf where user_id = #{b}")
    User get(Integer id);

    @Insert("insert into user_inf values "
            + "(null, #{name}, #{password}, #{age})")
    int save(User user);

    @Update("update user_inf set name=#{name}, "
            + "password=#{password} where user_id=#{id}")
    int update(User user);

    @Delete("delete from user_inf where user_id=#{a}")
    int delete(Integer id);

    @Select("select user_id id, name, password, age from "
            + "user_inf where age between #{startAge} and #{endAge}")
    List<User> findByAgeBetween(int startAge, int endAge);

    @Select("select user_id id, name, password, age from "
            + "user_inf where name like #{name}")
    List<User> findByNameLike(String name);
}
