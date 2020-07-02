package com.abhijit.covid19map.model;
import java.util.List;
//https://api.covid19api.com/summary

public class CountryWithGlobal
{
    private Global Global;

    private List<CountriesGlobal> Countries;

    public void setGlobal(Global Global){
        this.Global = Global;
    }
    public Global getGlobal(){
        return this.Global;
    }
    public void setCountries(List<CountriesGlobal> Countries){
        this.Countries = Countries;
    }
    public List<CountriesGlobal> getCountries(){
        return this.Countries;
    }
}
