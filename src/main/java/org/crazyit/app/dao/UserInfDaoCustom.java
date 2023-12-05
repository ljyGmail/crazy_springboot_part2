package org.crazyit.app.dao;

import org.crazyit.app.domain.UserInf;

import java.sql.SQLException;
import java.util.List;

public interface UserInfDaoCustom {
    List<UserInf> customQuery(String passPattern, int startAge, int endAge) throws SQLException;

    List<UserInf> jdbcTemplateQuery(int startAge, int endAge);
}
