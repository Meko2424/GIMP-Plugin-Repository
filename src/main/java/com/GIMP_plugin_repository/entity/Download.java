package com.GIMP_plugin_repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "download_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Download {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "download_id")
    private Long id;
    private Date downloadDate;

    @ManyToOne
    @JoinColumn(name = "fk_version_id", referencedColumnName = "version_id")
    private Version versions;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;
}
