package com.sap.b1.consoletest.container;

import java.util.ArrayList;

public class ContainerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<Integer> al = new ArrayList<Integer>();
		 al.add(1);
		 al.add(2);
		 al.add(23); 
		 al.add(32); 
		 al.add(45); 
		 al.add(63); 
		 al.forEach((n) -> {
			 System.out.print(n);
			 System.out.print('\t');
		 });
		 System.out.println("finish");
	}

}
