package com.abhijit.covid19map;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.abhijit.covid19map.Rest.RestTask;
import com.abhijit.covid19map.model.Country;
import com.abhijit.covid19map.model.CountryWithGlobal;
import com.abhijit.covid19map.utils.AppSetiings;
import com.abhijit.covid19map.utils.CustomOnItemSelectedListener;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.apache.http.client.methods.HttpGet;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class StatisticActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button btnSubmit;
    private static final String ACTION_FOR_INTENT_CALLBACK = "THIS_IS_A_UNIQUE_KEY_WE_USE_TO_COMMUNICATE";
    private static final String TAG = "Covid_19";
    PieChart pieChart;
    Country[] country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        pieChart = findViewById(R.id.piechart);
        spinner = (Spinner) findViewById(R.id.spinner);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);


        CountryWithGlobal sumdata = AppSetiings.getSumdataarry();
        List<String> list = new ArrayList<String>();
        if (sumdata != null) {
            for (int i = 0; i < sumdata.getCountries().size(); i++) {
                //year.add(new AppSetiings().DateConvert(sumdata.getCountries().get(i).getDate()));
                System.out.println("Data For Covid-19 Country Name:" + sumdata.getCountries().get(i).getCountry());
                list.add(sumdata.getCountries().get(i).getCountry());
            }

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);
            spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());

             country= AppSetiings.getCountryArray();
            if (country == null) {
                System.out.println("Data For Covid-19 -Statistics --1------" + country);
                String url = "https://api.covid19api.com/dayone/country/" + sumdata.getCountries().get(0).getCountry() + "/status/confirmed";
                getContent(url, "countrylist");
                finish();
                return;
            }
            {
                System.out.println("Data For Covid-19 -Statistics ----2----" + country);
                ArrayList NoOfEmp = new ArrayList();
                ArrayList year = new ArrayList();
                for (int i = 0; i < country.length; i++) {
                    NoOfEmp.add(new BarEntry(country[i].getCases(), i));
                }
                PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");
                for (int i = 0; i < country.length; i++) {
                    year.add(new AppSetiings().DateConvert(country[i].getDate()));
                }

                PieData data = new PieData(year, dataSet);
                pieChart.setData(data);
                dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart.animateXY(5000, 5000);
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Data For Covid-19 -onStart --------");
    }
    public void Redraw_Chart()
    {
        country= AppSetiings.getCountryArray();
        System.out.println("Data For Covid-19 -Statistics ----Redraw_Chart----" + country);
        if(country!=null) {
            System.out.println("Data For Covid-19 -Statistics ----Redraw_Chart--9----" + country);
            ArrayList NoOfEmp = new ArrayList();
            ArrayList year = new ArrayList();
            for (int i = 0; i < country.length; i++) {
                NoOfEmp.add(new BarEntry(country[i].getCases(), i));
            }
            PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");
            for (int i = 0; i < country.length; i++) {
                year.add(new AppSetiings().DateConvert(country[i].getDate()));
            }

            PieData data = new PieData(year, dataSet);
            pieChart.setData(data);
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieChart.animateXY(5000, 5000);

            pieChart.updateViewLayout(findViewById(R.id.piechart),pieChart.getLayoutParams());
        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent inti) {
        super.onActivityResult(requestCode, resultCode, inti);
     /*   if (resultCode == Activity.RESULT_OK) {
            System.out.println("Data For Covid-19 -onActivityResult --RESULT_OK");
            Country[] country= AppSetiings.getCountryArray();
            ArrayList NoOfEmp = new ArrayList();
            ArrayList year = new ArrayList();
            for(int i=0;i<country.length;i++){
                NoOfEmp.add(new BarEntry(country[i].getCases(),i));
            }
            PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");
            for(int i=0;i<country.length;i++){
                year.add(new AppSetiings().DateConvert(country[i].getDate()));
            }

            PieData data = new PieData(year, dataSet);
            pieChart.setData(data);
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieChart.animateXY(5000, 5000);
            pieChart.invalidate();
          //  pieChart.updateViewLayout();

        }*/
    }

    private void getContent(String url,String chart_type) {
        // the request
        try {
            HttpGet httpGet = new HttpGet(new URI(url));//TEST_URL));
            RestTask task = new RestTask(StatisticActivity.this, ACTION_FOR_INTENT_CALLBACK,url,chart_type);//TEST_URL);
            task.execute(httpGet);
            // progress = ProgressDialog.show(MainActivity.this, "Getting Data ...", "Waiting For Results...", true);
        }
        catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

    }
}
