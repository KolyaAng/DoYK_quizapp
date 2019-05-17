package com.example.pro.doyk.Adapter;

public class Category {
    public static String getCategoryTitle(String key){
        String catName = "А ти знаєш?";
        switch (key){
            case "catPhysic":
                catName = "Фізика";
                break;
            case "catGeography":
                catName = "Географія";
                break;
            case "catReligion":
                catName = "Релігія";
                break;
            case "catHistory":
                catName = "Історія";
                break;
            case "catBiology":
                catName = "Біологія";
                break;
            case "catCinema":
                catName = "Кіно";
                break;
            case "catArt":
                catName = "Мистецтво";
                break;
            case "catLing":
                catName = "Мовознавство";
                break;
            case "catSport":
                catName = "Спорт";
                break;
            case "catTechnology":
                catName = "Технології";
                break;
            case "catLiterature":
                catName = "Література";
                break;
            case "catAll":
                catName = "Все разом";
                break;
        }
        return  catName;
    }
//
//    public int getTotScore(){
//        return;
//    }


}
