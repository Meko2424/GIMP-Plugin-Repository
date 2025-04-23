//package com.GIMP_plugin_repository.BackEnd.Category.Service;
//
//import com.GIMP_plugin_repository.BackEnd.Category.Dto.CategoryDto;
//import com.GIMP_plugin_repository.BackEnd.Category.Model.Category;
//import com.GIMP_plugin_repository.BackEnd.Category.Repository.CategoryRepository;
//import com.GIMP_plugin_repository.BackEnd.NotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CatServiceImpl implements CatService {
//
//    private final CategoryRepository categoryRepository;
//
//    private final ModelMapper modelMapper;
//
//
//
//    @Override
//    public void createCategory(CategoryDto categoryDto) {
//        Category category = new Category();
//        category.setName(categoryDto.getName());
//         categoryRepository.save(category);
//    }
//
//    @Override
//    public void updateCategory(Long categoryId, CategoryDto categoryDto) {
//      Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found"));
//      category.setName(categoryDto.getName());
//      categoryRepository.save(category);
//    }
//
//    @Override
//    public void getAllCategories() {
//
//    }
//
//    @Override
//    public void getCategoryById(Long categoryId) {
//
//    }
//
//    @Override
//    public void deleteCategory(Long categoryId) {
//
//    }
//}
