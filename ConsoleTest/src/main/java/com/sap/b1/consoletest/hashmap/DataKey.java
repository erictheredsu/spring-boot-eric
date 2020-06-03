package com.sap.b1.consoletest.hashmap;

public class DataKey {
	private String name;
	private int id;

        // getter and setter methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DataKey [name=" + name + ", id=" + id + "]";
	}


}
