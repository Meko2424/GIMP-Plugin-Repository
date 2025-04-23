package com.GIMP_plugin_repository.BackEnd.Version.Dto;

import com.GIMP_plugin_repository.BackEnd.Plugin.Dto.PluginDto;
//import com.GIMP_plugin_repository.BackEnd.Review.Dto.ReviewDto;
//import com.GIMP_plugin_repository.BackEnd.User.Dto.UserDto;
import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginVersionDto {
    private Long id;
    private String versionNumber;
    private LocalDate uploadDate = LocalDate.now();

}
