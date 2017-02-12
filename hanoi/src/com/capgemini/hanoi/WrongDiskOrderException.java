package com.capgemini.hanoi;

public class WrongDiskOrderException extends Exception {
	public  WrongDiskOrderException() {
		super();
	}
	public  WrongDiskOrderException(String message) {
		super(message);
	}
}
