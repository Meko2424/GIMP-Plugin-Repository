package com.GIMP_plugin_repository.BackEnd.User.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginDto {


    private String emailId;
    private String password;
//    private String role;

}
