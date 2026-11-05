package com.netjstech.array;

import java.util.Arrays;

public class FindMaxMin {
	// Byb Sorting the array
	public static void findMaxMinSorted(int [] arr) {
		Arrays.sort(arr);
		System.out.println("Largest Element " + arr[arr.length - 1]);
		System.out.println("Smallest Element " + arr[0]);
	}
	
	// Using Stream API
	public static void findMaxMinStream(int [] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		System.out.println("Largest Element " + max);
		System.out.println("Smallest Element " + min);
	}
	
	// Using Iterative Approach
	public static void findMaxMinIterative(int [] arr) {
		if(arr == null || arr.length == 0) {
			System.out.println("Array is empty");
			return;
		}
		// initialized with the first element
		int largest = arr[0];
		int smallest = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > largest) {
				largest = arr[i];
			}else if(arr[i] < smallest) {
				smallest = arr[i];
			}
		}
		System.out.println("Largest Element " + largest);
		System.out.println("Smallest Element " + smallest);
	}
	
	public static void main(String[] args) {
		int numbers[] = {56, 36, 48, 4, 29, 58, 56, 4, 7};
		findMaxMinIterative(numbers);

	}

}
