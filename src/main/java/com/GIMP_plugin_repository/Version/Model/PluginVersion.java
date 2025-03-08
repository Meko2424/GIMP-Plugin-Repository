package com.GIMP_plugin_repository.Version.Model;


import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.User.Model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "VERSION")
//@Entity
public class PluginVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pluginVersion_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_plugin_id", referencedColumnName = "plugin_id")
    private Plugin plugin;

    private String versionNumber;

    @JsonFormat(pattern = "mm/dd/yyyy")
    private Date uploadDate;

    @ManyToMany(mappedBy = "pluginVersions")
    private List<User> users;
//    @JoinTable(name = "UserDownload",
//            joinColumns = @JoinColumn(name = "version_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> users;
}
