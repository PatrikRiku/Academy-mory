package com.example;

import java.util.List;

/**
 * Created by Administrator on 2017-03-08.
 */
public interface dbconnectrep {
    List<String> getImgUrl();
    void addHighscore(int highScore, String name) throws Exception;
}
