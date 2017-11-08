package com.example.student.gublin_controle_android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.student.gublin_controle_android.models.Article;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private List<Article> articles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String urlArtciles = "https://newsapi.org/v1/articles?source=cnbc&apiKey=93b54d524f3f4d61ac933ff983911fe3";

        //Initialiser Realm
        Realm.init(this); //getBaseContext());

        // GET ARTICLES
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlArtciles, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {

                articles = new ArrayList<Article>();
                try {
                    Log.i("IMERIR", "Response : " + response);

                    final JSONArray articlesJson = response.getJSONArray("articles");


                    for (int i = 0; i < articlesJson.length(); i++) {



                        // Ouvrir une instance realm
                        Realm realm = Realm.getDefaultInstance();

                        // Récupérer 1 article en Json
                        final JSONObject articleJson = (JSONObject) articlesJson.get(i);

                        //realm.beginTransaction();

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                try {
                                    // Insérer les information de l'article dans une instance de notre class Article
                                    Article article = realm.createObject(Article.class);
                                    article.setAuthor(articleJson.getString("author"));
                                    article.setTitle(articleJson.getString("title"));
                                    article.setDescription(articleJson.getString("description"));
                                    article.setUrlArticle(articleJson.getString("url"));
                                    article.setUrlImageArticle(articleJson.getString("urlToImage"));
                                    article.setDatePublication(articleJson.getString("publishedAt"));
                                    realm.insertOrUpdate(article);

                                    // Ajouter l'article à notre liste
                                    articles.add(article);

                                }catch (Exception e){
                                    Log.e("IMERIR", "Impossible d insérer les données\nErreur : " + e.getLocalizedMessage());
                                }
                            }
                        });

                        //realm.commitTransaction();


                    }

                    afficher();

                    Log.i("IMERIR", "Articles : "+ articles);
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

        RecyclerViewAdapter adapter;
        adapter = new RecyclerViewAdapter(articles, getLayoutInflater());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                /*Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(articles.get(position).getUrlArticle()));
                startActivity(intent);*/

                Intent intent = new Intent(getApplicationContext(), ContentArticleActivity.class);
                intent.putExtra("url", articles.get(position).getUrlArticle());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

}
