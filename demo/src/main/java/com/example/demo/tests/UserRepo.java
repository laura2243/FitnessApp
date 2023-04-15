package com.example.demo.tests;

public class UserRepo  implements DbOperation {
    @Override
    public User getUser() {
        return new User("Laura",TipRisc.MEDIU);
    }
}
