package com.marksample.trustfulwebservice;

public class AuthenticationBean {
    private String message ;

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public AuthenticationBean(String message) {
        this.message = message;
    }
}
