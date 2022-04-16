package velykyi.vladyslav.NoSQLDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;
import velykyi.vladyslav.NoSQLDemo.dto.UserSummaryDto;
import velykyi.vladyslav.NoSQLDemo.service.impl.UserServiceImpl;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("create")
    @ResponseStatus(CREATED)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PostMapping("createUserSummary")
    @ResponseStatus(CREATED)
    public UserSummaryDto createUserSummary(@RequestBody UserSummaryDto userSummaryDto) {
        return userService.saveUserSummaryMongo(userSummaryDto);
    }

    @PostMapping("migrate")
    @ResponseStatus(CREATED)
    public String migrateUserSummary() {
        return String.format("Migrated count of entities: %o", userService.migrateUserSummaryToMongo());
    }

    @GetMapping("getBirthData")
    @ResponseStatus(OK)
    public void getBirthData() {
        userService.getBirthData();
    }
}
