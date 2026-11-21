package com.netjstech.twopointer;

/**
 * String palindrome or not using two pointer approach
 * When the string may contain spaces and special characters
*/
public class PalindromeSpecial {
	
	public static boolean checkPalindrome2Pointer(String str) {
		int left = 0;
		int right = str.length() - 1;
		
		while(left < right) {
			char start = str.charAt(left);
			char end = str.charAt(right);
			
			if(!Character.isLetterOrDigit(start)) {// check for special char
				left++;
			}else if(!Character.isLetterOrDigit(end)) { // check for special char
				right--;
			}else if(Character.toLowerCase(start) != Character.toLowerCase(end)) {
				return false;
			}else {
				left++;
				right--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	    String test1 = "madam";
	    String test2 = "A man, a plan, a canal: Panama";
	    String test3 = "race a car";
	    
	    System.out.println("Testing with string: " + test1);
	    System.out.println("Is Palindrome: " + checkPalindrome2Pointer(test1));
	        
	    System.out.println("\nTesting with string: " + test2);
	    System.out.println("Is Palindrome: " + checkPalindrome2Pointer(test2));

	    System.out.println("\nTesting with string: " + test3);
	    System.out.println("Is Palindrome: " + checkPalindrome2Pointer(test3));

	}

}
