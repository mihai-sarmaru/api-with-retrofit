package com.sarmaru.mihai.apiwithretrofit.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sarmaru.mihai.apiwithretrofit.R;
import com.sarmaru.mihai.apiwithretrofit.view.adapter.PostAdapter;
import com.sarmaru.mihai.apiwithretrofit.service.model.Post;
import com.sarmaru.mihai.apiwithretrofit.viewmodel.PostViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set RecyclerView and PostAdapter
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final PostAdapter postAdapter = new PostAdapter();
        recyclerView.setAdapter(postAdapter);

        // Connect ViewModel to Activity
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getAllPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                postAdapter.setPostsList(posts);
            }
        });
    }
}