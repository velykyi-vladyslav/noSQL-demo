package velykyi.vladyslav.NoSQLDemo.service;

import velykyi.vladyslav.NoSQLDemo.dao.sql.User;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;
import velykyi.vladyslav.NoSQLDemo.dto.UserSummaryDto;

public interface UserService {
    User getUserById(int id);

    UserDto save(UserDto user);

    UserSummaryDto saveUserSummaryMongo(UserSummaryDto user);

    int migrateUserSummaryToMongo();

    void getBirthData();
}
