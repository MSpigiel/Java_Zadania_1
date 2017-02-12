package com.capgemini.fibonacci;

public class Fibonacci {
	public static long fib(int n) throws ArgumentOutOfBoundsException {
		long F1 = 1;
		long F2 = 1;
		int maxElement = 93;
		int minElement = 1;
		long result = 1;

		if (n < minElement) {
			throw new IllegalArgumentException(
					"Metode mozna uzywac wylacznie do " + "wyznaczania wartosci wyrazow wiekszych lub rownych 1");
		}
		if (n > maxElement) {
			throw new ArgumentOutOfBoundsException("Metoda oblicza maksymalnie 93 wyrazy ciagu");
		}

		for (int i = 2; i < n; i++) {
			if (i % 2 == 0) {
				F2 += F1;
				result = F2;
			} else if (i % 2 != 0) {
				F1 += F2;
				result = F1;
			}
		}
		return result;
	}
}