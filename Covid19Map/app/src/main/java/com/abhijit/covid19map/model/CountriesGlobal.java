package com.abhijit.covid19map.model;

public class CountriesGlobal
{
    private String Country;

    private String CountryCode;

    private String Slug;

    private int NewConfirmed;

    private int TotalConfirmed;

    private int NewDeaths;

    private int TotalDeaths;

    private int NewRecovered;

    private int TotalRecovered;

    private String Date;

    public void setCountry(String Country){
        this.Country = Country;
    }
    public String getCountry(){
        return this.Country;
    }
    public void setCountryCode(String CountryCode){
        this.CountryCode = CountryCode;
    }
    public String getCountryCode(){
        return this.CountryCode;
    }
    public void setSlug(String Slug){
        this.Slug = Slug;
    }
    public String getSlug(){
        return this.Slug;
    }
    public void setNewConfirmed(int NewConfirmed){
        this.NewConfirmed = NewConfirmed;
    }
    public int getNewConfirmed(){
        return this.NewConfirmed;
    }
    public void setTotalConfirmed(int TotalConfirmed){
        this.TotalConfirmed = TotalConfirmed;
    }
    public int getTotalConfirmed(){
        return this.TotalConfirmed;
    }
    public void setNewDeaths(int NewDeaths){
        this.NewDeaths = NewDeaths;
    }
    public int getNewDeaths(){
        return this.NewDeaths;
    }
    public void setTotalDeaths(int TotalDeaths){
        this.TotalDeaths = TotalDeaths;
    }
    public int getTotalDeaths(){
        return this.TotalDeaths;
    }
    public void setNewRecovered(int NewRecovered){
        this.NewRecovered = NewRecovered;
    }
    public int getNewRecovered(){
        return this.NewRecovered;
    }
    public void setTotalRecovered(int TotalRecovered){
        this.TotalRecovered = TotalRecovered;
    }
    public int getTotalRecovered(){
        return this.TotalRecovered;
    }
    public void setDate(String Date){
        this.Date = Date;
    }
    public String getDate(){
        return this.Date;
    }
}


