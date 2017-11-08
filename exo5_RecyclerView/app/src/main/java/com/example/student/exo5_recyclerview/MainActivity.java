package com.example.student.exo5_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeWord();

        afficher();

    }

   public void sendMessage(View view){
       EditText editText = (EditText) findViewById(R.id.editText);

       String message = editText.getText().toString();
       addWord(message);

       afficher();

   }

   public void afficher(){

       RecyclerViewAdapter adapter;
       adapter = new RecyclerViewAdapter(incrementData(words), getLayoutInflater());


       RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
       recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
           @Override
           public void onItemClick(View view, int position) {
               Toast.makeText(MainActivity.this, "Vous avez choisie d'afficher " +words.get(position).toString(), Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onItemLongClick(View view, int position) {
               Toast.makeText(MainActivity.this, "Vous avez choisie d'afficher " +words.get(position).toString(), Toast.LENGTH_SHORT).show();
           }
       }));

       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(adapter);
   }



   public void addWord(String word){
       this.words.add(word);
   }

    public void initializeWord(){
        words = new ArrayList<String>();
        words.add("Manon");
        words.add("Thomas");
        words.add("Isabelle");
        words.add("Gilles");
        words.add("Emmanuel");
        words.add("Bernard");
        words.add("Didier");
        words.add("René");
        words.add("Elodie");
        words.add("Hervé");
        words.add("Christine");
        words.add("Georges");
        words.add("Michel");
        words.add("Mira");
        words.add("Abeille");
    }

    public List<String> incrementData(List<String> words){
        List<String> result = new ArrayList<String>();

        Integer i = 0;
        /*for(String word : words){
            words.set(i, word += i++);
        }*/

        for(String word : words){
            result.add(word += i++);
        }

        return result;
    }
}








class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private List<String> words;
    private LayoutInflater inflate;

    public RecyclerViewAdapter(List<String> strings, LayoutInflater layoutInflater){
        super();
        words = strings;
        inflate = layoutInflater;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellView = inflate.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new RecyclerViewHolder (cellView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.setText(words.get(position));
    }

    @Override
    public int getItemCount() {

        return words.size();
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
