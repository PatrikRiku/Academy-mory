package com.example;

/**
 * Created by Administrator on 2017-03-09.
 */
public class Card {
    public final String image_pk;
    public final String url;
    public final String termin;
    public final String first_name;
    public final String last_name;
    public String card_id;

    public Card(String image_pk, String url, String termin, String first_name, String last_name, String card_id) {
        this.image_pk = image_pk;
        this.url = url;
        this.termin = termin;
        this.first_name = first_name;
        this.last_name = last_name;
        this.card_id = card_id;
    }
}