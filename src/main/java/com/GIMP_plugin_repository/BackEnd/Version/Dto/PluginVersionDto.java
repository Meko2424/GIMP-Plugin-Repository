package com.GIMP_plugin_repository.BackEnd.Version.Dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginVersionDto {
    private Long id;
    private String versionNumber;
    private LocalDate releaseDate = LocalDate.now();

}
