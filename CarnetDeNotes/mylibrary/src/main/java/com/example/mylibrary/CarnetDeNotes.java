package com.example.mylibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 20/10/2017.
 */

public class CarnetDeNotes {

    private String name;
    private ArrayList<Float> notes;

    public CarnetDeNotes(String name){
        this.name = name;
        this.notes = new ArrayList<Float>();
    }

    public void ajouter(float note){
        this.notes.add(note);
    }


    public float moyenne(){
        Float sommeNotes = null;
        Float moyenneNotes = null;
        Integer nbNote = 0;

        for(Float note : this.notes){
            moyenneNotes+= note;
            nbNote++;
        }

        moyenneNotes = sommeNotes/nbNote;

        return moyenneNotes;

    }

    public Integer nombreNotes(){
        Integer nbNote = 0;

        for(Float note : this.notes){
            nbNote++;
        }

        return nbNote;
    }
}
