package com.netjstech.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Elements in array with target sum using 
 * 3 Approaches (Nested Loops, Two-Pointer, HashSet)
 */
public class TwoSumElements {
	
	// Using Nested Loops
	public static String findPairsNested(int arr[], int target){
		String result = "";
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] + arr[j] == target) {
					result = result + "(" + arr[i] + ", " + arr[j] + ")";
					break;
				}
			}
		}
		return result;
	}
	
	// Using HashSet
	public static String findPairsSet(int arr[], int target){
		String result = "";
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			int difference = target - arr[i];
			if(set.contains(difference)) {
				result = result + "(" +  difference + "," + arr[i] + ")";
			}
			set.add(arr[i]);
		}
		return result;
	}
	
	// Using two pointer
	public static String findPairsTwoPointer(int arr[], int target){
		String result = "";
		int left = 0;
		int right = arr.length - 1;
		
		// Sort the array
		Arrays.sort(arr);
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(sum == target) {
				result = result + "(" + arr[left] + ", " + arr[right] + ")";
				left++;
				right--;
			}else if(sum < target) {
				left++;
			}else {
				right--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] numArr = new int[] {4, 6, 5, -10, 8, 5, 5, 20};
	    int target = 10;
	    String result =  findPairsTwoPointer(numArr, target);
	    System.out.println(result);

	}

}
