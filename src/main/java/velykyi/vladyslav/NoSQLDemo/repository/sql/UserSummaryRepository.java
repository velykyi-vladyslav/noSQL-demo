package velykyi.vladyslav.NoSQLDemo.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import velykyi.vladyslav.NoSQLDemo.dao.sql.User;
import velykyi.vladyslav.NoSQLDemo.dao.sql.UserSummary;

public interface UserSummaryRepository extends JpaRepository<UserSummary, Integer> {
}
