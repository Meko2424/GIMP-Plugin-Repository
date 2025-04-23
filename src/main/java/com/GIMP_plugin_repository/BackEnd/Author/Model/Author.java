package com.GIMP_plugin_repository.BackEnd.Author.Model;

import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "AUTHOR")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Plugin> plugins;
}
