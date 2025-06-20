package com.daniel.flyshort.application.validator;

public class LinkValidator {
    
    public static boolean validate(String url) {
        String regex = "^(https?|ftp)://[^\s/$.?#].[^\s]*$";
        return url.matches(regex);
    }

}
