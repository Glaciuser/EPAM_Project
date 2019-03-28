package com.epam.automation.GlaciuserTest.Elements;

public class Mail {

    private String to;
    private String subject;
    private String body;

    public Mail(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String to() {
        return this.to;
    }

    public String subject() {
        return this.subject;
    }

    public String body() {
        return this.body;
    }
}
