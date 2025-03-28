package com.GIMP_plugin_repository.BackEnd.Category.Controller;

import com.GIMP_plugin_repository.BackEnd.Category.Dto.CategoryDto;
import com.GIMP_plugin_repository.BackEnd.Category.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory = categoryService.createCategory(categoryDto);
        return ResponseEntity.ok(createdCategory);
    }
}
