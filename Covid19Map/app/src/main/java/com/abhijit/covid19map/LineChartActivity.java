
package com.abhijit.covid19map;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.abhijit.covid19map.model.CountryWithGlobal;
import com.abhijit.covid19map.utils.AppSetiings;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class LineChartActivity extends AppCompatActivity {

    LineChartView lineChartView;
    String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        lineChartView =(LineChartView) findViewById(R.id.chart);
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
       // Country[] country= AppSetiings.getCountryArray();
        CountryWithGlobal sumdata=AppSetiings.getSumdataarry();


        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
/*
        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }
        */
/*  //for country its working
        for(int i=0;i<country.length;i++){
            axisValues.add(i, new AxisValue(i).setLabel(new AppSetiings().DateConvert(country[i].getDate())));
        }

        for(int i=0;i<country.length;i++){
            yAxisValues.add(new PointValue(i,country[i].getCases()));//country[i].getStatus()));//);
        }
*/
        for(int i=0;i<sumdata.getCountries().size();i++){
            axisValues.add(i, new AxisValue(i).setLabel(new AppSetiings().DateConvert(sumdata.getCountries().get(i).getCountry())));
        }

        for(int i=0;i<sumdata.getCountries().size();i++){
            yAxisValues.add(new PointValue(i,sumdata.getCountries().get(i).getTotalRecovered()));//country[i].getStatus()));//);
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("Sales in millions");
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);
        if(lineChartView==null)
            System.out.println("This is Null---------------------------");
        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
    }

}