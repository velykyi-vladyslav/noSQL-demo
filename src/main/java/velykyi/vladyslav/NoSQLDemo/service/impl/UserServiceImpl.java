package velykyi.vladyslav.NoSQLDemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import velykyi.vladyslav.NoSQLDemo.dao.sql.User;
import velykyi.vladyslav.NoSQLDemo.dto.UserDto;
import velykyi.vladyslav.NoSQLDemo.repository.sql.UserRepository;
import velykyi.vladyslav.NoSQLDemo.service.UserService;
import velykyi.vladyslav.NoSQLDemo.service.mapper.UserMapper;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public UserDto save(UserDto user) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(user)));
    }
}
