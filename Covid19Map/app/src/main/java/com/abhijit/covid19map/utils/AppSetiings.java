package com.abhijit.covid19map.utils;

import com.abhijit.covid19map.model.Country;
import com.abhijit.covid19map.model.CountryWithGlobal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppSetiings {


    private static Country[] countryArray;


    private static CountryWithGlobal  sumdataarry;




    public AppSetiings(){}

    public static CountryWithGlobal getSumdataarry() {
        return sumdataarry;
    }

    public static void setSumdataarry(CountryWithGlobal sumdataarry) {
        AppSetiings.sumdataarry = sumdataarry;
    }


    public static Country[] getCountryArray() {
        return countryArray;
    }

    public static void setCountryArray(Country[] countryArray) {
        AppSetiings.countryArray = countryArray;
    }

    public String DateConvert(String dates)
    {
        String formattedDate="";
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = inputFormat.parse(dates);//"2020-01-30T00:00:000Z");//"2018-04-10T04:00:00.000Z");
            formattedDate = outputFormat.format(date);
            System.out.println(formattedDate);
        }
        catch(Exception f){f.getStackTrace();}

        return formattedDate;
    }



}
