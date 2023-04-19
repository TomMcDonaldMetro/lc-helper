package com.helper.arrays;

import java.util.ArrayList;

public class ArrayBuilder {
	
	/**
	 * Takes a copied input from LeetCode of the form [a,b,c,...] and returns a String[] representation.
	 * Can then be used with Arrays.stream to fill out an array.
	 * 
	 * Must follow byte length requirements if copying from source other than LeetCode.
	 * 
	 * @param s
	 * @return
	 */
	public static String[] buildArray(String s) {
		
		ArrayList<String> arr = new ArrayList<>();
		String temp = "";
		
		for(int i = 0; i < s.length(); i++) {
			
			char curr = s.charAt(i);
			if(curr == '[') {
				continue; // ignore so it doesn't get added to the list.
			} else if(curr == ']') {
				arr.add(temp);
				break; // single dimension array, anything after will be unnecessary.
			} else if(curr == ',') {
				arr.add(temp);
				temp = "";
			}
			else {
				temp += curr;
			}
		}
		
		return arr.toArray(new String[arr.size()]);
	}
	
}
