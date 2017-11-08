package com.example.student.gublin_controle_android.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by student on 27/10/2017.
 */

public class Article extends RealmObject {

    private String author;
    private String title;
    private String description;
    private String urlArticle;
    private String urlImageArticle;
    private String datePublication;

    public Article(){

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlArticle() {
        return urlArticle;
    }

    public void setUrlArticle(String urlArticle) {
        this.urlArticle = urlArticle;
    }

    public String getUrlImageArticle() {
        return urlImageArticle;
    }

    public void setUrlImageArticle(String urlImageArticle) {
        this.urlImageArticle = urlImageArticle;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }
}
