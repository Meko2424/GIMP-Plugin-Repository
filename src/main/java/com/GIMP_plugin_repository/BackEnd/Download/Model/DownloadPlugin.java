//package com.GIMP_plugin_repository.BackEnd.Download.Model;
//
//import com.GIMP_plugin_repository.BackEnd.User.Model.User;
//import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Table(name = "DOWNLOAD")
//public class DownloadPlugin {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "download_id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
//    private User user;
//
////    @OneToMany
////            (mappedBy = "DownloadPlugin",
////                    fetch = FetchType.LAZY,
////                    cascade = CascadeType.ALL, orphanRemoval = true)
////    private List<PluginVersion> pluginVersions;
//
//    private LocalDate downloadDate = LocalDate.now();
//}
