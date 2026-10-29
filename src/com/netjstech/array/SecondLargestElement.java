package com.netjstech.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SecondLargestElement {
	
	// By Sorting
	public static void getSecondLargestSorting(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		int max = arr[n - 1];
		int secondLargest = 0;
		boolean found = false;
		for(int i = n-2; i >=0; i--) {
			if(arr[i] != max) {
				secondLargest = arr[i];
				found = true;
				break;
			}
		}
		if(found) {
			System.out.println("Second Largest Element: " + secondLargest);
		}else {
			System.out.println("No distinct second largest element found");
		}
		
	}
	
	// By Stream API
	public static void getSecondLargestStream(int[] arr) {
		Optional<Integer> secondLargest = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		secondLargest.ifPresentOrElse(v -> System.out.println("Second Largest Element: " + v), 
		()-> System.out.println("No distinct second largest element found"));
		
	}
	
	// By Single pass
	public static void getSecondLargestIterative(int[] arr) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			}else if(arr[i] > secondLargest && arr[i] < largest) {
				secondLargest = arr[i];
			}
		}
		
		if(secondLargest != Integer.MIN_VALUE) {
			System.out.println("Second Largest Element: " + secondLargest);
		}else {
			System.out.println("No distinct second largest element found");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 4, 1, 6, 9, 9};
		
		// For no distinct second largest scenario
		//int[] arr = {7, 7, 7, 7};
		
		//int[] arr = {Integer.MIN_VALUE, Integer.MAX_VALUE};
		getSecondLargestIterative(arr);
		
		

	}
}
