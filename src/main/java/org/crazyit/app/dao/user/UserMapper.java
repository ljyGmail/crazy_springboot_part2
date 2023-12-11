package org.crazyit.app.dao.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.crazyit.app.domain.user.User;

@Mapper
public interface UserMapper {
    @Insert("insert into user_inf values(null, #{name}, #{password}, #{age})")
    Integer save(User user);

    @Update("update user_inf set name = #{name} where user_id = #{id}")
    Integer updateNameById(String name, Integer id);
}
