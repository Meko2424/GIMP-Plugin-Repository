package com.GIMP_plugin_repository.BackEnd.Category.Service;

import com.GIMP_plugin_repository.BackEnd.Category.Dto.CategoryDto;
import com.GIMP_plugin_repository.BackEnd.Category.Model.Category;
import com.GIMP_plugin_repository.BackEnd.Category.Repository.CategoryRepository;
import com.GIMP_plugin_repository.BackEnd.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

//@Service
//public class CategoryService {
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public CategoryDto createCategory(CategoryDto categoryDto){
//        Category category = modelMapper.map(categoryDto, Category.class);
//        //category.setName(categoryDto.getName());
//
//        // Save the Category to the database
//        Category savedCategory = categoryRepository.save(category);
//
//        //Return the saved Category as CategoryDTO
//        return modelMapper.map(savedCategory, CategoryDto.class);
//
//    }
//
//    public List<CategoryDto> getAllCategories(){
//        List<Category> categories = categoryRepository.findAll();
//        return categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).toList();
//    }
//
//    public Boolean getCategoryByName(String name){
//
//        return categoryRepository.existsByName(name);
//
//    }
//
//    public CategoryDto getCategoryById(Long id){
//        Category category = categoryRepository.findById(id).orElse(null);
//        return modelMapper.map(category, CategoryDto.class);
//    }
//
//    public Boolean deleteCategory(Long id){
//        Category category = categoryRepository.findById(id).orElse(null);
//        if(!ObjectUtils.isEmpty(category)){
//            categoryRepository.delete(category);
//            return true;
//        }
//        return false;
//    }
//
//
//}
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CategoryDto createCategory(CategoryDto categoryDto){
        Category category = new Category();
        category = modelMapper.map(categoryDto, Category.class);
        category.setName(categoryDto.getName());

        // Save the Category to the database
        Category savedCategory = categoryRepository.save(category);

        //Return the saved Category as CategoryDTO
        return modelMapper.map(savedCategory, CategoryDto.class);

    }

    public List<CategoryDto> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).toList();
    }

    public Boolean getCategoryByName(String name){

        return categoryRepository.existsByName(name);

    }

    public CategoryDto getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return modelMapper.map(category, CategoryDto.class);
    }

//    public CategoryDto deleteCategory(Long categoryId){
//        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found"));
//        categoryRepository.delete(category);
//        //return "Category deleted successfully";
//    }

    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found"));
        category.setName(categoryDto.getName());
        Category updatedCategory = categoryRepository.save(category);

        //Return the saved Category as CategoryDTO
        return modelMapper.map(updatedCategory, CategoryDto.class);
    }


}

