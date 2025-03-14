package com.GIMP_plugin_repository.User.Dto;

import com.GIMP_plugin_repository.Download.Dto.DownloadPluginDto;
import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private List<DownloadPluginDto> pluginDownloads;
    private List<ReviewDto> reviews;
}
