package com.example.student.realm.models;

import android.content.Context;

import io.realm.MutableRealmInteger;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by student on 24/10/2017.
 */

public class Matiere extends RealmObject {

    @PrimaryKey
    private long id_matiere;
    private String libelle;
    private RealmList<Note> notes;

    public Matiere(){
        this.id_matiere = System.currentTimeMillis();
        // Ouvrir une instance realm
       /* Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        id_matieres.getId_matiere().increment(1);
        this.id_matiere = Long.parseLong(id_matieres.getId_matiere().toString());*/
    }

    public Matiere(String libelle){
        this.id_matiere = System.currentTimeMillis();
        this.libelle = libelle;
    }

    public long getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(long id_matiere) {
        this.id_matiere = id_matiere;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public RealmList<Note> getNotes() {
        return notes;
    }

    public void setNotes(RealmList<Note> notes) {
        this.notes = notes;
    }
}
