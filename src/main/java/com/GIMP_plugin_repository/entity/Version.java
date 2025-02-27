package com.GIMP_plugin_repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private Long id;
    private String versionNumber;

//    @ManyToOne
//    @JoinColumn(name = "fk_plugin_id")
//    private Plugin plugin;
}
