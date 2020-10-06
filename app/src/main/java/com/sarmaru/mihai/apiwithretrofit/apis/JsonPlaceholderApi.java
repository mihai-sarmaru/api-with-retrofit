package com.sarmaru.mihai.apiwithretrofit.apis;

import com.sarmaru.mihai.apiwithretrofit.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
