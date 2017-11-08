package com.example.student.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String url = "http://perso.imerir.com/pgrabolosa/2016/ducks/";


        /* **********  GET ************/


        //Spécifique a Volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("IMERIR", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("IMERIR", error.getLocalizedMessage());
            }


        });

        requestQueue.add(jsonObjectRequest);






        /* **********  POST ************/


        // Create JsonObject
        final JSONObject data = new JSONObject();

        try{
            data.put("from", "Charles");
            data.put("to", "Marie");
            data.put("message", "bonjour");

        }catch(Exception e){

        }

        String url2 = "https://nameless-escarpment-47928.herokuapp.com/messages";
        JsonObjectRequest postDemo = new JsonObjectRequest(Request.Method.POST, url2, data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, null);

        requestQueue.add(postDemo);


    }
}
