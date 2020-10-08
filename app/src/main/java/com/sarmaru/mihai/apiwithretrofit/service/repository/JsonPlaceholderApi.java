package com.sarmaru.mihai.apiwithretrofit.service.repository;

import com.sarmaru.mihai.apiwithretrofit.service.model.Post;
import com.sarmaru.mihai.apiwithretrofit.service.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceholderApi {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> getAllPosts();

    @GET("users/{id}")
    Call<User> getUserByID(@Path("id") int id);
}
