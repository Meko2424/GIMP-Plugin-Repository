package com.GIMP_plugin_repository.BackEnd.Download.Model;

import com.GIMP_plugin_repository.BackEnd.User.Model.User;
import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
