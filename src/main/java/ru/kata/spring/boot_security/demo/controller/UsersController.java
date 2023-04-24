package ru.kata.spring.boot_security.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.UsersService;

import java.security.Principal;


@RestController
@RequestMapping("/api/user")
public class UsersController {

    private final UsersService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UsersController(UsersService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @GetMapping({"/userinfo"})
    public UserDTO showUserInfo(Principal principal) {
        return convertToUserDTO(userService.findByUsername(principal.getName()));
    }

    private User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
