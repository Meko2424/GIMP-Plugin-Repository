package com.GIMP_plugin_repository.User.Model;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.Tag.Model.Tag;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @JsonIgnore
    private String password;
    private String role;

    @ManyToMany
    @JoinTable(name = "userDownload",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "plugin_id")
    )
    private List<Plugin> plugins;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;




}
