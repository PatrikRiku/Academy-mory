package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SpringBootApplication
public class AcademyMoryApplication {

    @Autowired
    private dbconnect dbconnectmem;

    public static void main(String[] args) {
        SpringApplication.run(AcademyMoryApplication.class, args);


    }

    @GetMapping("/")
    public ModelAndView memoryGame() {

        List<String> listan;
        listan = dbconnectmem.getImgUrl();
        System.out.println(listan.get(0).toString());
        //System.out.println(ny);
        String hej = "Hejsan";
        String link = listan.get(0);
        return new ModelAndView("memoryGame").addObject("link1", link).addObject("greeting", hej);
    }

}
