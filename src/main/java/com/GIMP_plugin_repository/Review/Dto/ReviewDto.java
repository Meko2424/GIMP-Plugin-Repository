package com.GIMP_plugin_repository.Review.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Long id;
    private Long rating;
    private String comment;
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate reviewDate = LocalDate.now();
    private Long UserId;
    private Long PluginId;
}
