package com.GIMP_plugin_repository.BackEnd.Version.Dto;

import com.GIMP_plugin_repository.BackEnd.Review.Dto.ReviewDto;
import lombok.*;

import java.time.LocalDate;
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
