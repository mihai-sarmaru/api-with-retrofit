package com.sarmaru.mihai.apiwithretrofit.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sarmaru.mihai.apiwithretrofit.apis.JsonPlaceholderApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public LiveData<List<Post>> getAllPosts() {
        final MutableLiveData<List<Post>> postsList = new MutableLiveData<>();

        Call<List<Post>> allPostCall = jsonPlaceholderApi.getAllPosts();
        allPostCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    postsList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                // TODO Log failure error
            }
        });

        return postsList;
    }
}
