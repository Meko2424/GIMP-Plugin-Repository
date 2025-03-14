package com.GIMP_plugin_repository.Version.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PluginVersionDto {
    private Long id;
    private String versionNumber;
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate uploadDate = LocalDate.now();

}
