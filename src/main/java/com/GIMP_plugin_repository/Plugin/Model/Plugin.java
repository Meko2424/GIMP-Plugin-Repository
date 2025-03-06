package com.GIMP_plugin_repository.Plugin.Model;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Category.Model.Category;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.Tag.Model.Tag;
import com.GIMP_plugin_repository.User.Model.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String authorName;


    @ManyToMany(mappedBy = "plugins", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fk_category_id", referencedColumnName = "category_id")
    private Category category;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fk_author_id", referencedColumnName = "author_id")
    private Author author;

    @JsonManagedReference
    @OneToMany(mappedBy = "plugin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "PLUGIN_TAG",
            joinColumns = @JoinColumn(name = "plugin_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;


}
