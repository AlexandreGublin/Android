package com.example.student.recyclerviewlist;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerViewAdapter adapter;
        adapter = new RecyclerViewAdapter(
                Arrays.asList("Sarah", "Arman", "Stephan", "Sonia", "Elise", "Sarah", "Arman", "Stephan", "Sonia", "Elise", "Sarah", "Arman", "Stephan", "Sonia", "Elise", "Sarah", "Arman", "Stephan", "Sonia", "Elise"),
                getLayoutInflater()
        );

        //on récupère notre RecyclerView sur notre Vue
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private List<String> names;
    private LayoutInflater inflate;

    public RecyclerViewAdapter(List<String> strings, LayoutInflater layoutInflater){
        super();
        names = strings;
        inflate = layoutInflater;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = inflate.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new RecyclerViewHolder (cellView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.setText(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
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

