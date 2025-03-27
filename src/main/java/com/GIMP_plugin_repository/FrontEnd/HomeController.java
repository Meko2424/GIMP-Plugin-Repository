package com.GIMP_plugin_repository.FrontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/plugins")
    public String plugins(){
        return "plugin";
    }

    @GetMapping("/plugin")
    public String plugin(){
        return "viewPlugin";
    }


}
