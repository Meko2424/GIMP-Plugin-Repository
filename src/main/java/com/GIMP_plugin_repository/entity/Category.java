package com.GIMP_plugin_repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "category_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Plugin> plugins;
}
