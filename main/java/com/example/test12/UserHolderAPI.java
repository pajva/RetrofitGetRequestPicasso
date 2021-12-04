package com.example.test12;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserHolderAPI {

    @GET("v2/5d565297300000680030a986")
    Call<ArrayList<User>> getUserDetails();
}
