package com.GIMP_plugin_repository.Download.Dto;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.User.Model.User;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DownloadPluginDto {
    private Long id;
    private LocalDate downloadDate  = LocalDate.now();
    private User user;
    private PluginVersion pluginVersion;
//    private List<ReviewDto> reviews;
}
