package com.GIMP_plugin_repository.Plugin.Dto;

import com.GIMP_plugin_repository.Author.Dto.AuthorDto;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;

import java.util.List;
import java.util.stream.Collectors;


import lombok.*;


@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginDto {
    private Long id;
    private String title;
    private String description;
    private String authorName;
    private List<PluginVersionDto> pluginVersions;




}

 // Map the request body with PluginDto object and save it into the database and sending back into the
// response using the same PluginDto object
