package com.sarmaru.mihai.apiwithretrofit.service.repository;

import com.sarmaru.mihai.apiwithretrofit.service.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
