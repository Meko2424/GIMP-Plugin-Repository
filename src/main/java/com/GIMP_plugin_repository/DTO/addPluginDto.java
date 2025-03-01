package com.GIMP_plugin_repository.DTO;

import lombok.Data;

public class addPluginDto {

    private Long id;
    private String title;
    private String description;
    private Long category_id;
    private Long author_id;
    private Data uploadDate;
    private Long rating_id;
    private Long tag_id;
}
