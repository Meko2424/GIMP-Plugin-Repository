package com.GIMP_plugin_repository.FrontEnd;

import com.GIMP_plugin_repository.BackEnd.Category.Dto.CategoryDto;
import com.GIMP_plugin_repository.BackEnd.Category.Service.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/loadAddPlugin")
    public String loadAddPlugin(){
        return "admin/addPlugin";
    }

    @GetMapping("/category")
    public String category(Model m){
        m.addAttribute("categories", categoryService.getAllCategories());
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute CategoryDto categoryDto, HttpSession session){
        Boolean existingCategory = categoryService.getCategoryByName(categoryDto.getName());
        if(existingCategory){
            session.setAttribute("errMsg", "Category name already exist");
        }else{
            CategoryDto saveCategory = categoryService.createCategory(categoryDto);
            if(ObjectUtils.isEmpty(saveCategory)){
                session.setAttribute("errMsg", "Category not saved!");
            }else {
                session.setAttribute("successMsg", "Category saved!");
            }
            //modelMapper.map(saveCategory, CategoryDto.class);
        }

       // categoryService.createCategory(categoryDto);
        return "redirect:/admin/category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id, HttpSession session){
        Boolean deleteCategory = categoryService.deleteCategory(id);
        if(deleteCategory){
            session.setAttribute("successMsg", "Category deleted successfully");
        }else {
            session.setAttribute("errMsg", "Unable to delete");
        }
       return "redirect:/admin/addCategory";
    }
}
