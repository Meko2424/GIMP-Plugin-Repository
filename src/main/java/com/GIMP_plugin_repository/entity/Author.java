package com.GIMP_plugin_repository.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "author_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    private List<Plugin> plugins;
}
