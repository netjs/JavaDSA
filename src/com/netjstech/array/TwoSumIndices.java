package com.netjstech.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Find pair of indices in array with target sum 
 * using 3 Approaches (Nested Loops, Two-Pointer, HashMap)
 */
public class TwoSumIndices {
	// Using nested loops (Brute-force)
	public static int[] findPairsNestedLoops(int[] arr, int target) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] + arr[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		return new int[] {};
	}
	
	// Using HashMap
	public static int[] findPairsUsingMap(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			int otherKey = target - arr[i];
			if(map.containsKey(otherKey)) {
				return new int[] {map.get(otherKey), i};
			}
			map.put(arr[i], i);
		}
		return new int[] {};
	}
	
	//  Using two pointers when input is a sorted array
	public static int[] findPairsUsingTwoPointersSorted(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			if(arr[left] + arr[right] == target) {
				return new int[] {left, right};
			}else if(arr[left] + arr[right] < target) {
				left++; // move left pointer
			}else {
				right--; // move right pointer
			}
		}
		return new int[] {};
	}
	
	//  Using two pointers when array is not sorted
	public static int[] findPairsUsingTwoPointers(int[] arr, int target) {
		int n = arr.length;
		// to store array element and its index
		int[][] pairs = new int[n][2];
		
		for(int i = 0; i < arr.length; i++) {
			pairs[i][0] = arr[i];
			pairs[i][1] = i;
		}
		
		Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
		
		int left = 0;
		int right = n - 1;
		
		while(left < right) {
			int sum = pairs[left][0] + pairs[right][0];
			if(sum == target ) {
				return new int[] {pairs[left][1], pairs[right][1]};
			}else if(sum < target) {
				left++;
			}else {
				right--;
			}
				
		}
		return new int[] {};
		
	}

	
	public static void main(String[] args) {
	    int[] arr = new int[] {4, 5, -10, 8, 6};
	    int target = 30;
	    int[] indicesArr = findPairsUsingTwoPointers(arr, target);
	    if(indicesArr.length == 2) {
	    		System.out.println("Indices: " + indicesArr[0] + " " + indicesArr[1]);
	    }else {
	    	 System.out.println("No such pair exists");
	    }
	}

}
