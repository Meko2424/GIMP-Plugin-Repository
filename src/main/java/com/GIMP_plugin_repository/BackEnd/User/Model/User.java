//package com.GIMP_plugin_repository.BackEnd.User.Model;
//
//import com.GIMP_plugin_repository.BackEnd.Download.Model.DownloadPlugin;
//import com.GIMP_plugin_repository.BackEnd.Review.Model.Review;
//import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
//    private Long id;
//    private String name;
//    private String email;
//    private String password;
//    //private UserRole role;
//
//    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<DownloadPlugin> downloads;
//
//    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<PluginVersion> pluginVersions;
//
//    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<Review> reviews;
//
//
//
//
//}
