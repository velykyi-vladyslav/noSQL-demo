package velykyi.vladyslav.NoSQLDemo.service.mapper;

import org.mapstruct.Mapper;
import velykyi.vladyslav.NoSQLDemo.dao.mongo.UserSummaryMongo;
import velykyi.vladyslav.NoSQLDemo.dao.sql.UserSummary;
import velykyi.vladyslav.NoSQLDemo.dto.UserSummaryDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserSummaryMongoMapper {

    UserSummaryDto userSummaryMongoToDto(UserSummaryMongo userSummaryMongo);

    UserSummaryMongo dtoToUserSummaryMongo(UserSummaryDto userSummaryDto);

    List<UserSummaryMongo> mapUserSummaryList (List<UserSummary> userSummaryList);
}
