package com.GIMP_plugin_repository.User.Controller;

import com.GIMP_plugin_repository.User.Dto.UserDto;
import com.GIMP_plugin_repository.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<UserDto> getUserById(Long id){
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
