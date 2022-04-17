package velykyi.vladyslav.NoSQLDemo.service;

import velykyi.vladyslav.NoSQLDemo.dao.sql.User;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;

public interface UserService {

    User getUserById(int id);

    UserDto save(UserDto user);
}
