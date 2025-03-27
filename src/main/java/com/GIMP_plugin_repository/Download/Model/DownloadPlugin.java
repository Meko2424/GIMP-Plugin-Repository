package com.GIMP_plugin_repository.Download.Model;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.User.Model.User;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "DOWNLOAD")
public class DownloadPlugin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "download_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;

//    @OneToMany
//            (mappedBy = "downloads",
//                    fetch = FetchType.LAZY,
//                    cascade = CascadeType.ALL)
//    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "fk_version_id", referencedColumnName = "version_id")
    private PluginVersion pluginVersion;

    private LocalDate downloadDate;
}
