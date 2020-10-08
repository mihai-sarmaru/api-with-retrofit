package com.sarmaru.mihai.apiwithretrofit.service.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sarmaru.mihai.apiwithretrofit.service.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {

    private JsonPlaceholderApi jsonPlaceholderApi;

    public UserRepository() {
        // Setup new retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceholderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
    }

    public LiveData<User> getUserByID(int id) {
        MutableLiveData<User> user = new MutableLiveData<>();

        Call<User> userCall = jsonPlaceholderApi.getUserByID(id);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // TODO Log failure error
            }
        });

        return user;
    }
}
