package com.sarmaru.mihai.apiwithretrofit.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sarmaru.mihai.apiwithretrofit.models.Post;
import com.sarmaru.mihai.apiwithretrofit.models.PostRepository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {

    PostRepository postRepository;
    private LiveData<List<Post>> allPosts;

    public PostViewModel(@NonNull Application application) {
        super(application);
        this.postRepository = new PostRepository();
        this.allPosts = postRepository.getAllPosts();
    }

    public LiveData<List<Post>> getAllPosts() {
        return allPosts;
    }
}
