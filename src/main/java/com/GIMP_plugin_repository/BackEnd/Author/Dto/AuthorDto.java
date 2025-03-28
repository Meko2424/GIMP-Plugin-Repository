package com.GIMP_plugin_repository.BackEnd.Author.Dto;

import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorDto {

    private Long id;
    private String name;
    //private List<Plugin> plugins;
}
