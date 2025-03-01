package com.GIMP_plugin_repository.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comment_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    private String comment_text;

    @ManyToOne
    @JoinColumn(name = "fk_review_id", referencedColumnName = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "fk_plugin_id", referencedColumnName = "plugin_id")
    private Plugin plugin;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;








}
