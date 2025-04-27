//package com.GIMP_plugin_repository.BackEnd.Category.Service;
//
//import com.GIMP_plugin_repository.BackEnd.Category.Dto.CategoryDto;
//import com.GIMP_plugin_repository.BackEnd.Category.Model.Category;
//import com.GIMP_plugin_repository.BackEnd.Category.Repository.CategoryRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Service
//public class CategoryService {
////    @Autowired
////    private CategoryRepository categoryRepository;
////    @Autowired
////    private ModelMapper modelMapper;
////
////    public CategoryDto createCategory(CategoryDto categoryDto){
////
////        Category category = modelMapper.map(categoryDto, Category.class);
////
////        // Save the Category to the database
////        Category savedCategory = categoryRepository.save(category);
////
////        //Return the saved Category as CategoryDTO
////        return modelMapper.map(savedCategory, CategoryDto.class);
////
////    }
////
////    public List<CategoryDto> getAllCategories(){
////        List<Category> categories = categoryRepository.findAll();
////        return categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).toList();
////    }
////
////    public Boolean getCategoryByName(String name){
////
////        return categoryRepository.existsByName(name);
////
////    }
////
////    public CategoryDto getCategoryById(Long id){
////        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
////        return modelMapper.map(category, CategoryDto.class);
////    }
////
//////    public CategoryDto deleteCategory(Long categoryId){
//////        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found"));
//////        categoryRepository.delete(category);
//////        //return "Category deleted successfully";
//////    }
////
////    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto){
////        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found"));
////
////        Category updatedCategory = categoryRepository.save(category);
////
////        //Return the saved Category as CategoryDTO
////        return modelMapper.map(updatedCategory, CategoryDto.class);
////    }
//@Autowired
//private final CategoryRepository categoryRepository;
//    @Autowired
//    private final ModelMapper modelMapper;
//
//
//
//    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
//        this.categoryRepository = categoryRepository;
//        this.modelMapper = modelMapper;
//    }
//
//
//    public CategoryDto createCategory(CategoryDto categoryDto) {
//        Category category = modelMapper.map(categoryDto, Category.class);
////        List<Extension> extensions = categoryDto.getExtensions().stream()
////                .map(extension -> modelMapper.map(extension, Extension.class))
////                .collect(Collectors.toList());
////        category.setExtensions(extensions);
////
////        extensions.forEach(extension -> extension.setCategory(category));
//        Category savedCategory = categoryRepository.save(category);
//        return modelMapper.map(savedCategory, CategoryDto.class);
//    }
//
//
//    public CategoryDto getCategoryById(Long id) {
//        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
//        return modelMapper.map(category, CategoryDto.class);
//    }
//
//
//    public List<CategoryDto> getAllCategories() {
//        List<Category> categories = categoryRepository.findAll();
//        return categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
//    }
//
//
//    public CategoryDto updateCategory(Long id, CategoryDto updatedCategoryDto) {
//        return null;
//    }
//
//
//    public void deleteCategory(Long id) {
//
//    }
//
//}
//
