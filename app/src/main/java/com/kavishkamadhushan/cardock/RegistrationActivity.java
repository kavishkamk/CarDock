package com.kavishkamadhushan.cardock;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.inputValidation = new InputValidation();
        initiate();
    }

    private void initiate() {

        TextView signInTxtView = findViewById(R.id.txtViewRegNotification); // sign in TextView
        EditText userName = findViewById(R.id.editTxtUserName); // userName EditText
        EditText userEmail = findViewById(R.id.editTextTextEmailAddress); // userName email
        EditText password = findViewById(R.id.editTextUserPassword); // user password
        EditText cPassword = findViewById(R.id.editTextUserCoPassword); // confirm user password
        Button regBtn = findViewById(R.id.btnUserRegister); // registration button

        // set login interface link
        signInTxtView.setOnClickListener(view ->
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class)));

        // registration button action
        regBtn.setOnClickListener(v -> userRegistration(userName, userEmail, password, cPassword));
    }

    // user registration method
    private void userRegistration(EditText userName, EditText email, EditText pwd, EditText cPwd) {
        inputValidation.isValidUserName(userName);
        inputValidation.isValidFormatEmail(email);
        inputValidation.isValidPassword(pwd);
        inputValidation.isConfirmPassword(pwd, cPwd);
    }
}