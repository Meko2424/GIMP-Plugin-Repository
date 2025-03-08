package com.GIMP_plugin_repository.Plugin.Dto;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Category.Model.Category;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Tag.Model.Tag;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

//@Getter
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter
public class PluginDto {

//    private Long id;
//    private String title;
//    private String description;
//    private String categoryName;
//    private String authorName;
//    private List<Tag> tagNames;
//    private String versionNumber;
//    @JsonFormat(pattern = "mm/dd/yyyy")
//    private Date uploadDate;

    private Long id;
    private String title;
    private String description;
    private String categoryName;
    private String authorName;
//    private String tagName;
    private Long versionNumber;

    public PluginDto(Long id, String authorName, String categoryName, String description,  String title, Long versionNumber) {
        this.id = id;
        this.authorName = authorName;
        this.categoryName = categoryName;
        this.description = description;
//        this.tagName = tagName;
        this.title = title;
        this.versionNumber = versionNumber;
    }

    public PluginDto() {
    }

    public PluginDto(Plugin plugin) {
        this.title = plugin.getTitle();
        this.description = plugin.getDescription();
        this.categoryName = plugin.getCategory().getName();
        this.authorName = plugin.getAuthor().getName();
//        this.tagName = plugin.getTag().getName();
        this.versionNumber = plugin.getVersionNumber();

    }

    @Override
    public String toString() {
        return "PluginDto{" +
                "authorName='" + authorName + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", categoryName='" + categoryName + '\'' +
//                ", tagName='" + tagName + '\'' +
                ", versionNumber=" + versionNumber +
                '}';
    }
}

 // Map the request body with PluginDto object and save it into the database and sending back into the
// response using the same PluginDto object
