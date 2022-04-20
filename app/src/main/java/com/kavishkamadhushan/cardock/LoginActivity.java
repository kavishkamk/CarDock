package com.kavishkamadhushan.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        TextView forgotPwdTxtView = findViewById(R.id.forgotPwdTxtView); // forgot password TextView
        EditText userNameEditText = findViewById(R.id.editTxtLoginUserName); // UserName TextEdit
        EditText userPassword = findViewById(R.id.editTextLoginUserPassword); // password TextEdit
        Button loginBtn = findViewById(R.id.btnLogin);

        // set registration UI link
        signUpTxtView.setOnClickListener(view ->
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class)));

        // set login button
        loginBtn.setOnClickListener(view -> login(userNameEditText, userPassword));

        forgotPwdTxtView.setOnClickListener(v -> forgotPwd());

    }

    // this perform login action to user account
    private void login(EditText userName, EditText pwd) {
        if(inputValidation.isValidUserName(userName) && inputValidation.isValidPassword(pwd)) {
            PersonListHandler personListHandler = PersonListHandler.getPersonListHandler();
            isValidLogin(personListHandler, userName, pwd);
        }
    }

    private void forgotPwd() {
        // this implementation for forgotPwd
    }

    /*
     * check given username and passwords are correct
     * if username and password is correct return true
     * if username with password is wrong or if unavailable accounts return false
     */
    private boolean isValidLogin(PersonListHandler personListHandler, EditText userName, EditText pwd) {

        if(!personListHandler.isAvailableUserName(getString(userName))) {
            userName.setError("Didn't have this userName");
            return false;
        } else if(!personListHandler.isCorrectPassword(getString(userName), getString(pwd))) {
            userName.setError("Wrong username or password");
            pwd.setError("Wrong username or password");
            return false;
        }

        return true;
    }

    //this method use to extract string from given EditText
    private String getString(EditText editText) {
        return editText.getText().toString().trim();
    }
}