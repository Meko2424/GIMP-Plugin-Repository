package com.GIMP_plugin_repository.BackEnd.Download.Dto;

import com.GIMP_plugin_repository.BackEnd.User.Model.User;
import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DownloadPluginDto {
    private Long id;
    private LocalDate downloadDate  = LocalDate.now();
    private User user;
    private PluginVersion pluginVersion;
//    private List<ReviewDto> reviews;
}
