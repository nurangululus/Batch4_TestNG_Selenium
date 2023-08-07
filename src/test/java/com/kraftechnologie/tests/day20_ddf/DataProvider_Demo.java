package com.kraftechnologie.tests.day20_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Demo {

    @DataProvider
    public Object[][] tvAndRating(){
        String[][] data = {
                {"Chernoybl","10"},
                {"Breaking Bad","10"},
                {"Prison Break","9"},
                {"Fringe","9"},
                {"Person Of Interest","9"},
                {"La Casa Da Papel","8"},
        };
        return data;
    }
    @Test(dataProvider = "tvAndRating" )
    public void testTvShows(String tvShow,String rating){
        System.out.println("Tv show "+tvShow +"has rating "+rating);

    }
}
