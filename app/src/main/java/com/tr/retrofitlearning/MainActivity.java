package com.tr.retrofitlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ListView superListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        superListView = findViewById(R.id.superListView);

        getSuperHeroes();
    }


    private void getSuperHeroes(){




        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();

        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {

//               response ke body ko initialize kr waya
                List<Results> myheroList= response.body();

                String[] oneHeros = new String[myheroList.size()];

                for(int i =0 ; i < myheroList.size() ; i++){

                    oneHeros[i] = myheroList.get(i).getName();
                }

                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeros));


            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "An error has occoured", Toast.LENGTH_SHORT).show();
            }
        });
    }





}