package org.crazyit.app.dao.user;

import org.crazyit.app.domain.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
    @Query("update User u set u.name = ?1  where u.id = ?2")
    @Modifying
    Integer updateNameById(String name, Integer id);
}
