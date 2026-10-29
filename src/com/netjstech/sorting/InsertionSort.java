package com.netjstech.sorting;

import java.util.Arrays;

public class InsertionSort {
	
	private static void insertionSort(int[] numbers){
		for(int i = 1; i < numbers.length; i++) {
			int current = numbers[i];
			int j = i;
			while(j > 0 && numbers[j-1] > current) {
				// shifting elements to the right
				numbers[j] = numbers[j - 1];
				j--;
			}
			numbers[j] = current;
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = {47, 82, -65, 34, 10, 10, 97, 0, 2, -54};
	    System.out.println("Original Array: " +  Arrays.toString(numbers));
	    
	    insertionSort(numbers);
	    
	    System.out.println("Sorted array: " + Arrays.toString(numbers));
	}
}
