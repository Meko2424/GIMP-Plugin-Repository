package com.GIMP_plugin_repository.Review.Model;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.User.Model.User;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//@Entity
//@Data
//@Table(name = "REVIEW")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")

    private Long id;
    private int rating;
    private String comment;
    private Date reviewDate;


    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
//    @JoinColumn(name = "fk_plugin_id", referencedColumnName = "plugin_id")
    private PluginVersion pluginVersion;

}
