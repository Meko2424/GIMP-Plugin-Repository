package com.GIMP_plugin_repository.BackEnd.Version.Model;


//import com.GIMP_plugin_repository.BackEnd.Download.Model.DownloadPlugin;
import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
//import com.GIMP_plugin_repository.BackEnd.Review.Model.Review;
//import com.GIMP_plugin_repository.BackEnd.User.Model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "VERSION")
@Entity
public class PluginVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private Long id;
    private String versionNumber;
    @Column(name = "release date")
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "fk_plugin_id", referencedColumnName = "plugin_id")
    private Plugin plugin;



}
