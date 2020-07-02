package com.abhijit.covid19map;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.abhijit.covid19map.Rest.RestTask;

import org.apache.http.client.methods.HttpGet;

import java.net.URI;

public class DashBoard extends AppCompatActivity {
    TextView indiadata,worlddata,statistic,medicaltv,foodtv,settingtv;
    private static final String ACTION_FOR_INTENT_CALLBACK = "THIS_IS_A_UNIQUE_KEY_WE_USE_TO_COMMUNICATE";
    private static final String TAG = "Covid_19";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        indiadata = (TextView) findViewById(R.id.india_data);
        indiadata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at " +indiadata.getText().toString(), Toast.LENGTH_SHORT).show();
                //Intent ii = new Intent();
                // ii.setClass(RoomForSpecificUser.this, DeviceOperation.class);

                // startActivity(ii);

            }
        });
        findViewById(R.id.indiadatac).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at card " +indiadata.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashBoard.this,MapsActivity.class);
                startActivity(intent);

            }
        });

        worlddata = (TextView) findViewById(R.id.world_data);
        worlddata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at " +worlddata.getText().toString(), Toast.LENGTH_SHORT).show();
                //Intent ii = new Intent();
                // ii.setClass(RoomForSpecificUser.this, DeviceOperation.class);

                // startActivity(ii);


            }
        });
        findViewById(R.id.worlddatac).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at card " +worlddata.getText().toString(), Toast.LENGTH_SHORT).show();
              /*  Intent intent = new Intent(DashBoard.this,GraphActivity.class);
                intent.putExtra("graphtype", "barchart");
                startActivity(intent);*/
                String url="https://api.covid19api.com/summary";
                getContent(url,"barchart");

            }
        });

        statistic = (TextView) findViewById(R.id.statistic_data);
        statistic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at " +statistic.getText().toString(), Toast.LENGTH_SHORT).show();
                //Intent ii = new Intent();
                // ii.setClass(RoomForSpecificUser.this, DeviceOperation.class);

                // startActivity(ii);


            }
        });
        findViewById(R.id.statisticc).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at card " +statistic.getText().toString(), Toast.LENGTH_SHORT).show();


                String url = "https://api.covid19api.com/summary";
                getContent(url, "statistics");

            }
        });

        medicaltv = (TextView) findViewById(R.id.medical);
        medicaltv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at " +medicaltv.getText().toString(), Toast.LENGTH_SHORT).show();
                //Intent ii = new Intent();
                // ii.setClass(RoomForSpecificUser.this, DeviceOperation.class);

                // startActivity(ii);


            }
        });
        findViewById(R.id.medicalcard).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at card " +medicaltv.getText().toString(), Toast.LENGTH_SHORT).show();


            }
        });

        foodtv = (TextView) findViewById(R.id.food);
        foodtv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at " +foodtv.getText().toString(), Toast.LENGTH_SHORT).show();
                //Intent ii = new Intent();
                // ii.setClass(RoomForSpecificUser.this, DeviceOperation.class);

                // startActivity(ii);


            }
        });
        findViewById(R.id.foodcard).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at card " +foodtv.getText().toString(), Toast.LENGTH_SHORT).show();
                //Intent ii = new Intent();

                // startActivity(ii);

            }
        });


        settingtv = (TextView) findViewById(R.id.setting);
        settingtv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at " +settingtv.getText().toString(), Toast.LENGTH_SHORT).show();
                //Intent ii = new Intent();
                // ii.setClass(RoomForSpecificUser.this, DeviceOperation.class);

                // startActivity(ii);


            }
        });
        findViewById(R.id.settingcard).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(DashBoard.this, "You Clicked at card " +settingtv.getText().toString(), Toast.LENGTH_SHORT).show();
                //Intent ii = new Intent();
                // ii.setClass(RoomForSpecificUser.this, DeviceOperation.class);
                /*Intent intent = new Intent(DashBoard.this,MainActivity.class);
                intent.putExtra("content_type", "career");
                startActivity(intent);*/
                // startActivity(ii);

            }
        });



    }

    private void getContent(String url,String chart_type) {
        // the request
        try {
            HttpGet httpGet = new HttpGet(new URI(url));//TEST_URL));
            RestTask task = new RestTask(DashBoard.this, ACTION_FOR_INTENT_CALLBACK,url,chart_type);//TEST_URL);
            task.execute(httpGet);
            // progress = ProgressDialog.show(MainActivity.this, "Getting Data ...", "Waiting For Results...", true);
        }
        catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

    }
}
