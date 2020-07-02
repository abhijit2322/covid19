package com.abhijit.covid19map;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.abhijit.covid19map.Retrofit.RetrofitClient;
import com.abhijit.covid19map.service.ApiServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.abhijit.covid19map.model.WorldLatLang;
import com.abhijit.covid19map.model.IndiaData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextToSpeech textToSpeech;
    List<IndiaData> indialist;
    List <WorldLatLang> countrylist;
    private static final LatLngBounds BOUNDS_INDIA = new LatLngBounds(new LatLng(23.63936, 68.14712), new LatLng(28.20453, 97.34466));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        indialist = new ArrayList<>();
        countrylist = new ArrayList<>();
        WorldLatLang objlatlang=new WorldLatLang();
        objlatlang.setIso2("IN");
        countrylist=GetCountryLangLat(objlatlang);


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "The Language is not supported!");
                    } else {
                        Log.i("TTS", "Language Supported.");
                    }
                    Log.i("TTS", "Initialization success.");
                } else {
                    Toast.makeText(getApplicationContext(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

    }
  public void displayUI()
  {
      SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
              .findFragmentById(R.id.map);
      mapFragment.getMapAsync(this);
  }
 public void updateIndiaList()
 {
     for(int i=0;i<countrylist.size();i++) {
         if (countrylist.get(i).getId()==4)
             countrylist.get(i).setCity("Maharashtra");
         if (countrylist.get(i).getId()==49)
             countrylist.get(i).setCity("Gujrat");
         if (countrylist.get(i).getId()==126)
             countrylist.get(i).setCity("Rajasthan");
         if (countrylist.get(i).getId()==249)
             countrylist.get(i).setCity("Madhya Pradesh");
         if (countrylist.get(i).getId()==143)
             countrylist.get(i).setCity("Uttar Pradesh");
         if (countrylist.get(i).getId()==42)
             countrylist.get(i).setCity("Telangana");
         if (countrylist.get(i).getId()==395)
             countrylist.get(i).setCity("Punjab");
         if (countrylist.get(i).getId()==814)
             countrylist.get(i).setCity("Andhra Pradesh");
         if (countrylist.get(i).getId()==8)
             countrylist.get(i).setCity("West Bengal");
         if (countrylist.get(i).getId()==767)
             countrylist.get(i).setCity("Jammu and Kashmir");
         if (countrylist.get(i).getId()==37)
             countrylist.get(i).setCity("Karnataka");
         if (countrylist.get(i).getId()==191)
             countrylist.get(i).setCity("Bihar");
         if (countrylist.get(i).getId()==642)
             countrylist.get(i).setCity("Kerala");
         if (countrylist.get(i).getId()==628)
             countrylist.get(i).setCity("Haryana");
         if (countrylist.get(i).getId()==944)
             countrylist.get(i).setCity("Odisha");
         if (countrylist.get(i).getId()==472)
             countrylist.get(i).setCity("Jharkhand");
         if (countrylist.get(i).getId()==628)
             countrylist.get(i).setCity("Chandigarh");
         if (countrylist.get(i).getId()==830)
             countrylist.get(i).setCity("Uttarakhand");
         if (countrylist.get(i).getId()==689)
             countrylist.get(i).setCity("Chhattisgarh");
            /*if (countrylist.get(i).getId()==689)
                countrylist.get(i).setCity("Ladakh");*/
         if (countrylist.get(i).getId()==624)
             countrylist.get(i).setCity("Assam");
         if (countrylist.get(i).getId()==2326)
             countrylist.get(i).setCity("Himachal Pradesh");
         if (countrylist.get(i).getId()==2841)
             countrylist.get(i).setCity("Andaman and Nicobar Islands");
         if (countrylist.get(i).getId()==2067)
             countrylist.get(i).setCity("Tripura");
         if (countrylist.get(i).getId()==1305)
             countrylist.get(i).setCity("Meghalaya");
         if (countrylist.get(i).getId()==1927)
             countrylist.get(i).setCity("Puducherry");
         if (countrylist.get(i).getId()==3652)
             countrylist.get(i).setCity("Goa");
         if (countrylist.get(i).getId()==1705)
             countrylist.get(i).setCity("Manipur");
         if (countrylist.get(i).getId()==4017)
             countrylist.get(i).setCity("Arunachal Pradesh");
         if (countrylist.get(i).getId()==4110)
             countrylist.get(i).setCity("Dadra and Nagar Haveli");
         if (countrylist.get(i).getId()==1636)
             countrylist.get(i).setCity("Mizoram");
         if (countrylist.get(i).getId()==3356)
             countrylist.get(i).setCity("Nagaland");
         if (countrylist.get(i).getId()==35)
             countrylist.get(i).setCity("Tamil Nadu");

     }
 }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        for(int i=0;i<indialist.size();i++) {

            for(int x=0;x<countrylist.size();x++) {
                System.out.println("Country City >>>>>" + countrylist.get(x).getCity()+"India City "+indialist.get(i).getType());

                if(countrylist.get(x).getCity().contains(indialist.get(i).getType())) {
                    System.out.println("Country List Data >>>>>" + countrylist.get(x).getCountry());
                    LatLng place = new LatLng(Double.parseDouble(countrylist.get(x).getLat()), Double.parseDouble(countrylist.get(x).getLng()));
                    mMap.addMarker(new MarkerOptions().position(place).title(countrylist.get(x).getCity()).snippet(makeReport(indialist.get(i))));//.getCity()));

                    mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                        @Override
                        public View getInfoWindow(Marker arg0) {
                            return null;
                        }

                        @Override
                        public View getInfoContents(Marker marker) {

                            LinearLayout info = new LinearLayout(getApplicationContext());
                            info.setOrientation(LinearLayout.VERTICAL);

                            TextView title = new TextView(getApplicationContext());
                            title.setTextColor(Color.BLACK);
                            title.setGravity(Gravity.CENTER);
                            title.setTypeface(null, Typeface.BOLD);
                            title.setText(marker.getTitle());

                            TextView snippet = new TextView(getApplicationContext());
                            snippet.setTextColor(Color.GRAY);
                            snippet.setText(marker.getSnippet());

                            info.addView(title);
                            info.addView(snippet);

                            return info;
                        }
                    });
                    int padding = 0; // offset from edges of the map in pixels
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(BOUNDS_INDIA, padding);
                    mMap.animateCamera(cameraUpdate);
                  //  mMap.moveCamera(CameraUpdateFactory.newLatLng(place));

                    mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {

                            String data = marker.getTitle() + " " + marker.getSnippet();
                            Log.i("TTS", "button clicked: " + data);
                            int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

                            if (speechStatus == TextToSpeech.ERROR) {
                                Log.e("TTS", "Error in converting Text to Speech!");
                            }

                            return false;
                        }
                    });
                }
            }
        }
        for(int i=0;i<indialist.size();i++) {
            System.out.println("India List Data >>>>>" + indialist.get(i).getTotalcase());
        }

        // Add a marker in Sydney and move the camera
       /* LatLng india = new LatLng(20, 78);
        LatLng agartala = new LatLng(23.9408, 91.9882);
        LatLng sydney = new LatLng(-33, 151);
        mMap.addMarker(new MarkerOptions().position(india).title("Marker in India"));
        mMap.addMarker(new MarkerOptions().position(agartala).title("Marker in Agartala"));
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }
    public String makeReport(IndiaData indiaData)
    {
        String Report="";
        Report="Total Case :"+indiaData.getTotalcase()+"\n"+"Active Cases "+indiaData.getActivecase()+"\n"+" Total Deaths: "+indiaData.getDeaths()+"\n"+"Total Cured: "+indiaData.getCured()+"\n";
      return Report;
    }

    public List<IndiaData> GetIndiaCases(/*IndiaData flatOwner*/){

        String url = "https://owndb.herokuapp.com/covid-19/";
        System.out.println("ASync API response >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Get India Data "+url);
        ApiServices apiService = RetrofitClient.getApiService();
        apiService.getIndiaData().enqueue(new Callback<List<IndiaData>>() {
            @Override
            public void onResponse(Call<List<IndiaData>> call, Response<List<IndiaData>> response) {
                if(response.isSuccessful()) {
                    System.out.println(">>>>>>>>>>>>>>>>>The Response  >>>>>. Get India Data" + response.body().toString());
                    // admin_s= response.body();
                    indialist=response.body();
                    //  response_status=true;
                }
                updateIndiaList();
                displayUI();
            }

            @Override
            public void onFailure(Call<List<IndiaData>> call, Throwable t) {
                System.out.println("This in  Failure >>>>>. Get India Data "+t.getMessage());
                // response_status=true;

            }
        });
        return indialist;
    }
    public List<WorldLatLang> GetCountryLangLat(WorldLatLang worldLatLang){

        String url = "https://owndb.herokuapp.com/covid-19/";
        System.out.println("ASync API response >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Get Country Lan lat Data "+url);
        ApiServices apiService = RetrofitClient.getApiService();
        apiService.getCountrylatlng(worldLatLang).enqueue(new Callback<List<WorldLatLang>>() {
            @Override
            public void onResponse(Call<List<WorldLatLang>> call, Response<List<WorldLatLang>> response) {
                if(response.isSuccessful()) {
                    System.out.println(">>>>>>>>>>>>>>>>>The Response  >>>>>. Get Country Lan lat Data" + response.body().toString());
                    // admin_s= response.body();
                    countrylist=response.body();
                    //  response_status=true;
                }
                indialist=GetIndiaCases();
            }

            @Override
            public void onFailure(Call<List<WorldLatLang>> call, Throwable t) {
                System.out.println("This in  Failure >>>>>. Get Country Lan lat Data "+t.getMessage());
                // response_status=true;

            }
        });
        return countrylist;
    }

}
