package com.GIMP_plugin_repository.Plugin.Dto;

import com.GIMP_plugin_repository.Download.Dto.DownloadPluginDto;
import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Version.Dto.PluginVersionDto;

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
    private List<PluginVersionDto> pluginVersions;

    //=============== New added ================= //

    private List<DownloadPluginDto> downloadPlugins;
    private List<ReviewDto> reviews;


}

 // Map the request body with PluginDto object and save it into the database and sending back into the
// response using the same PluginDto object
