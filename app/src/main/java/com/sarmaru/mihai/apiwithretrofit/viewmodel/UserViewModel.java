package com.sarmaru.mihai.apiwithretrofit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sarmaru.mihai.apiwithretrofit.service.model.User;
import com.sarmaru.mihai.apiwithretrofit.service.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository();
    }

    public LiveData<User> getUserByID(int id) {
        return userRepository.getUserByID(id);
    }
}
