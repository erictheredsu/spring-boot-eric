package com.sap.b1.consoletest.generics;

public class GenericData<T> {
	private T key;

	public GenericData(T key) {
		this.key = key;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}
}