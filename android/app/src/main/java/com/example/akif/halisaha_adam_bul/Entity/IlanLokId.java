package com.example.akif.halisaha_adam_bul.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akif on 22.2.2017.
 */

public class IlanLokId {


    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("il")
    @Expose
    private String il;
    @SerializedName("ilce")
    @Expose
    private String ilce;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public IlanLokId(String a){
        this.id=a;

    }

}
