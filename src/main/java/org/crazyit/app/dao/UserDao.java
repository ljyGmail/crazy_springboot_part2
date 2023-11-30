package org.crazyit.app.dao;

import org.crazyit.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

// PagingAndSortingRepository继承了CrudRepository，它增加了排序和分页的功能
public interface UserDao extends JpaRepository<User, Integer> {
}
