package velykyi.vladyslav.NoSQLDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import velykyi.vladyslav.NoSQLDemo.dto.UserSummaryDto;
import velykyi.vladyslav.NoSQLDemo.service.UserSummaryService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("userSummary")
public class UserSummaryController {

    private final UserSummaryService userSummaryService;

    @PostMapping("create")
    @ResponseStatus(CREATED)
    public UserSummaryDto createUserSummary(@RequestBody UserSummaryDto userSummaryDto) {
        return userSummaryService.saveUserSummaryMongo(userSummaryDto);
    }

    @PostMapping("migrate")
    @ResponseStatus(CREATED)
    public String migrateUserSummary() {
        return String.format("Migrated count of entities: %o", userSummaryService.migrateUserSummaryToMongo());
    }

    @GetMapping("getBirthData")
    @ResponseStatus(OK)
    public List<UserSummaryDto> getBirthData(@RequestParam String place) {
        return userSummaryService.getBirthData(place);
    }
}
