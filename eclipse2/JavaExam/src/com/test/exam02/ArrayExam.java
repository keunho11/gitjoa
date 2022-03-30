package com.test.exam02;

import java.util.Arrays;

public class ArrayExam {
	
	public static void main(String[] argv) {
		
		int[] a = new int[] {1,2,3,4,5,6};
	
		for(int i =0; i< a.length; i++) {
			
			System.out.print(a[i] + " ");
		}
		
		System.out.println("\n");
		
		for(int i: a) System.out.print(i + " ");
		System.out.println("\n");
		System.out.println(Arrays.toString(a));
		
		
		
		int[][] b = {{1,2,3},{4,5,6},{7,8,9}};
		
		for(int i =0; i< 3; i++)
			for(int j=0; j<3; j++)
				System.out.println(b[i][j]);
		
		for(int i =0; i<b.length; i++)
			System.out.println(Arrays.toString(b[i]));
	 
		
		int c = 1;
		String str = "Hi";  
		
		switch(str) {
		
		case "Hi": 
			System.out.println("what??");
			break;
			
		case "Good Morning":
			System.out.println("what??");
			break;
			
		default:
			System.out.println("hello");
		}
	
		
		int k = 0;
		
		while(k<=100) {
			k++;
			if(k == 100)break;
		}
		
		System.out.println("k = " + k);
		
	}
	
}
