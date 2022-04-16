package velykyi.vladyslav.NoSQLDemo.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import velykyi.vladyslav.NoSQLDemo.dao.sql.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer id);

    @Override
    <S extends User> S save(S entity);
}
