package com.GIMP_plugin_repository.BackEnd.Review.Dto;

import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Long id;
    private Long rating;
    private String comment;
//    private User user;
    @JsonIgnore
    private PluginVersion pluginVersion;


    private LocalDate reviewDate = LocalDate.now();

}
