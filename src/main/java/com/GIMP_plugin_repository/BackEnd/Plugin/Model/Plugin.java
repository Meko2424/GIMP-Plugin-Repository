package com.GIMP_plugin_repository.BackEnd.Plugin.Model;

import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "plugins")
public class Plugin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plugin_id")
    private Long id;
    private String title;
    private String description;
    private String authorName;
    private String imageUrl;
    private String fileUrl;

    @OneToMany(mappedBy = "plugin",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PluginVersion> pluginVersions;


}
