package com.abhijit.covid19map;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.URI;

import android.app.ProgressDialog;
        import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.os.StrictMode;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import androidx.appcompat.app.AppCompatActivity;

        import com.abhijit.covid19map.Rest.RestTask;
        import com.github.mikephil.charting.charts.BarChart;
        import org.apache.http.client.methods.HttpGet;

        import java.net.URI;

public class GraphActivity extends AppCompatActivity {
    Button btnBarChart, btnPieChart,btnLineChart;

    private static final String TAG = "AsyncTestFragment";

    // get some fake data
    //private static final String TEST_URL                 = "http://jsonplaceholder.typicode.com/comments";
    private static final String TEST_URL                   = "https://api.covid19api.com/dayone/country/india/status/confirmed";//http://denverpost.com/sports";
    private static final String SUM_URL                    = "https://api.covid19api.com/summary";
    private static final String ACTION_FOR_INTENT_CALLBACK = "THIS_IS_A_UNIQUE_KEY_WE_USE_TO_COMMUNICATE";
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_graph);
        //BarChart barChart = (BarChart) findViewById(R.id.barchart);

        //btnBarChart = findViewById(R.id.btnBarChart);
        //btnPieChart = findViewById(R.id.btnPieChart);
       // btnLineChart=findViewById(R.id.btnLineChart);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Intent intent = getIntent();
        String graphtype = intent.getStringExtra("graphtype");
         if(graphtype.contains("barchart")) {
             String url="https://api.covid19api.com/summary";
             getContent(url,graphtype);

         }
/*
        btnBarChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent I = new Intent(GraphActivity.this, BarChartActivity.class);
                startActivity(I);
            }
        });
        btnPieChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(GraphActivity.this, PieChartActivity.class);
                startActivity(I);
            }
        });

        btnLineChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(GraphActivity.this, LineChartActivity.class);
                startActivity(I);
            }
        });

 */
    }

    private void getContent(String url,String chart_type) {
        // the request
        try {
            HttpGet httpGet = new HttpGet(new URI(url));//TEST_URL));
            RestTask task = new RestTask(GraphActivity.this, ACTION_FOR_INTENT_CALLBACK,url,chart_type);//TEST_URL);
            task.execute(httpGet);
            // progress = ProgressDialog.show(MainActivity.this, "Getting Data ...", "Waiting For Results...", true);
        }
        catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

    }

}
