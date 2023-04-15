package com.example.demo.tests;

import static com.example.demo.tests.TipDobanda.*;

public class OperatiiDobanda {

    private DbOperation dbOperation;

    public OperatiiDobanda() {
    }

    public OperatiiDobanda(DbOperation dbOperation) {
        this.dbOperation = dbOperation;
    }


    public int calculDobanda(TipDobanda dobanda) {

        switch (dobanda) {
            case MICA: {
                return 0;
            }

            case MEDIE: {
                return 1;
            }

            case MARE: {
                return 2;
            }

            default:
                return -1;


        }
    }

    public int calculDobandaCuRisc() {



        switch (dbOperation.getUser().getRisc()) {
            case REDUS: {

                return calculDobanda(MARE);
            }

            case MEDIU: {
                return calculDobanda(MEDIE);
            }

            case RIDICAT: {
                return calculDobanda(MICA);
            }

            default:
                return -1;


        }
    }

    @Override
    public String toString() {
        return "OperatiiDobanda{" +
                "dbOperation=" + dbOperation +
                '}';
    }
}
