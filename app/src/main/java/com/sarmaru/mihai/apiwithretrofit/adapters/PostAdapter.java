package com.sarmaru.mihai.apiwithretrofit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sarmaru.mihai.apiwithretrofit.R;
import com.sarmaru.mihai.apiwithretrofit.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private List<Post> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new PostHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Post currentPost = postsList.get(position);
        holder.textViewTitle.setText(currentPost.getPostTitle());
        holder.textViewContent.setText(currentPost.getPostContent());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setPostsList(List<Post> postsList) {
        this.postsList = postsList;
        notifyDataSetChanged();
    }

    class PostHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle;
        private TextView textViewContent;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textView_post_title);
            textViewContent = itemView.findViewById(R.id.text_view_content);
        }
    }

}
