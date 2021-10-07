package com.tr.retrofitlearning;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// ias main do constructor hain aik private dusra public
public class RetrofitClient {


//    we created an object of class here and filled it with null value and did not initialize it
    private static RetrofitClient instance= null;

    private Api myApi;


    private RetrofitClient() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

// Api.class        abstract methods weghira ko refrence dena k lia aistmal hua ha
        myApi=retrofit.create(Api.class);
    }


    public static synchronized RetrofitClient getInstance(){


        if (instance==null)
        {
            instance = new RetrofitClient();
        }
        return instance;


    }


    public Api getMyApi(){
        return myApi;
    }

}

