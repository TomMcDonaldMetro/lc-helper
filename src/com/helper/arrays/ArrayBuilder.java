package com.helper.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ArrayBuilder {

	/**
	 * Takes a copied input from LeetCode of the form [a,b,c,...] and returns a
	 * String[] representation. Can then be used with Arrays.stream to fill out an
	 * array.
	 * 
	 * Must follow byte length requirements if copying from source other than
	 * LeetCode.
	 * 
	 * @param s
	 * @return
	 */
	public static String[] buildArray(String s) {

		ArrayList<String> arr = new ArrayList<>();

		String temp = "";

		for (int i = 0; i < s.length(); i++) {

			char curr = s.charAt(i);
			if (curr == '[') {
				continue; // ignore so it doesn't get added to the list.
			} else if (curr == ']') {
				arr.add(temp);
				break; // single dimension array, anything after will be unnecessary.
			} else if (curr == ',') {
				arr.add(temp);
				temp = "";
			} else {
				temp += curr;
			}
		}

		return arr.toArray(new String[arr.size()]);
	}

	/**
	 * Convert a String representation of a LeetCode 2D Array of the form [[a,b],[c,d],[...]] to a String ArrayList.
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	private static ArrayList<ArrayList<String>> build2dArray(String s) throws Exception {

		ArrayList<ArrayList<String>> arrArr = new ArrayList<ArrayList<String>>();
		Stack<Character> stack = new Stack<>();
		String temp = "";

		s = s.replaceAll("\\s", ""); // remove white space that may have entered.

		ArrayList<String> tempArr = new ArrayList<>();
		int index = 0;

		if (s.charAt(index) == '[') {
			stack.push(s.charAt(index));
			index++;

		} else { // if not of the correct form, throw error.
			throw new Exception("Invalid Input: " + s.charAt(index) + " at position - " + index + " invalid format.");

		}

		while (!stack.isEmpty()) {

			if (s.charAt(index) == '[') {
				stack.push(s.charAt(index));

			} else if (s.charAt(index) == ',') {
				tempArr.add(temp);

				if (stack.size() == 1) {
					arrArr.add(tempArr);
					tempArr = new ArrayList<String>();

				}

				temp = "";

			} else if (s.charAt(index) == ']') {
				stack.pop();

			} else {
				temp += s.charAt(index);

			}

			index++;

		}

		// final element and array being inserted.
		tempArr.add(temp);
		arrArr.add(tempArr);

		return arrArr;

	}

	/**
	 * Convert a 2D Array LeetCode String representation to a 2D integer array.
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static int[][] string2dInteger(String s) throws Exception {

		ArrayList<ArrayList<String>> arrArr = build2dArray(s);
		int[][] res = new int[arrArr.size()][];

		for (int i = 0; i < arrArr.size(); i++) {
			String[] temp = arrArr.get(i).toArray(new String[arrArr.get(i).size()]);
			res[i] = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
		}

		return res;

	}

	/**
	 * Convert a 2D Array LeetCode String representation to a 2D double array.
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static double[][] string2dDouble(String s) throws Exception {

		ArrayList<ArrayList<String>> arrArr = build2dArray(s);
		double[][] res = new double[arrArr.size()][];

		for (int i = 0; i < arrArr.size(); i++) {
			String[] temp = arrArr.get(i).toArray(new String[arrArr.get(i).size()]);
			res[i] = Arrays.stream(temp).mapToDouble(Double::parseDouble).toArray();
		}

		return res;
	}

	/**
	 * Converting String ArrayList to a String Array.
	 * 
	 * keeping with the pattern of having all primitive arrays as return types.
	 * 
	 * @param s
	 * @return
	 * @throws Exception 
	 */
	public static String[][] string2dString(String s) throws Exception {

		ArrayList<ArrayList<String>> arrArr = build2dArray(s);
		String[][] res = new String[arrArr.size()][];

		for (int i = 0; i < arrArr.size(); i++) {
			String[] temp = arrArr.get(i).toArray(new String[arrArr.get(i).size()]);
			res[i] = temp;
		}

		return res;
		
	}

}
