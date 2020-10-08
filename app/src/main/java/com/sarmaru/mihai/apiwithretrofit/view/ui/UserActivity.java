package com.sarmaru.mihai.apiwithretrofit.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.sarmaru.mihai.apiwithretrofit.R;
import com.sarmaru.mihai.apiwithretrofit.service.model.User;
import com.sarmaru.mihai.apiwithretrofit.viewmodel.UserViewModel;

public class UserActivity extends AppCompatActivity {

    private TextView textViewUserName;
    private TextView textViewUserUsername;
    private TextView textViewUserEmail;
    private TextView textViewUserPhone;
    private TextView textViewUserWebsite;
    private TextView textViewUserCity;
    private TextView textViewUserStreet;
    private TextView textViewUserCompanyName;
    private TextView textViewUserCompanyCatchPhrase;
    private TextView textViewUserCompanyBS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initActivityViews();

        // TODO Get intent from clicked list item
        int ID = 1;

        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUserByID(ID).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                updateTextViews(user);
            }
        });
    }

    private void initActivityViews() {
        textViewUserName = findViewById(R.id.text_view_user_name);
        textViewUserUsername = findViewById(R.id.text_view_user_username);
        textViewUserEmail = findViewById(R.id.text_view_user_email);
        textViewUserPhone = findViewById(R.id.text_view_user_phone);
        textViewUserWebsite = findViewById(R.id.text_view_user_website);
        textViewUserCity = findViewById(R.id.text_view_user_city);
        textViewUserStreet = findViewById(R.id.text_view_user_street);
        textViewUserCompanyName = findViewById(R.id.text_view_user_company_name);
        textViewUserCompanyCatchPhrase = findViewById(R.id.text_view_user_company_catch_phrase);
        textViewUserCompanyBS = findViewById(R.id.text_view_user_company_bs);
    }

    private void updateTextViews(User user) {
        textViewUserName.setText(user.getUserName());
        textViewUserUsername.setText(user.getUserUsername());
        textViewUserEmail.setText(user.getUserEmail());
        textViewUserPhone.setText(user.getUserPhoneNumber());
        textViewUserWebsite.setText(user.getUserWebsite());
        textViewUserCity.setText(user.getUserAddress().getCityName());
        textViewUserStreet.setText(user.getUserAddress().getStreetName() + ", "
                + user.getUserAddress().getApartmentName() + ", "
                + user.getUserAddress().getZipCode());
        textViewUserCompanyName.setText(user.getUserCompany().getCompanyName());
        textViewUserCompanyCatchPhrase.setText(user.getUserCompany().getCompanyCatchPhrase());
        textViewUserCompanyBS.setText(user.getUserCompany().getCompanyBusiness());
    }
}