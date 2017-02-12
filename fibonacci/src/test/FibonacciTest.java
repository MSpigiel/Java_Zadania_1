package test;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import com.capgemini.fibonacci.ArgumentOutOfBoundsException;
import com.capgemini.fibonacci.Fibonacci;

public class FibonacciTest {
	@Test
	public void shouldThrowIllegalArgumentException() throws Exception {
		try {
			Fibonacci.fib(-1);
		} catch (IllegalArgumentException e) {
			System.out.println("Program oblicza jedynie dodatnie elementy ciagu");
		}
	}
	@Test
	public void shouldThrowArgumentOutOfBoundsException() throws Exception {
		try {
			Fibonacci.fib(150);
		} catch (ArgumentOutOfBoundsException e) {
			System.out.println("Przekroczono maksymalny mozliwy do obliczenia element");
		}
	}

	@Test
	public void checkIfFirstValueEquals1() {
		Assert.assertEquals(1, Fibonacci.fib(1));
	}

	@Test
	public void checkIfSecondValueEquals2() {
		Assert.assertEquals(1, Fibonacci.fib(2));
	}

	@Test
	public void checkIfSixthValueEquals8() {
		Assert.assertEquals(8, Fibonacci.fib(6));
	}

}