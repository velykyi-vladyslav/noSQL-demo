package velykyi.vladyslav.NoSQLDemo.service.mapper;

import org.mapstruct.Mapper;
import velykyi.vladyslav.NoSQLDemo.dao.sql.User;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
