package com.GIMP_plugin_repository.BackEnd.Tag.Model;

import jakarta.persistence.*;

//
//@Entity
//@Table(name = "TAG")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;
    private String name;


//    @ManyToMany(mappedBy = "tags")
//    private Plugin plugins;
}
