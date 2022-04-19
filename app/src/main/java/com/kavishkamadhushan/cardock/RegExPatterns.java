package com.kavishkamadhushan.cardock;

// this enum is for create regular expressions

public enum RegExPatterns {

    START_WITH_ALPHABET("[a-zA-Z].*"), // this says start with [a-zA-Z]
    WORD_CHARACTERS("\\w*"), // this says this contains [a-zA-Z_0-9]
    CONTAIN_NUMBERS(".*\\d.*"), // this says this has at least one number[0-9]
    CONTAIN_SIMPLE(".*[a-z].*"), // this says this has at least one simple letter of alphabet
    CONTAIN_CAPITAL(".*[A-Z].*"), // this says this has at least one capital letter of alphabet
    SPECIAL_CHARACTERS(".*[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-].*"), // this says contains special characters
    WHITE_SPACES(".*\\s.*"), // this says this has white spaces
    PASSWORD_START("[?!].*"), // start with '?' or '!'
    PASSWORD_CONTAIN("[a-zA-Z0-9[~!@#$%^&*()+_{}\\\\[\\\\]:;,.<>/?-]].*"),
    // this says it don't have another invalid symbols other than this
    EMAIL_PATTERN("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); // check given email is valid

    private final String PATTERN;

    RegExPatterns(String pattern) {
        this.PATTERN = pattern;
    }

    // this return the pattern as String with given enum
    public String getPATTERN() {
        return this.PATTERN;
    }
}