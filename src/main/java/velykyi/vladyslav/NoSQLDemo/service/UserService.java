package velykyi.vladyslav.NoSQLDemo.service;

import velykyi.vladyslav.NoSQLDemo.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto user);

    UserDto saveMongo(UserDto user);

    int migrateUserToMongo();

    List<UserDto> getUserWithNullField(String field);
}
