package com.example.demo.email;

import lombok.Data;


@Data
public class EmailObject {


    private String toEmail;
    private String subject;
    private String body;

    private String from = "writersworkspace403@gmail.com";


    public EmailObject(String toEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;

    }
}
