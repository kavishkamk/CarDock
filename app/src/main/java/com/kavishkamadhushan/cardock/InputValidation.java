package com.kavishkamadhushan.cardock;

// this class for validate user inputs

import android.widget.EditText;

public class InputValidation {
    /*
     * this method used to check if username is valid or not
     * if username is valid return 'true', else 'false'
     * this method accept 'EditText' as input
     * for valid username
     *   - it should not be empty
     *   - max length should be 15
     *   - start with a-z or A-Z
     *   - Can only contain a-z, A-Z, 0-9 or _
     *   -
     */
    public boolean isValidUserName(EditText editText) {
        String userName = editText.getText().toString().trim();

        if(userName.isEmpty()) {
            editText.setError("Field can't be Empty");
            return false;
        } else if(userName.length() > 15) {
            editText.setError("User Name too long.");
            return false;
        } else if(!isValidText(userName, RegExPatterns.START_WITH_ALPHABET)) {
            editText.setError("Must start with a-z or A-Z");
            return false;
        } else if(!isValidText(userName, RegExPatterns.WORD_CHARACTERS)) {
            editText.setError("Only contain a-z, A-Z, 0-9, _");
            return false;
        }

        return true;
    }

    /*
     * this method is used to check given password is valid or not
     * if valid it return true else false
     * this method use EditText as input
     * for valid password
     *   - password should not be empty
     *   - length should be grater than 8
     *   - must contain at least one simple character[a-z], capital character[A-Z], number[0-9]
     *   - must contain at least one special character[! # @ $ % ^ & * ( ) - _ = + [ ] ; : ' " , < . > / ?]
     *   - but must NOT contain spaces
     *   - must NOT start with '?' or '!'
     */
    public boolean isValidPassword(EditText editText) {
        String pwd = editText.getText().toString().trim();

        if(pwd.isEmpty()) {
            editText.setError("Field can't be Empty");
            return false;
        } else if (pwd.length() < 8) {
            editText.setError("Use at least 8 characters");
            return false;
        } else if(!isValidText(pwd, RegExPatterns.CONTAIN_SIMPLE)) {
            editText.setError("Don't have simple letters[a-z]");
            return false;
        } else if(!isValidText(pwd, RegExPatterns.CONTAIN_CAPITAL)) {
            editText.setError("Don't have Capital letters[A-Z]");
            return false;
        } else if(!isValidText(pwd, RegExPatterns.CONTAIN_NUMBERS)) {
            editText.setError("Don't have numbers[0-9]");
            return false;
        } else if(!isValidText(pwd, RegExPatterns.SPECIAL_CHARACTERS)) {
            editText.setError("Don't have special character");
            return false;
        } else if(isValidText(pwd, RegExPatterns.WHITE_SPACES)) {
            editText.setError("Don't use White Spaces");
            return false;
        } else if(isValidText(pwd, RegExPatterns.PASSWORD_START)) {
            editText.setError("Can't start with '?' or '!'");
            return false;
        } else if(!isValidText(pwd, RegExPatterns.PASSWORD_CONTAIN)) {
            editText.setError("Don't use invalid symbols");
            return false;
        }
        return true;
    }

    /*
     * this method used to check given email format is valid or not
     * if valid this return true and else return false
     * this accept EditText as input
     * for valid email
     *   - it should not be empty
     *   - it should have given structure
     */
    public boolean isValidFormatEmail(EditText editText) {
        String email = editText.getText().toString().trim();

        if(email.isEmpty()) {
            editText.setError("Field can't be empty");
            return false;
        } else if(!isValidText(email, RegExPatterns.EMAIL_PATTERN)) {
            editText.setError("Invalid Email");
            return false;
        }

        return true;
    }

    /*
     * This used to check given two passwords are equals or not
     * if equals return true else return false
     */
    public boolean isConfirmPassword(EditText pwd, EditText cPwd) {
        if(pwd.equals(cPwd)) {
            return true;
        } else {
            cPwd.setError("Didn't match password");
            return false;
        }
    }

    /*
     * this method checks given String is valid or not according to given regular expression
     * if valid return true, else return false
     * this method accept String 'text' for check and RegExPatterns as input
     */
    private boolean isValidText(String text, RegExPatterns regExPatterns) {
        return text.matches(regExPatterns.getPATTERN());
    }

}
