package velykyi.vladyslav.NoSQLDemo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import velykyi.vladyslav.NoSQLDemo.dao.mongo.UserMongo;

public interface UserMongoRepository extends MongoRepository<UserMongo, Integer> {

    @Override
    <S extends UserMongo> S save(S entity);
}
