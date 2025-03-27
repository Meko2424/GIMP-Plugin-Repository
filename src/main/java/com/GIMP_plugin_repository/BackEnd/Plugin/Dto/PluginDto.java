package com.GIMP_plugin_repository.BackEnd.Plugin.Dto;

import com.GIMP_plugin_repository.BackEnd.Version.Dto.PluginVersionDto;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginDto {
    private Long id;
    private String title;
    private String description;
    private String authorName;
    private String categoryName;
    private List<PluginVersionDto> pluginVersions;


    //=============== New added ================= //




}

 // Map the request body with PluginDto object and save it into the database and sending back into the
// response using the same PluginDto object
