package com.stufacesigninsystem.demo.Controller;

import com.stufacesigninsystem.demo.Entity.Student;
import com.stufacesigninsystem.demo.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageContorller {
    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/")
    String defaultpage(){
        return "login";
    }
    @GetMapping("/student")
    String studentpage(HttpServletResponse res){
//        System.out.println(res.getHeader("stuid"));
        return "student";
    }
    @GetMapping("/login")
    String loginpage(HttpServletRequest req){
        return "/login";
    }
    @GetMapping("/course")
    String coursepage(HttpServletRequest req){
        return "/course";
    }
    @GetMapping("/signinfo")
    String signinfopage(HttpServletRequest req){
        return "/signinfo";
    }

}
