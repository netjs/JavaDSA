package com.netjstech.array;

import java.util.Arrays;

public class LargestElement {

	public static void main(String[] args) {
		int[] arr = {10, 2, 8, 2, 4, 14, 5, 7};
		
		int max = getLargestBySorting(arr);
		
		System.out.println("Largest element is: " + max);
		
		max = getLargestByIteration(arr);
		
		System.out.println("Largest element is: " + max);
		
		max = getLargestByStream(arr);
		
		System.out.println("Largest element is: " + max);
	}
	
	// BY sorting
	public static int getLargestBySorting(int[] arr) {
		Arrays.sort(arr);
		
		return arr[arr.length - 1];
	}
	
	// by iterative approach
	public static int getLargestByIteration(int[] arr){
		int max = arr[0];
		for(int i = 1; i < arr.length; i++ ) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	// By Using Stream API
	public static int getLargestByStream(int[] arr){
		return Arrays.stream(arr).max().getAsInt();
	}
	
	

}
