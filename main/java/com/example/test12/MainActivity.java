package com.example.test12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lview1 = findViewById(R.id.lview1);
    }

    public void getUsers(View view) {

        final ProgressDialog ringProgressDialog = ProgressDialog.show(MainActivity.this, "Please Wait", "Loading", true);
        ringProgressDialog.setCancelable(true);
        Retrofit r = new Retrofit.Builder().
                baseUrl("https://www.mocky.io/").
                addConverterFactory(GsonConverterFactory.create()).build();
        UserHolderAPI users = r.create(UserHolderAPI.class);
        Call<ArrayList<User>> call = users.getUserDetails();
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                Toast.makeText(MainActivity.this, "Response Successfull", Toast.LENGTH_LONG).show();
                ringProgressDialog.dismiss();
                ArrayList<User> users = response.body();
                System.out.println(users);
                lview1.setAdapter(new MyAdapter(MainActivity.this, users));
                lview1.setClickable(true);
                lview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle(""+users.get(position).getName());
                        builder.setMessage("Mail ID : "+users.get(position).getEmail()+"\n"+"Phone : "+users.get(position).getPhone());
                        ImageView img = new ImageView(MainActivity.this);
                        Picasso.with(MainActivity.this).load(users.get(position).getImage()).into(img);
                        builder.setView(img);
                        builder.setIcon(R.drawable.ist);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                });
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No Response"+t.getMessage(), Toast.LENGTH_LONG).show();
                ringProgressDialog.dismiss();
            }
        });
    }
}