package org.crazyit.app.dao;

import io.r2dbc.spi.Row;
import org.crazyit.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class UserDaoCustomImpl implements UserDaoCustom {

    @Autowired
    private DatabaseClient dbClient;
    private Function<Row, User> mappingFunc = row -> {
        var user = new User(row.get("name", String.class),
                row.get("password", String.class),
                row.get("age", Integer.class));
        user.setId(row.get("user_id", Integer.class));
        return user;
    };

    @Override
    public Flux<User> customQuery1(int startAge, int endAge) {
        System.out.println(startAge + "@" + endAge);
//        return dbClient.sql("select * from user_inf where age between :0 and :1")
//                .bind(0, startAge)
//                .bind(1, endAge)
////                .map(mappingFunc)
//                .map(
//                        row -> {
//                            System.out.println("aaaaaaaa");
//                            var user = new User(row.get("name", String.class),
//                                    row.get("password", String.class),
//                                    row.get("age", Integer.class));
//                            user.setId(row.get("user_id", Integer.class));
//                            return user;
//                        }
//                )
//                .all();
        DatabaseClient.GenericExecuteSpec sql = dbClient.sql("select * from user_inf where age between :0 and :1");
        DatabaseClient.GenericExecuteSpec bind = sql.bind(0, startAge);
        DatabaseClient.GenericExecuteSpec bind1 = bind.bind(1, endAge);
        RowsFetchSpec<User> map = bind1.map(row -> {
            var user = new User(row.get("name", String.class),
                    row.get("password", String.class),
                    row.get("age", Integer.class));
            user.setId(row.get("user_id", Integer.class));
            return user;
        });

        Flux<User> all = map.all();
        return all;
    }

    @Override
    public Flux<User> customQuery2(int startAge, String passPattern) {
        return dbClient.sql("select * from user_inf where age > :0 and password like :1")
                .bind(0, startAge)
                .bind(1, passPattern)
                .map(row -> {
                    var user = new User(row.get("name", String.class),
                            row.get("password", String.class),
                            row.get("age", Integer.class));
                    user.setId(row.get("user_id", Integer.class));
                    return user;
                })
                .all();
    }
}
