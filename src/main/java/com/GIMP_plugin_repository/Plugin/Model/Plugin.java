package com.GIMP_plugin_repository.Plugin.Model;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Download.Model.DownloadPlugin;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "PLUGIN")
public class Plugin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plugin_id")
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_author_id", referencedColumnName = "author_id")
    private Author author;


    @OneToMany(mappedBy = "plugin",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<PluginVersion> pluginVersions;

    //================== New added attributes ==================== //

    @OneToMany(mappedBy = "plugin",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DownloadPlugin> pluginDownloads;

    @OneToMany(mappedBy = "plugin",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Review> reviews;


}
