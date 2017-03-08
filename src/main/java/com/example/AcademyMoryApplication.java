package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class AcademyMoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademyMoryApplication.class, args);


    }

    @GetMapping("/")
    public ModelAndView memoryGame() {
        String ny = "";
        System.out.println(ny);
        String hej = "Hejsan";
        String link = "https://daks2k3a4ib2z.cloudfront.net/58452de5f28ead16137e2298/5899b10e4da66841215f9db3_Academic_Work_2017-01-24_022%20kopiera.png";
        return new ModelAndView("memoryGame").addObject("link1", link).addObject("greeting", hej);
    }

}
