package org.crazyit.app.dao;

import org.crazyit.app.domain.User;
import reactor.core.publisher.Flux;

public interface UserDaoCustom {
    Flux<User> customQuery1(int startAge, int endAge);

    Flux<User> customQuery2(int startAge, String passPattern);
}
