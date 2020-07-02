package com.abhijit.covid19map.model;

//https://api.covid19api.com/dayone/country/india/status/confirmed/live

public class Country
{
    private String Country;

    private String CountryCode;

    private String Province;

    private String City;

    private String CityCode;

    private String Lat;

    private String Lon;

    private int Cases;

    private String Status;

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
    public void setProvince(String Province){
        this.Province = Province;
    }
    public String getProvince(){
        return this.Province;
    }
    public void setCity(String City){
        this.City = City;
    }
    public String getCity(){
        return this.City;
    }
    public void setCityCode(String CityCode){
        this.CityCode = CityCode;
    }
    public String getCityCode(){
        return this.CityCode;
    }
    public void setLat(String Lat){
        this.Lat = Lat;
    }
    public String getLat(){
        return this.Lat;
    }
    public void setLon(String Lon){
        this.Lon = Lon;
    }
    public String getLon(){
        return this.Lon;
    }
    public void setCases(int Cases){
        this.Cases = Cases;
    }
    public int getCases(){
        return this.Cases;
    }
    public void setStatus(String Status){
        this.Status = Status;
    }
    public String getStatus(){
        return this.Status;
    }
    public void setDate(String Date){
        this.Date = Date;
    }
    public String getDate(){
        return this.Date;
    }
}
