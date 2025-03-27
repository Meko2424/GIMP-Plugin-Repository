package com.GIMP_plugin_repository.FrontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/loadAddPlugin")
    public String loadAddPlugin(){
        return "admin/addPlugin";
    }

    @GetMapping("/addCategory")
    public String addCategory(){
        return "admin/addCategory";
    }
}
