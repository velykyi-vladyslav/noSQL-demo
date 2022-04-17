package velykyi.vladyslav.NoSQLDemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import velykyi.vladyslav.NoSQLDemo.dao.mongo.UserSummaryMongo;
import velykyi.vladyslav.NoSQLDemo.dao.sql.UserSummary;
import velykyi.vladyslav.NoSQLDemo.dto.UserSummaryDto;
import velykyi.vladyslav.NoSQLDemo.repository.mongo.UserSummaryMongoRepository;
import velykyi.vladyslav.NoSQLDemo.repository.sql.UserSummaryRepository;
import velykyi.vladyslav.NoSQLDemo.service.UserSummaryService;
import velykyi.vladyslav.NoSQLDemo.service.mapper.UserSummaryMongoMapper;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserSummaryServiceImpl implements UserSummaryService {

    private final UserSummaryRepository userSummaryRepository;

    private final UserSummaryMongoRepository userSummaryMongoRepository;

    private final UserSummaryMongoMapper userSummaryMongoMapper;

    private final MongoTemplate mongoTemplate;

    @Override
    public UserSummaryDto saveUserSummaryMongo(UserSummaryDto userSummaryDto) {
        return userSummaryMongoMapper.userSummaryMongoToDto(userSummaryMongoRepository
                .save(userSummaryMongoMapper.dtoToUserSummaryMongo(userSummaryDto)));
    }

    @Override
    public int migrateUserSummaryToMongo() {
        List<UserSummary> userSummaryDto = userSummaryRepository.findAll();
        List<UserSummaryMongo> userSummaryMongoList =
                userSummaryMongoRepository.saveAll(userSummaryMongoMapper.mapUserSummaryList(userSummaryDto));

        return userSummaryMongoList.size();
    }

    @Override
    public List<UserSummaryDto> getBirthData(String place) {
        MatchOperation filterStates = match(new Criteria("placeOfBirth").is(place));
        Aggregation aggregation = newAggregation(filterStates);

        AggregationResults<UserSummaryMongo> result = mongoTemplate.aggregate(
                aggregation, "user_summary_doc", UserSummaryMongo.class);

        return userSummaryMongoMapper.mapUserSummaryMongoList(result.getMappedResults());
    }
}
