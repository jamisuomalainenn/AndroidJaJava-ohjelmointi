package com.example.androidkehitys.companies;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidkehitys.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerAdapter adapter;
    private ArrayList<String> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        String TAG ="DataActivity";
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        ProgressBar progressBar=findViewById(R.id.progressBar);

        RequestQueue requestQueue= Volley.newRequestQueue(this); //luodaan requestQueue ja aloitetaan se

        //url osoite ytj rajapintaan, jonka perään laitetaan hakusana
        String URL = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=30&resultsFrom=0&name=";

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        // get data via the key
        String value1 = extras.getString("value1");
        if (value1 != null) {
            // do something with the data
            URL=URL+value1; //muokataan url käyttäjän hakusanan mukaan
            Log.i(TAG, URL);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray responseItems=(JSONArray) response.getJSONArray("results") ;

                                for (int i = 0; i < responseItems.length(); i++) {
                                    JSONObject x=responseItems.getJSONObject(i);
                                    Log.i(TAG, x.getString("name"));  //tulostaa hakuehdon täyttävien yritysten nimet consoliin

                                }

                                Log.e(TAG,String.valueOf(responseItems.length()));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }


                        }

                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error

                        }
                    });


            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(10 * 1000, 1, 1.0f));
            requestQueue.add(jsonObjectRequest);
        }
        //private void setupView() {
        //    progressBar.setVisibility(View.GONE);
//
  //          adapter = new RecyclerAdapter(itemList);
    //        adapter.notifyDataSetChanged();
      //      recyclerView.setAdapter(adapter);
       // }
    }
}