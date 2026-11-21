package com.netjstech.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCommonElements {
	
	// Using nested loops (Brute force approach)
	public static void findCommonElementsNested(int[] arr1, int[] arr2) {
		for(int i = 0; i < arr1.length; i++) { // outerloop
			for(int j = 0; j < arr2.length; j++) { // inner loop
				if(arr1[i] == arr2[j]) {
					System.out.println(arr1[i]);
					break;
				}
			}
		}
	
	} 
	
	// Two Pointer Approach
	public static List<Integer> findCommonElementsTwoPointer(int[] arr1, int[] arr2) {
		 Arrays.sort(arr1);
		 Arrays.sort(arr2);
		 // pointers
		 int i = 0;
		 int j = 0;
		 List<Integer> resultList = new ArrayList<Integer>();
		 while(i < arr1.length && j < arr2.length) {
			 if(arr1[i] == arr2[j]) {
				 // to avoid duplicate common elements
				 if(resultList.isEmpty() || resultList.get(resultList.size()-1) != arr1[i]) {
					 resultList.add(arr1[i]);
				 }
				 i++;
				 j++;
			 }else if(arr1[i] < arr2[j]) {
				 i++;
			 }else {
				 j++;
			 }
		 }
		 return resultList;
	}
	
	public static void main(String[] args) {
		int[] numArray1 = {2, 4, 3, 4, 6, 5, 5};
	    int[] numArray2 = {4, 7, 4, 5, 1, 5};
	    findCommonElementsNested(numArray1, numArray2);
	    List<Integer> resultList = findCommonElementsTwoPointer(numArray1, numArray2);
	    System.out.println("Commone Elements: " + resultList);

	}

}
