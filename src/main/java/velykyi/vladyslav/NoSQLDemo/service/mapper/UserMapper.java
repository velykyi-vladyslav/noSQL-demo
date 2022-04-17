package velykyi.vladyslav.NoSQLDemo.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import velykyi.vladyslav.NoSQLDemo.dao.mongo.UserMongo;
import velykyi.vladyslav.NoSQLDemo.dao.mongo.UserSummaryMongo;
import velykyi.vladyslav.NoSQLDemo.dao.sql.User;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;
import velykyi.vladyslav.NoSQLDemo.dto.UserSummaryDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    UserDto userMongoToUserDto (UserMongo userMongo);

    @Mapping(source = "userSummary", target = "userSummary", qualifiedByName = "dtoToUserSummaryMongo")
    UserMongo userDtoToUserMongo (UserDto userDto);

    @Named("dtoToUserSummaryMongo")
    UserSummaryMongo dtoToUserSummaryMongo(UserSummaryDto userSummaryDto);

    UserSummaryDto userSummaryMongoToDto(UserSummaryMongo userSummaryMongo);

    List<UserMongo> mapUserList (List<User> userSummaryList);

    List<UserDto> mapUserMongoList (List<UserMongo> userSummaryList);
}
