package com.helper.rewriter;

public class Rewriter {

	
	/**
	 * Simple tool for taking LeetCode example input and rewriting it into Java array syntax.
	 * 
	 * @param s
	 * @return
	 */
	public static String rewrite(String s) {
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		return s;
	}
	
	
}
