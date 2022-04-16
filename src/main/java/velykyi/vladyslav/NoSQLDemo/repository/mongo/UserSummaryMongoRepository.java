package velykyi.vladyslav.NoSQLDemo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import velykyi.vladyslav.NoSQLDemo.dao.mongo.UserSummaryMongo;

public interface UserSummaryMongoRepository extends MongoRepository<UserSummaryMongo, Long> {
}
