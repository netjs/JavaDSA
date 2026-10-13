package com.netjstech.sorting;

import java.util.Arrays;

/**
 * Bubble Sort Algorithm Java Implementation
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] numbers = {42, 76, 62, 34, 7, 10, 95, 106, 2, 58};
	    System.out.println("Original Array " +  Arrays.toString(numbers));
	    bubbleSort(numbers);
	    System.out.println("Sorted Array " + Arrays.toString(numbers));

	}
	
	public static void bubbleSort(int[] numbers) {
		int length = numbers.length;
		
		// outer loop
		for(int i = 0; i < length; i++) {
			// inner loop
			for(int j = 0; j < (length - i -1); j++) {
				if(numbers[j] > numbers[j+1]) {
					swap(j, numbers);
				}
			}
		}
	}
	
	// Swap the adjacent elements
	private static void swap(int index, int[] arr) {
		int temp = arr[index];
		arr[index] = arr[index+1];
		arr[index+1] = temp;
	}

}
