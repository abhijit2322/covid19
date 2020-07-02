package com.abhijit.covid19map;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.abhijit.covid19map.model.CountryWithGlobal;
import com.abhijit.covid19map.utils.AppSetiings;
import com.abhijit.covid19map.utils.IndexAxisValueFormatter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;

/*import lecho.lib.hellocharts.formatter.AxisValueFormatter;
import lecho.lib.hellocharts.model.AxisValue;*/
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarChartActivity extends AppCompatActivity {
    ArrayList year;
    ArrayList NoOfEmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        BarChart chart = findViewById(R.id.barchart);
        //Country[] country= AppSetiings.getCountryArray();
        CountryWithGlobal sumdata=AppSetiings.getSumdataarry();

       // System.out.println("Data For Covid-19 : Countery data  " +country[0].getCases()+"  Length : "+country.length +"  Date   "+country[0].getDate());
        System.out.println("Data For Covid-19 : Countery data  " +sumdata.getCountries().get(0).getCountry()+"  Length : "+sumdata.getCountries().size() +"  Date   "+sumdata.getCountries().get(0).getDate());
         NoOfEmp = new ArrayList();
        /*// for country data working
        for(int i=0;i<country.length;i++){
            NoOfEmp.add(new BarEntry(country[i].getCases(),i));
        }
        */
       // for global data
        for(int i=0;i<sumdata.getCountries().size();i++){
            System.out.println("Data For Covid-19 Total deaths"+sumdata.getCountries().get(i).getNewDeaths());
            NoOfEmp.add(new BarEntry(sumdata.getCountries().get(i).getTotalConfirmed(),i));

        }

/*
        NoOfEmp.add(new BarEntry(945f, 0));
        NoOfEmp.add(new BarEntry(1040f, 1));
        NoOfEmp.add(new BarEntry(1133f, 2));
        NoOfEmp.add(new BarEntry(1240f, 3));
        NoOfEmp.add(new BarEntry(1369f, 4));
        NoOfEmp.add(new BarEntry(1487f, 5));
        NoOfEmp.add(new BarEntry(1501f, 6));
        NoOfEmp.add(new BarEntry(1645f, 7));
        NoOfEmp.add(new BarEntry(1578f, 8));
        NoOfEmp.add(new BarEntry(1695f, 9));
*/
        year = new ArrayList();
/*// for country data working
        for(int i=0;i<country.length;i++){
            year.add(new AppSetiings().DateConvert(country[i].getDate()));
        }
*/
  // for global data working
        for(int i=0;i<sumdata.getCountries().size();i++){
            //year.add(new AppSetiings().DateConvert(sumdata.getCountries().get(i).getDate()));
            System.out.println("Data For Covid-19 Country Name:"+sumdata.getCountries().get(i).getCountry());
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
        BarDataSet bardataset = new BarDataSet(NoOfEmp, "Country Name");
        chart.animateY(5000);
        if ( sumdata.getCountries().size()>100){ // barEntries is my Entry Array
            int factor = 150; // increase this to decrease the bar width. Decrease to increase he bar width
            int percent = (factor - sumdata.getCountries().size())*10;
            bardataset.setBarSpacePercent(percent);
        }
        BarData data = new BarData(year, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        final ArrayList<String> xAxisLables = new ArrayList();
        for(int i=0;i<sumdata.getCountries().size();i++){
            //year.add(new AppSetiings().DateConvert(sumdata.getCountries().get(i).getDate()));
            System.out.println("Data For Covid-19 Country Name:"+sumdata.getCountries().get(i).getCountry());
            xAxisLables.add(sumdata.getCountries().get(i).getCountry());
        }

       /* OR

        String[] xAxisLables = new String[]{"1","2", "3", "4" ...};*/
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new XAxisValueFormatter() {
            @Override
            public String getXValue(String original, int index, ViewPortHandler viewPortHandler){

                return xAxisLables.get(index);
            }
        });
        chart.setData(data);
    }
}


