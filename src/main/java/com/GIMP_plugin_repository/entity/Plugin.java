package com.GIMP_plugin_repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "plugin_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

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
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany(mappedBy = "plugin" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Version> versions;

    @OneToMany(mappedBy = "plugin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "plugin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "plugin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tag> tags;
}
