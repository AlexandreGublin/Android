package com.example.student.realm.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by student on 24/10/2017.
 */

public class Eleve extends RealmObject {

    @PrimaryKey
    private long id_eleve;
    private String nom;
    private String prenom;
    private RealmList<Note> notes;

    public Eleve(){
        this.id_eleve = System.currentTimeMillis();
    }

    public Eleve(String nom, String prenom){
        this.id_eleve = System.currentTimeMillis();
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getId_eleve() {
        return id_eleve;
    }

    public void setId_eleve(long id_eleve) {
        this.id_eleve = id_eleve;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public RealmList<Note> getNotes() {
        return notes;
    }

    public void setNotes(RealmList<Note> notes) {
        this.notes = notes;
    }
}