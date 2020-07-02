package com.abhijit.covid19map.model;

public class Global
{
    private int NewConfirmed;

    private int TotalConfirmed;

    private int NewDeaths;

    private int TotalDeaths;

    private int NewRecovered;

    private int TotalRecovered;

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
}
