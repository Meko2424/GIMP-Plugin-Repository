package com.GIMP_plugin_repository.Review.Model;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.User.Model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "REVIEW")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")

    private Long id;
    private int rating;
    private String comment;
    private Date reviewDate;

    @JsonBackReference
    @ManyToMany(mappedBy = "reviews", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fk_plugin_id", referencedColumnName = "plugin_id")
    private Plugin plugin;

}
