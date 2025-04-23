package com.GIMP_plugin_repository.BackEnd.Plugin.Dto;

import com.GIMP_plugin_repository.BackEnd.Author.Model.Author;
import com.GIMP_plugin_repository.BackEnd.Category.Model.Category;
import com.GIMP_plugin_repository.BackEnd.Version.Dto.PluginVersionDto;

import java.util.List;

import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginDto {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
//    private Long authorId;
    private Long categoryId;
    private List<PluginVersionDto> pluginVersions;




    //=============== New added ================= //




}

 // Map the request body with PluginDto object and save it into the database and sending back into the
// response using the same PluginDto object
