package com.GIMP_plugin_repository.BackEnd.User.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer  id;

    private String firstName;

    private String lastName;

    private String emailId;

    @JsonIgnore
    private String password;

//    private String role;
}
