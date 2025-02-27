package com.GIMP_plugin_repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Plugin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plugin_id")
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_category_id")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_plugin_id", referencedColumnName = "plugin_id")
    private List<Version> versions;
}
