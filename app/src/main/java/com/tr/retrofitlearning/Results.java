package com.tr.retrofitlearning;

import com.google.gson.annotations.SerializedName;

//this is a model class
public class Results {

    @SerializedName("name")
private String superName;

    public Results(String superName) {
        this.superName = superName;
    }

    public String getName() {
        return superName;
    }
}
