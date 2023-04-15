package com.example.demo;

import com.example.demo.tests.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoApplicationTests {



	@Mock
	private DbOperation dbOperation;


	@Test
	void testDobandaMica() {

		OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);
		int result = operatiiDobanda.calculDobanda(TipDobanda.MICA);
		int expectedResult = 0;

		assertTrue(result == expectedResult);


	}
	@Test
	void testDobandaCuRisc() {

		User user = new User("Ana", TipRisc.RIDICAT);
		when (dbOperation.getUser()).thenReturn(user);

		OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);

		int result = operatiiDobanda.calculDobandaCuRisc();
		int expectedResult = 0;

		assertTrue(result == expectedResult);

		verify(dbOperation).getUser();




	}

}
