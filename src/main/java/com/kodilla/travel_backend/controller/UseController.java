package com.kodilla.travel_backend.controller;

import com.kodilla.travel_backend.dto.UserDto;
import com.kodilla.travel_backend.mapper.UserMapper;
import com.kodilla.travel_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UseController {

    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping(value = "/getUsers")
    public List<UserDto> getUser() {
        return userMapper.mapToUserDtoList(userService.getAllUser());
    }

    @PutMapping(value = "/updateUser")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.save(userMapper.mapToUser(userDto)));
    }

    @PostMapping(value = "/createUser")
    public void createUser(@RequestBody UserDto userDto) {
        userService.save(userMapper.mapToUser(userDto));
    }

    @GetMapping(value = "/getUser")
    public UserDto getUser(@RequestParam Long userId) throws UserWithoutException {
        return userMapper.mapToUserDto(userService.getUser(userId).orElseThrow(UserWithoutException::new));
    }

    @DeleteMapping(value = "/deleteUser")
    public void delUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
    }
}
