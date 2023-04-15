package com.example.demo;


import com.example.demo.tests.DbOperation;
import com.example.demo.tests.OperatiiDobanda;
import com.example.demo.tests.TipDobanda;
import com.example.demo.tests.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


		//OperatiiDobanda operatiiDobanda = new OperatiiDobanda();
		//System.out.println(operatiiDobanda.calculDobanda(TipDobanda.MARE));

//		DbOperation dbOperation = new UserRepo();
//		OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);
//		System.out.println(operatiiDobanda);
		//DbOperation dbOperation = new UserRepo();
		//System.out.println(operatiiDobanda.calculDobandaCuRisc(dbOperation.getUser()));


	}
}