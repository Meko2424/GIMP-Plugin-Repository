package com.GIMP_plugin_repository.BackEnd.User.Controller;

import com.GIMP_plugin_repository.BackEnd.User.Dto.UserRegisterDto;
import com.GIMP_plugin_repository.BackEnd.User.Dto.UserLoginDto;
import com.GIMP_plugin_repository.BackEnd.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDto> registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        UserRegisterDto registeredUser = userService.registerUser(userRegisterDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginDto> loginUser(@RequestBody UserLoginDto loginDto) {
        UserLoginDto user = userService.loginUser(loginDto);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(401).build();
    }
}
