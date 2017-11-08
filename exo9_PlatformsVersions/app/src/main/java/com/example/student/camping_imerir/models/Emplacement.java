package com.example.student.camping_imerir.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by student on 30/10/2017.
 */

public class Emplacement extends RealmObject {

    @PrimaryKey
    private int id_emplacement;
    private String name_emplacement;
    private String price_emplacement;
    private int surface_emplacement;
    private int nb_persons_emplacemenent;
    private int nb_rooms_emplacement;
    private String lat_emplacement;
    private String lng_emplacement;

    public Emplacement(){

    }

    public int getId_emplacement() {
        return id_emplacement;
    }

    public void setId_emplacement(int id_emplacement) {
        this.id_emplacement = id_emplacement;
    }

    public String getName_emplacement() {
        return name_emplacement;
    }

    public void setName_emplacement(String name_emplacement) {
        this.name_emplacement = name_emplacement;
    }

    public String getPrice_emplacement() {
        return price_emplacement;
    }

    public void setPrice_emplacement(String price_emplacement) {
        this.price_emplacement = price_emplacement;
    }

    public int getSurface_emplacement() {
        return surface_emplacement;
    }

    public void setSurface_emplacement(int surface_emplacement) {
        this.surface_emplacement = surface_emplacement;
    }

    public int getNb_persons_emplacemenent() {
        return nb_persons_emplacemenent;
    }

    public void setNb_persons_emplacemenent(int nb_persons_emplacemenent) {
        this.nb_persons_emplacemenent = nb_persons_emplacemenent;
    }

    public int getNb_rooms_emplacement() {
        return nb_rooms_emplacement;
    }

    public void setNb_rooms_emplacement(int nb_rooms_emplacement) {
        this.nb_rooms_emplacement = nb_rooms_emplacement;
    }

    public String getLat_emplacement() {
        return lat_emplacement;
    }

    public void setLat_emplacement(String lat_emplacement) {
        this.lat_emplacement = lat_emplacement;
    }

    public String getLng_emplacement() {
        return lng_emplacement;
    }

    public void setLng_emplacement(String lng_emplacement) {
        this.lng_emplacement = lng_emplacement;
    }
}
