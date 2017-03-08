package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        String[] memoryBoard = getRandomImg(listan);

        return new ModelAndView("memoryGame").addObject("link1", memoryBoard);
    }

    public String[] getRandomImg(List<String> listlist) {


        String[] memory = new String[listlist.size() * 2];

        Random rand = new Random();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < listlist.size(); j++) {
                int k = rand.nextInt(memory.length);
                while (memory[k] != null && j < listlist.size()) {
                    k = rand.nextInt(memory.length);
                }
                memory[k] = listlist.get(j);
            }
        }
        return memory;


    }}
