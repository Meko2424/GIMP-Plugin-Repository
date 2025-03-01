package com.GIMP_plugin_repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "version_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private Long id;
    private String versionNumber;
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "fk_plugin_id", referencedColumnName = "plugin_id")
    private Plugin plugin;

    @OneToMany(mappedBy = "versions" , cascade = CascadeType.ALL)
    private List<Download> downloads;
}
