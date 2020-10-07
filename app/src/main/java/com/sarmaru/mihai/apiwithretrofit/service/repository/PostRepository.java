package com.sarmaru.mihai.apiwithretrofit.service.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sarmaru.mihai.apiwithretrofit.service.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRepository {

    private JsonPlaceholderApi jsonPlaceholderApi;

    public PostRepository() {
        // Setup new retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceholderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
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
