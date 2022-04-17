package velykyi.vladyslav.NoSQLDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;
import velykyi.vladyslav.NoSQLDemo.service.impl.UserServiceImpl;

import static org.springframework.http.HttpStatus.CREATED;

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
}
