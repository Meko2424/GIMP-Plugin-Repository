package com.GIMP_plugin_repository.Author.Repository;

import com.GIMP_plugin_repository.Author.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String authorName);
}
