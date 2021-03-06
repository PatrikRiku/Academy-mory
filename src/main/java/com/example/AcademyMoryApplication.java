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

        List<Card> cardList1;
        List<Card> cardList2;
        cardList1 = dbconnectmem.getCard();
        cardList2 = dbconnectmem.getCard();
        //Card[] cardBoard = getRandomCard(cardList);
        List<Card> newcards = new ArrayList<>();
        List<Card> fullCards = new ArrayList<>();
        for(int i=0;i<cardList1.size();i++){
            fullCards.add(cardList1.get(i));
            fullCards.add(cardList2.get(i));
        }
        System.out.println("längd" + fullCards.size());

        Card[] randCardBoard = getRandomCard(fullCards);

        for(int i=0;i<fullCards.size();i++){
            fullCards.get(i).card_id = Integer.toString(i+10000);
            System.out.println("primkey " + fullCards.get(i).image_pk + " i-värde" + i + " namn " + fullCards.get(i).first_name + " memcard ID " + fullCards.get(i).card_id);
        }

        int boardSize = randCardBoard.length;



        return new ModelAndView("memoryGame").addObject("link1", randCardBoard).addObject("boardSize", boardSize);
    }

    public Card[] getRandomCard(List<Card> listlist) {


        Card[] memory = new Card[listlist.size()];

        Random rand = new Random();

        //for (int i = 0; i < 2; i++) {
            for (int j = 0; j < listlist.size(); j++) {
                int k = rand.nextInt(memory.length);
                while (memory[k] != null && j < listlist.size()) {
                    k = rand.nextInt(memory.length);
                }
                memory[k] = listlist.get(j);
            }
        //}

        return memory;


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

