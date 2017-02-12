package com.capgemini.fibonacci;

public class Main {

	public static void main(String[] args) {
		try{
			System.out.println(Fibonacci.fib(2));
			System.out.println(Fibonacci.fib(3));
			System.out.println(Fibonacci.fib(4));
			System.out.println(Fibonacci.fib(5));
			System.out.println(Fibonacci.fib(96));
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
