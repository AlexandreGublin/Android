package com.example.student.controle_2_maps;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by student on 03/11/2017.
 */

public class Restaurant extends RealmObject {

    public Restaurant(){

    }

    @PrimaryKey
    private long id;
    private String name;
    private String address;
    private String price;
    private String phone;
    private String city;
    private String postal_code;
    private String lat;
    private String lng;
    private String reserve_url;
    private String mobile_reserve_url;
    private String image_url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getReserve_url() {
        return reserve_url;
    }

    public void setReserve_url(String reserve_url) {
        this.reserve_url = reserve_url;
    }

    public String getMobile_reserve_url() {
        return mobile_reserve_url;
    }

    public void setMobile_reserve_url(String mobile_reserve_url) {
        this.mobile_reserve_url = mobile_reserve_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
}
