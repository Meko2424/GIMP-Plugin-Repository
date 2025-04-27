package com.GIMP_plugin_repository.BackEnd.User.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {
    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

//    private String role;

}


