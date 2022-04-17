package velykyi.vladyslav.NoSQLDemo.service;

import velykyi.vladyslav.NoSQLDemo.dto.UserSummaryDto;

import java.util.List;

public interface UserSummaryService {
    UserSummaryDto saveUserSummaryMongo(UserSummaryDto userSummaryDto);

    int migrateUserSummaryToMongo();

    List<UserSummaryDto> getBirthData(String place);
}
