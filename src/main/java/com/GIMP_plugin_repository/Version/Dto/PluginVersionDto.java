package com.GIMP_plugin_repository.Version.Dto;

import com.GIMP_plugin_repository.Download.Dto.DownloadPluginDto;
import com.GIMP_plugin_repository.Download.Model.DownloadPlugin;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginVersionDto {
    private Long id;
    private String versionNumber;
//    private List<DownloadPluginDto> downloads;
//    private Plugin plugin;
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate uploadDate = LocalDate.now();
    private List<ReviewDto> reviews;
}
