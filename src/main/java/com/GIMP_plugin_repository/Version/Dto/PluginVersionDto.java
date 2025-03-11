package com.GIMP_plugin_repository.Version.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginVersionDto {
    private Long id;
    private String versionNumber;
    private String uploadDate;

}
