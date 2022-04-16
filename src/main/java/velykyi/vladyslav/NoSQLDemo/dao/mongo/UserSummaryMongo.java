package velykyi.vladyslav.NoSQLDemo.dao.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Entity for mongoDB collection.
 * <p>{@link org.springframework.data.mongodb.core.mapping.Document} is used here
 * to use/create the collection for the entity in mongoDB.
 */
@Data
@Document("user_summary_doc")
public class UserSummaryMongo {

    @Id
    private int id;

    private Date dateOfBirth;

    private String placeOfBirth;

    private String otherDetails;
}
