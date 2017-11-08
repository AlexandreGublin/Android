package com.example.mylibrary;

/**
 * Created by student on 20/10/2017.
 */

public class CampingInfo {


    private String name = "campingImerir";
    private String telephoneNumber = "07 70 18 81 32";
    private String webSite = "http://www.imerir.com";
    private String adress = "1 rue de l'indépendance\nThaiti";

    private CampingInfo(){// rendre le constructeur privé pour que personne n'y est accès, car il n'y a qu'un camping info

    }

    //singleton -> qu'il n'existe que une et une seule instance de cette classe et comme il y a final, la variable ne peut être modifié, elle devient une constante
    public final static CampingInfo sharedInstance = new CampingInfo();


    public static CampingInfo getSharedInstance() {
        return sharedInstance;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
