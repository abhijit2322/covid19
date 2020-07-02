package com.abhijit.covid19map.model;
//https://api.covid19api.com/countries
public class CountryList
{
    private String Country;

    private String Slug;

    private String ISO2;

    public void setCountry(String Country){
        this.Country = Country;
    }
    public String getCountry(){
        return this.Country;
    }
    public void setSlug(String Slug){
        this.Slug = Slug;
    }
    public String getSlug(){
        return this.Slug;
    }
    public void setISO2(String ISO2){
        this.ISO2 = ISO2;
    }
    public String getISO2(){
        return this.ISO2;
    }
}
