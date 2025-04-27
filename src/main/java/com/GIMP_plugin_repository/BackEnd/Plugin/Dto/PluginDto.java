package com.GIMP_plugin_repository.BackEnd.Plugin.Dto;

import com.GIMP_plugin_repository.BackEnd.Version.Dto.PluginVersionDto;

import java.util.List;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginDto {
    private Long id;
    private String title;
    private String description;
    private String authorName;
    private String imageUrl;
    private String fileUrl;

    private List<PluginVersionDto> pluginVersions;



}


