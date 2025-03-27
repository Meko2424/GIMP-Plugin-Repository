package com.GIMP_plugin_repository.BackEnd.Review.Model;

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
@Table(name = "REVIEW")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")

    private Long id;
    private Long rating;
    private String comment;
    private LocalDate reviewDate;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_version_id", referencedColumnName = "version_id")
    private PluginVersion pluginVersion;

}
