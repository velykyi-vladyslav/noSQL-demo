package velykyi.vladyslav.NoSQLDemo.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import velykyi.vladyslav.NoSQLDemo.dao.mongo.UserSummaryMongo;
import velykyi.vladyslav.NoSQLDemo.dao.sql.UserSummary;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserSummaryTest {

    @ParameterizedTest
    @MethodSource("getDeclaredFields")
    void shouldHaveSameFieldNames(String declaredField) throws NoSuchFieldException {
        Field field = UserSummary.class.getDeclaredField(declaredField);
        Field fieldMongo = UserSummaryMongo.class.getDeclaredField(declaredField);

        assertNotNull(field);
        assertNotNull(fieldMongo);
    }

    @ParameterizedTest
    @MethodSource("getDeclaredFields")
    void shouldHaveSameFieldTypes(String declaredField) throws NoSuchFieldException {
        Class<?> type = UserSummary.class.getDeclaredField(declaredField).getType();
        Class<?> typeMongo = UserSummaryMongo.class.getDeclaredField(declaredField).getType();

        assertEquals(typeMongo, type);
    }

    private static Stream<String> getDeclaredFields() {
        return Stream.of("id", "dateOfBirth", "placeOfBirth", "otherDetails");
    }
}
