package com.GIMP_plugin_repository.BackEnd.Plugin.Model;

import com.GIMP_plugin_repository.BackEnd.Author.Model.Author;
import com.GIMP_plugin_repository.BackEnd.Category.Model.Category;
import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
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

    @ManyToOne
    @JoinColumn(name = "fk_category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany(mappedBy = "plugin",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<PluginVersion> pluginVersions;

    //================== New added attributes ==================== //

//    @OneToMany(mappedBy = "plugin",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<DownloadPlugin> pluginDownloads;

//    @OneToMany(mappedBy = "plugin",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<Review> reviews;


}
