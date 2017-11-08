package com.example.student.exo6_volley;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String url = "https://perso.imerir.com/pgrabolosa/2016/ducks/";

        images = new ArrayList<String>();

        // GET
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {


                try{
                        //Log.i("IMERIR", "Response : "+ response);
                    JSONArray imagesJson = response.getJSONArray("images");

                    for(int i = 0; i < imagesJson.length(); i++){
                        JSONObject imageJson = (JSONObject) imagesJson.get(i);
                        String urlImage = imageJson.getString("url");
                        images.add(urlImage);
                    }

                    afficher();

                    Log.i("IMERIR", "Images : "+ images);
                }catch (Exception e){
                    Log.e("IMERIR", "Données = " + response + "\nErreur : " + e.getLocalizedMessage());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("IMERIR", error.getLocalizedMessage());
            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    public void afficher(){

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewAdapter adapter;
        adapter = new RecyclerViewAdapter(images, getLayoutInflater());


        recyclerView.setAdapter(adapter);

    }


}


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private List<String> images;
    private LayoutInflater inflate;

    public RecyclerViewAdapter(List<String> strings, LayoutInflater layoutInflater){
        super();
        images = strings;
        inflate = layoutInflater;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = inflate.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new RecyclerViewHolder (cellView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.setText(images.get(position));
    }

    @Override
    public int getItemCount() {

        return images.size();
    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public RecyclerViewHolder (View itemView) {

        super(itemView);
    }

    public void setText(String str){
        getTextView().setText(str);
    }

    TextView getTextView() {
        return itemView.findViewById(android.R.id.text1);
    }
}
