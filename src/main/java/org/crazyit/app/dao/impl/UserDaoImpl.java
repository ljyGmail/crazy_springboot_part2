package org.crazyit.app.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.crazyit.app.dao.UserDao;
import org.crazyit.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int delete(Integer id) {
        return sqlSession.delete("org.crazyit.app.dao.UserMapper.delete", id);
    }

    @Override
    public List<User> findByAgeBetween(int startAge, int endAge) {
        return sqlSession.selectList("org.crazyit.app.dao.UserMapper.findByAgeBetween",
                Map.of("startAge", startAge, "endAge", endAge));
    }
}
