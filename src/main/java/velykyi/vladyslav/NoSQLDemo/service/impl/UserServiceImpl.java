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
import velykyi.vladyslav.NoSQLDemo.dao.sql.User;
import velykyi.vladyslav.NoSQLDemo.dao.sql.UserSummary;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;
import velykyi.vladyslav.NoSQLDemo.dto.UserSummaryDto;
import velykyi.vladyslav.NoSQLDemo.repository.sql.UserRepository;
import velykyi.vladyslav.NoSQLDemo.repository.mongo.UserSummaryMongoRepository;
import velykyi.vladyslav.NoSQLDemo.repository.sql.UserSummaryRepository;
import velykyi.vladyslav.NoSQLDemo.service.UserService;
import velykyi.vladyslav.NoSQLDemo.service.mapper.UserMapper;
import velykyi.vladyslav.NoSQLDemo.service.mapper.UserSummaryMongoMapper;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserSummaryRepository userSummaryRepository;

    private final UserSummaryMongoRepository userSummaryMongoRepository;

    private final UserMapper userMapper;

    private final UserSummaryMongoMapper userSummaryMongoMapper;

    private final MongoTemplate mongoTemplate;

    @Override
    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public UserDto save(UserDto user) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(user)));
    }

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
    public void getBirthData() {
        MatchOperation filterStates = match(new Criteria("placeOfBirth").is("Lviv"));

        Aggregation aggregation = newAggregation(filterStates);

        AggregationResults<UserSummaryMongo> result = mongoTemplate.aggregate(
                aggregation, "user_summary_doc", UserSummaryMongo.class);

        System.out.println(result.getMappedResults());
    }
}
