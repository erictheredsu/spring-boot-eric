package com.sap.b1.consoletest;

public class ItemGenerator<T> implements Generator<T> {

	private T key;
	
	public ItemGenerator(T key)
	{
		this.key = key;
	}
	
	public T doSthing() {
		// TODO Auto-generated method stub
		return  key;
	}
	public void setKey(T key) {
		this.key = key;
	}

}
