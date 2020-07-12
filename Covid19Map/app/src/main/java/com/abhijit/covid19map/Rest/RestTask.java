package com.abhijit.covid19map.Rest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.abhijit.covid19map.BarChartActivity;
import com.abhijit.covid19map.DashBoard;
import com.abhijit.covid19map.GraphActivity;
import com.abhijit.covid19map.StatisticActivity;
import com.abhijit.covid19map.model.ArrayofCountry;
import com.abhijit.covid19map.model.Country;
import com.abhijit.covid19map.model.CountryWithGlobal;
import com.abhijit.covid19map.utils.AppSetiings;
import com.google.gson.Gson;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Android RestTask (REST) from the Android Recipes book.
 */
public class RestTask extends AsyncTask<HttpUriRequest, Void, String>
{
    private static final String TAG = "AsyncRestTask";
    public static final String HTTP_RESPONSE = "httpResponse";
    String error = ""; // string field

    private Context mContext;
    private HttpClient mClient;
    private String mAction;
    private String urls;
    private String chart_type;
    ArrayList <Country> country_list = new ArrayList();
    Country[] countryArray;
    CountryWithGlobal sumdata;

    public RestTask(Context context, String action) {
        mContext = context;
        mAction = action;
        mClient = new DefaultHttpClient();
    }

    public RestTask(Context context, String action, String url) {
        mContext = context;
        mAction = action;
        mClient = new DefaultHttpClient();
        urls=url;
    }

    public RestTask(Context context, String action, String url,String chart) {
        mContext = context;
        mAction = action;
        mClient = new DefaultHttpClient();
        urls=url;
        chart_type=chart;
    }

    public RestTask(Context context, String action, HttpClient client) {
        mContext = context;
        mAction = action;
        mClient = client;
    }

    @Override
    protected String doInBackground(HttpUriRequest... params) {
        String result = null;
        try {
           /* HttpUriRequest request = params[0];
            HttpResponse serverResponse = mClient.execute(request);
            BasicResponseHandler handler = new BasicResponseHandler();*/
            System.out.println("Data For Covid-19  urls------------ : " +urls);
           result=getDataFromUrl(urls);
            return  result;//handler.handleResponse(serverResponse);
        }
        catch (Exception e) {
            // TODO handle this properly
            e.printStackTrace();
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {
       Log.i(TAG, "Abhijit RESULT = " + chart_type+"  urls   "+ urls);

        Intent intent = new Intent(mAction);
        intent.putExtra(HTTP_RESPONSE, result);

        if(chart_type.contains("statistics")) {

            Gson gson = new Gson();
           // countryArray= gson.fromJson(result, Country[].class);
            sumdata= gson.fromJson(result, CountryWithGlobal.class);
          //  AppSetiings.setCountryArray(countryArray);
            AppSetiings.setSumdataarry(sumdata);

            System.out.println("Sum Data For Covid-19 :hi.............statistics................. ");
            //Intent y = new Intent(mContext, StatisticActivity.class);
            // intent.putExtra("graphtype", "piechart");
           // mContext.startActivity(y);

        }

        if(chart_type.contains("countrylist")) {

            Gson gson = new Gson();
            countryArray= gson.fromJson(result, Country[].class);
            AppSetiings.setCountryArray(countryArray);

            System.out.println("Sum Data For Covid-19 :hi.............countrylist................. ");
           // Intent y = new Intent(mContext, StatisticActivity.class);
            // intent.putExtra("graphtype", "piechart");
           // mContext.startActivity(y);
        }
        if(chart_type.contains("countrylist_status")) {

            Gson gson = new Gson();
            countryArray= gson.fromJson(result, Country[].class);
            AppSetiings.setCountryArray(countryArray);

            System.out.println("Sum Data For Covid-19 :hi.............countrylist_status................. ");
            //StatisticActivity stat=new StatisticActivity();
            //stat.Redraw_Chart();

           // Intent y = new Intent(mContext, StatisticActivity.class);
            // intent.putExtra("graphtype", "piechart");
           // mContext.startActivity(y);
        }

        if (chart_type.contains("barchart")){
            Gson gson = new Gson();
            // countryArray= gson.fromJson(result, Country[].class);
            sumdata= gson.fromJson(result, CountryWithGlobal.class);
            //  AppSetiings.setCountryArray(countryArray);
            AppSetiings.setSumdataarry(sumdata);
/*            Gson gson = new Gson();
            countryArray= gson.fromJson(result, Country[].class);
            AppSetiings.setCountryArray(countryArray);*/

            System.out.println("Sum Data For Covid-19 :hi.............others................. ");
            if (sumdata != null) {
                AppSetiings.setSumdataarry(sumdata);
                System.out.println("Sum Data For Covid-19 : Countery data  " + sumdata.getGlobal().getNewConfirmed() + "  length " + sumdata.getCountries().size());//+"  Length : "+sumdata.length +"  Date   "+sumdata[0].getCountries().get(0).getDate());
                if (chart_type.contains("barchart")) {
                    System.out.println("Sum Data For Covid-19 :hi.............others................. ");
                    Gson gsonl = new Gson();
                    sumdata= gsonl.fromJson(result, CountryWithGlobal.class);
                    AppSetiings.setSumdataarry(sumdata);
                    Intent I = new Intent(mContext, BarChartActivity.class);
                    mContext.startActivity(I);
                } else if (chart_type.contains("statistics")) {
                    System.out.println("Sum Data For Covid-19 :hi.............statistics................. ");
                    //Intent y = new Intent(mContext, StatisticActivity.class);
                    // intent.putExtra("graphtype", "piechart");
                    //mContext.startActivity(y);
                }
            }
        }
        // broadcast the completion
        mContext.sendBroadcast(intent);
    }

    private String getDataFromUrl(String demoIdUrl) {

        String result = null;
        int resCode;
        InputStream in;
        ArrayofCountry country=new ArrayofCountry();

        try {
            URL url = new URL(demoIdUrl);
            URLConnection urlConn = url.openConnection();

            HttpsURLConnection httpsConn = (HttpsURLConnection) urlConn;
            httpsConn.setAllowUserInteraction(false);
            httpsConn.setInstanceFollowRedirects(true);
            httpsConn.setRequestMethod("GET");
            httpsConn.connect();
            resCode = httpsConn.getResponseCode();


            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpsConn.getInputStream();

               /* BufferedReader reader = new BufferedReader(new InputStreamReader(
                        in, "iso-8859-1"), 8);*/
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                     //System.out.println("Data For Covid-19 : " +line+"   url"+urls);


                     //   Gson gson = new Gson();
                       //ArrayList <Country> country= gson.fromJson(line, ArrayList<Country>Country.class);
                  //  Gson gson = new Gson();
                   // countryArray= gson.fromJson(line, Country[].class);
                   // sumdata= gson.fromJson(line, CountryWithGlobal.class);

                }
                //AppSetiings.setCountryArray(countryArray);
               // AppSetiings.setSumdataarry(sumdata);

                //System.out.println("Data For Covid-19 : Countery data  " +countryArray[0].getCases()+"  Length : "+countryArray.length +"  Date   "+countryArray[0].getDate());
               //  System.out.println("Sum Data For Covid-19 : Countery data  " +sumdata.getGlobal().getNewConfirmed()+"  length "+sumdata.getCountries().size());//+"  Length : "+sumdata.length +"  Date   "+sumdata[0].getCountries().get(0).getDate());

               // String dates=countryArray[0].getDate();
                try {

                 /*   SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = inputFormat.parse(dates);//"2020-01-30T00:00:000Z");//"2018-04-10T04:00:00.000Z");
                    String formattedDate = outputFormat.format(date);
                    System.out.println(formattedDate);*/
                }
                catch(Exception f){f.getStackTrace();}

                in.close();
                result = sb.toString();
            } else {
                error += resCode;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}