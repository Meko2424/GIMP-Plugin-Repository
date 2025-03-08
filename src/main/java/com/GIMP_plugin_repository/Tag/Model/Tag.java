package com.GIMP_plugin_repository.Tag.Model;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TAG")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;
    private String name;


//    @ManyToMany(mappedBy = "tags")
//    private Plugin plugins;
}
