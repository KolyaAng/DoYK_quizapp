package com.example.pro.doyk.Adapter;

public class CategoryList {
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
            case "catAll":
                catName = "Все разом";
                break;
        }
        return  catName;
    }
}
