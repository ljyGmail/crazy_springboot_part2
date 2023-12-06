package org.crazyit.app.dao;

import org.crazyit.generated.tables.records.UserInfRecord;
import org.jooq.Record2;

import java.util.List;

public interface UserDao {
    int save(UserInfRecord user);

    int updateById(String name, String password, Integer id);

    List<UserInfRecord> findByNameAndPassword(String name, String password);

    List<UserInfRecord> findByAgeBetween(int startAge, int endAge);

    List<String> findNameByAgeGreatThan(int startAge);

    List<Record2<String, String>> findNamePasswordByAgeLessThan(int endAge);
}
