package velykyi.vladyslav.NoSQLDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;
import velykyi.vladyslav.NoSQLDemo.service.impl.UserServiceImpl;

import java.util.List;

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

    @PostMapping("createMongo")
    @ResponseStatus(CREATED)
    public UserDto createUserMongo(@RequestBody UserDto userDto) {
        return userService.saveMongo(userDto);
    }

    @PostMapping("migrate")
    @ResponseStatus(CREATED)
    public String migrateUserSummary() {
        return String.format("Migrated count of entities: %o", userService.migrateUserToMongo());
    }

    @GetMapping("null")
    @ResponseStatus(OK)
    public List<UserDto> getUserWithNullField(@RequestParam String field) {
        return userService.getUserWithNullField(field);
    }
}
