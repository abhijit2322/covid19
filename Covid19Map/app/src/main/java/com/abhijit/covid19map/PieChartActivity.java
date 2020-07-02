package com.abhijit.covid19map;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.abhijit.covid19map.model.Country;
import com.abhijit.covid19map.model.CountryWithGlobal;
import com.abhijit.covid19map.utils.AppSetiings;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        PieChart pieChart = findViewById(R.id.piechart);
        Country[] country= AppSetiings.getCountryArray();
        CountryWithGlobal sumdata=AppSetiings.getSumdataarry();
        ArrayList NoOfEmp = new ArrayList();
 /*
// working for country
        for(int i=0;i<country.length;i++){
            NoOfEmp.add(new BarEntry(country[i].getCases(),i));
        }
*/
        // for global data
        for(int i=0;i<sumdata.getCountries().size();i++){
            System.out.println("Data For Covid-19 Total deaths"+sumdata.getCountries().get(i).getNewDeaths());
            NoOfEmp.add(new BarEntry(sumdata.getCountries().get(i).getTotalRecovered(),i));
        }
/*
        NoOfEmp.add(new Entry(945f, 0));
        NoOfEmp.add(new Entry(1040f, 1));
        NoOfEmp.add(new Entry(1133f, 2));
        NoOfEmp.add(new Entry(1240f, 3));
        NoOfEmp.add(new Entry(1369f, 4));
        NoOfEmp.add(new Entry(1487f, 5));
        NoOfEmp.add(new Entry(1501f, 6));
        NoOfEmp.add(new Entry(1645f, 7));
        NoOfEmp.add(new Entry(1578f, 8));
        NoOfEmp.add(new Entry(1695f, 9));

 */
        PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");

        ArrayList year = new ArrayList();
        /*
//for country working
        for(int i=0;i<country.length;i++){
            year.add(new AppSetiings().DateConvert(country[i].getDate()));
        }
  */
        // for global data working
        for(int i=0;i<sumdata.getCountries().size();i++){
            //year.add(new AppSetiings().DateConvert(sumdata.getCountries().get(i).getDate()));
            year.add(sumdata.getCountries().get(i).getCountry());
        }


        /*

        year.add("2008");
        year.add("2009");
        year.add("2010");
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");
             */
        PieData data = new PieData(year, dataSet);
        pieChart.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(5000, 5000);
    }
}