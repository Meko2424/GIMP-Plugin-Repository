package com.GIMP_plugin_repository.BackEnd.Category.Controller;

import com.GIMP_plugin_repository.BackEnd.Category.Dto.CategoryDto;
import com.GIMP_plugin_repository.BackEnd.Category.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")

public class CategoryController {

//    @Autowired
//    private CategoryService categoryService;
//
//    @PostMapping
//    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
//        CategoryDto createdCategory = categoryService.createCategory(categoryDto);
//        return ResponseEntity.ok(createdCategory);
//    }


    @Autowired
    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        try {
            CategoryDto savedCategory = categoryService.createCategory(categoryDto);
            return ResponseEntity.ok(savedCategory);
        } catch (Exception e) {
            throw new RuntimeException("Create category failed");
        }
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        try {
            List<CategoryDto> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            throw new RuntimeException("Categories not found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id){
        CategoryDto category  = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
}
