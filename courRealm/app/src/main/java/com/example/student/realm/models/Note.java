package com.example.student.realm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by student on 24/10/2017.
 */

public class Note extends RealmObject {
    @PrimaryKey
    private long id_note;

    private Matiere matiere;
    private Eleve eleve;
    private float note;

    public Note(){
        this.id_note = System.currentTimeMillis();
    }

    public Note(Matiere matiere, Eleve eleve, int note){
        this.id_note = System.currentTimeMillis();
        this.eleve = eleve;
        this.matiere = matiere;
        this.note = note;
    }

    public long getId_note() {
        return id_note;
    }

    public void setId_note(long id_note) {
        this.id_note = id_note;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
