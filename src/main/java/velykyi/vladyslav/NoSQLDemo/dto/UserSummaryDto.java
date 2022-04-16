package velykyi.vladyslav.NoSQLDemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSummaryDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("placeOfBirth")
    private String placeOfBirth;

    @JsonProperty("otherDetails")
    private String otherDetails;
}
