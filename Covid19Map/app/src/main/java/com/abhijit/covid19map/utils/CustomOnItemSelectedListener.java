package com.abhijit.covid19map.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.abhijit.covid19map.Rest.RestTask;
import com.abhijit.covid19map.StatisticActivity;

import org.apache.http.client.methods.HttpGet;

import java.net.URI;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
    private static final String ACTION_FOR_INTENT_CALLBACK = "THIS_IS_A_UNIQUE_KEY_WE_USE_TO_COMMUNICATE";
    private static final String TAG = "Covid_19";
    private Context mContext;
    String url="";
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
        System.out.println("default selected Covid-19 -onItemSelected --------"+parent.getItemAtPosition(pos).toString());
          if(parent.getItemAtPosition(pos).toString()!=null) {
              mContext = parent.getContext();
              url = "https://api.covid19api.com/dayone/country/" + parent.getItemAtPosition(pos).toString() + "/status/confirmed";
             getContent(url, "countrylist_status");
          }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        url="https://api.covid19api.com/dayone/country/"+arg0.getItemAtPosition(0).toString()+"/status/confirmed";
        System.out.println("default selected Covid-19 -onNothingSelected --------");
      //  getContent(url, "statistics");
    }
    private void getContent(String url,String chart_type) {
        // the request
        try {
            HttpGet httpGet = new HttpGet(new URI(url));//TEST_URL));
            RestTask task = new RestTask(mContext, ACTION_FOR_INTENT_CALLBACK,url,chart_type);//TEST_URL);
            task.execute(httpGet);
            // progress = ProgressDialog.show(MainActivity.this, "Getting Data ...", "Waiting For Results...", true);
        }
        catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

    }

}