package com.example.student.gublin_controle_android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.gublin_controle_android.models.Article;

import java.util.List;

/**
 * Created by student on 27/10/2017.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private List<Article> articles;
    private LayoutInflater inflate;

    public RecyclerViewAdapter(List<Article> strings, LayoutInflater layoutInflater){
        super();
        articles = strings;
        inflate = layoutInflater;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = inflate.inflate(R.layout.list_articles, parent, false);
        return new RecyclerViewHolder (cellView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.setTextDateAndAuthor(articles.get(position).getAuthor(), articles.get(position).getAuthor());
        holder.setTextTitle(articles.get(position).getTitle());
        holder.setTextDescription(articles.get(position).getDescription());
        holder.setImageArticle(articles.get(position).getUrlImageArticle());
    }

    @Override
    public int getItemCount() {

        return articles.size();
    }
}
