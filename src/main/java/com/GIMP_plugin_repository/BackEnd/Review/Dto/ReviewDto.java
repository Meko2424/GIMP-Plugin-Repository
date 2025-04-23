//package com.GIMP_plugin_repository.BackEnd.Review.Dto;
//
//import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
//import com.GIMP_plugin_repository.BackEnd.User.Model.User;
//import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ReviewDto {
//
//    private Long id;
//    private Long rating;
//    private String comment;
//    private LocalDate reviewDate = LocalDate.now();
//    private User user;
//    private Plugin plugin;
//
//}
