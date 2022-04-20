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

    // initiate the functionality of this class
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
        // check inputs validity
        if(inputValidation.isValidUserName(userName) && inputValidation.isValidFormatEmail(email) &&
                inputValidation.isValidPassword(pwd) && inputValidation.isConfirmPassword(pwd, cPwd)) {

            PersonListHandler personListHandler = PersonListHandler.getPersonListHandler();

            // check with already available account details
            if(isPossibleToCreateAccount(personListHandler, userName, email)) {
                // register user
                personListHandler.addPerson(new Person(getString(userName), getString(email), getString(pwd)));
                startLoginActivity(); //
            }
        }

    }

    /*
     * this method is used to check given details can used to register new user
     * for register user account
     *   - email and username should not be already available
     * if the details can register return true, else return false
     */
    private boolean isPossibleToCreateAccount(PersonListHandler personListHandler,
                                              EditText userName, EditText email) {

        if(personListHandler.isAvailableUserName(getString(userName))) {
            userName.setError("Already available");
            return false;
        } else if (personListHandler.isAvailableEmail(getString(email))) {
            email.setError("Already available");
            return false;
        }

        return true;
    }

    //this method use to extract string from given EditText
    private String getString(EditText editText) {
        return editText.getText().toString().trim();
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}