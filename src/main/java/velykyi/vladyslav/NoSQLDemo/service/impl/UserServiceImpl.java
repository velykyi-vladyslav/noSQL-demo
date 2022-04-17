package velykyi.vladyslav.NoSQLDemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import velykyi.vladyslav.NoSQLDemo.dao.mongo.UserMongo;
import velykyi.vladyslav.NoSQLDemo.dao.sql.User;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;
import velykyi.vladyslav.NoSQLDemo.repository.mongo.UserMongoRepository;
import velykyi.vladyslav.NoSQLDemo.repository.sql.UserRepository;
import velykyi.vladyslav.NoSQLDemo.service.UserService;
import velykyi.vladyslav.NoSQLDemo.service.mapper.UserMapper;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMongoRepository userMongoRepository;

    private final UserMapper userMapper;

    private final MongoTemplate mongoTemplate;

    @Override
    public UserDto save(UserDto user) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(user)));
    }

    @Override
    public UserDto saveMongo(UserDto user) {
        return userMapper.userMongoToUserDto(userMongoRepository.save(userMapper.userDtoToUserMongo(user)));
    }

    @Override
    public int migrateUserToMongo() {
        List<User> users = userRepository.findAll();

        List<UserMongo> userMongoList = userMongoRepository.saveAll(userMapper.mapUserList(users));

        return userMongoList.size();
    }

    @Override
    public List<UserDto> getUserWithNullField(String field) {
        MatchOperation filterStates = match(new Criteria(field).isNull());
        Aggregation aggregation = newAggregation(filterStates);

        AggregationResults<UserMongo> result =
                mongoTemplate.aggregate(aggregation, "user", UserMongo.class);

        return userMapper.mapUserMongoList(result.getMappedResults());
    }
}
