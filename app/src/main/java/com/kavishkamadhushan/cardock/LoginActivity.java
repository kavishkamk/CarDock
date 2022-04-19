package com.kavishkamadhushan.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inputValidation = new InputValidation();
        setContentView(R.layout.activity_login);
        initiate();
    }

    // to initiate login interface
    private void initiate() {

        TextView signUpTxtView = findViewById(R.id.txtViewlogSignup); // sign up TextView
        EditText userNameEditText = findViewById(R.id.editTxtLoginUserName); // UserName TextEdit
        EditText userPassword = findViewById(R.id.editTextLoginUserPassword); // password TextEdit
        Button loginBtn = findViewById(R.id.btnLogin);

        // set registration UI link
        signUpTxtView.setOnClickListener(view ->
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class)));

        // set login button
        loginBtn.setOnClickListener(view -> login(userNameEditText, userPassword));

    }

    private void login(EditText userName, EditText pwd) {
        inputValidation.isValidUserName(userName);
        inputValidation.isValidPassword(pwd);
    }
}