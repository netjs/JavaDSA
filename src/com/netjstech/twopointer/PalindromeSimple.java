package com.netjstech.twopointer;

/**
 * String palindrome or not using two pointer approach
 * FOR SIMPLE STRINGS
 */
public class PalindromeSimple {
	
	public static boolean checkPalindrome2Pointer(String str) {
		// pointers
		int left = 0;
		int right = str.length() - 1;
		
		while(left < right) {
			// comparison of characters
			if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
				return false;
			}
			// move pointers
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
	    String test1 = "madam";
	    String test2 = "Malayalam";
	    String test3 = "test";
	  
	    System.out.println("Testing with string: " + test1);
	    System.out.println("Is Palindrome: " + checkPalindrome2Pointer(test1));
	        
	    System.out.println("\nTesting with string: " + test2);
	    System.out.println("Is Palindrome: " + checkPalindrome2Pointer(test2));

	    System.out.println("\nTesting with string: " + test3);
	    System.out.println("Is Palindrome: " + checkPalindrome2Pointer(test3));
	            

	}

}
