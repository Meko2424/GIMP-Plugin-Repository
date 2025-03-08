package com.GIMP_plugin_repository.Plugin.Model;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Category.Model.Category;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.Tag.Model.Tag;
import com.GIMP_plugin_repository.User.Model.User;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
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

    @ManyToOne
    @JoinColumn(name = "fk_category_id", referencedColumnName = "category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "fk_author_id", referencedColumnName = "author_id")
    private Author author;

//    @OneToMany
//    @JoinColumn(name = "tag_id")
//    private Tag tag;

    private Long versionNumber;

    @OneToMany(mappedBy = "plugin")
    private List<Review> reviews;

//    private User user;


}
