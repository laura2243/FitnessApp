package com.example.demo.tests;

public class User {

    private String nume;
    private TipRisc risc;

    public User(String nume, TipRisc risc) {
        this.nume = nume;
        this.risc = risc;
    }

    public String getNume() {
        return nume;
    }

    public TipRisc getRisc() {
        return risc;
    }
}
