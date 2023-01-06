package com.kodilla.travel_backend.mapper;

import com.kodilla.travel_backend.domain.User;
import com.kodilla.travel_backend.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getPhoneNumber()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPhoneNumber()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(s -> mapToUserDto(s))
                .collect(Collectors.toList());
    }
}
