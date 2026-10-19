package com.netjstech.sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void selectionSort(int[] numbers) {
		int arrayLen = numbers.length;
		int lowest;
		for(int i = 0; i < arrayLen - 1; i++) {
			lowest = i;
			for(int j = i + 1; j < arrayLen; j++) {
				if(numbers[j] < numbers[lowest]) {
					lowest = j;
				}
			}
			swap(i, lowest, numbers);
		}
	}
	
	private static void swap(int i, int lowest, int[] numbers) {
		int temp = numbers[i];
		numbers[i] = numbers[lowest];
		numbers[lowest] = temp;
	}
	
	public static void main(String[] args) {
		int[] numbers = {47, 85, 620, 3456, 7, -10, 0, 106, 345, 1000};
		System.out.println("Original Array " +  Arrays.toString(numbers));
    		selectionSort(numbers);
	    System.out.println("Sorted array is- ");
	    for(int num : numbers){
	      System.out.print(num + " ");
	    }
	}
}
