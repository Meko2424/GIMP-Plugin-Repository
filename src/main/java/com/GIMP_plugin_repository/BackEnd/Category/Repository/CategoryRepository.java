package com.GIMP_plugin_repository.BackEnd.Category.Repository;

import com.GIMP_plugin_repository.BackEnd.Category.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    public Boolean findByName(String categoryName);
    boolean existsByName(String name);

}
