package com.sarmaru.mihai.apiwithretrofit.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sarmaru.mihai.apiwithretrofit.R;
import com.sarmaru.mihai.apiwithretrofit.service.model.User;
import com.sarmaru.mihai.apiwithretrofit.viewmodel.UserViewModel;

public class UserActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "com.sarmaru.mihai.apiwithretrofit.EXTRA_ID";
    public static final int INVALID_ID = -1;

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

    private RelativeLayout userLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initActivityViews();

        Intent receivedIntent = getIntent();
        int receivedUserID = receivedIntent.getIntExtra(EXTRA_ID, INVALID_ID);

        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUserByID(receivedUserID).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                updateTextViews(user);
                setLayoutVisibility(View.VISIBLE);
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
        userLayout = findViewById(R.id.user_layout);

        setLayoutVisibility(View.INVISIBLE);
    }

    private void setLayoutVisibility(int visibility) {
        userLayout.setVisibility(visibility);
    }

    private void updateTextViews(User user) {
        textViewUserName.setText(user.getUserName());
        textViewUserUsername.setText("(" + user.getUserUsername() + ")");
        textViewUserEmail.setText("Email: " + user.getUserEmail());
        textViewUserPhone.setText("Phone: " + user.getUserPhoneNumber());
        textViewUserWebsite.setText("Website: " + user.getUserWebsite());
        textViewUserCity.setText("City: " + user.getUserAddress().getCityName());
        textViewUserStreet.setText(user.getUserAddress().getStreetName() + ", "
                + user.getUserAddress().getApartmentName() + ", "
                + user.getUserAddress().getZipCode());
        textViewUserCompanyName.setText(user.getUserCompany().getCompanyName());
        textViewUserCompanyCatchPhrase.setText(user.getUserCompany().getCompanyCatchPhrase());
        textViewUserCompanyBS.setText(user.getUserCompany().getCompanyBusiness());
    }
}