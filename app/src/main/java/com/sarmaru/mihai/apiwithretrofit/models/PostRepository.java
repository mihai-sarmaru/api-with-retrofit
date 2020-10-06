package com.sarmaru.mihai.apiwithretrofit.models;

import com.sarmaru.mihai.apiwithretrofit.apis.JsonPlaceholderApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRepository {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private JsonPlaceholderApi jsonPlaceholderApi;

    public PostRepository() {
        // Setup new retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
