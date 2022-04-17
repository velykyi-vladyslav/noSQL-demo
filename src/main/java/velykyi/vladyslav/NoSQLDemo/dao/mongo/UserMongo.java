package velykyi.vladyslav.NoSQLDemo.dao.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document("user")
public class UserMongo {

    @Id
    private int id;

    private String name;

    private String surname;

    private String email;

    private UserSummaryMongo userSummary;
}
