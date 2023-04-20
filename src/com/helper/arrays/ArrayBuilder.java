package com.helper.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

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
	
	public static String[][] build2dArray(String s) throws Exception {
		
		ArrayList<ArrayList<String>> arrArr = new ArrayList<ArrayList<String>>();
		Stack<Character> stack = new Stack<>();
		String temp = "";
		
		s = s.replaceAll("\\s",""); // remove white space that may have entered.
			
		ArrayList<String> tempArr = new ArrayList<>();
		int index = 0;
		
		if(s.charAt(index) == '[') {
			stack.push(s.charAt(index));
			index++;
			
		} else {
			throw new Exception("Invalid Input: " + s.charAt(index) + " at position - " + index + " invalid format.");
			
		}
		
		while(!stack.isEmpty()) {
			
			if(s.charAt(index) == '[') {
				stack.push(s.charAt(index));
				
			}else if(s.charAt(index) == ',') {
				tempArr.add(temp);
				
				if(stack.size() == 1) {
					arrArr.add(tempArr);
					tempArr = new ArrayList<String>();

				}
				
				temp = "";
				
			}else if(s.charAt(index) == ']') {
				stack.pop();
				
			}else {
				temp += s.charAt(index);
				
			}
			
			index++;
			
		}
		
		// final element and array being inserted.
		tempArr.add(temp);
		arrArr.add(tempArr); 
		
		String[][] res = new String[arrArr.size()][];
		for(int i = 0; i < arrArr.size(); i++) {
			ArrayList<String> row = arrArr.get(i);
			res[i] = row.toArray(new String[row.size()]);
		}
		
		return res;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		String s = "[[1,2,3],[4,5,6],[7,8,9]]";
		
		System.out.println(Arrays.deepToString(build2dArray(s)));
		
		
	}
	
}
