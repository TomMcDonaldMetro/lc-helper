package com.helper.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.helper.arrays.ArrayBuilder;

public class TreeBuilder {

	/**
	 * Given an input following breadth-first format [1,2,3,4,5,6,null, etc] where i*2 + 1 is the left child and i*2 + 2 is the right.
	 * Will construct and return the root of a TreeNode tree. 
	 * 
	 * Warning - Will not work for inputs not following correct format.
	 * @param s
	 * @return
	 */
	public static TreeNode binaryTreeBuilder(String s) {
		
		String[] lcData = ArrayBuilder.buildArray(s);
		TreeNode root = null;
		
		if(lcData.length == 0) {
			return null;
		}else {
			Queue<TreeNode> frontier = new LinkedList<TreeNode>();
			root = new TreeNode(Integer.parseInt(lcData[0]));
			frontier.add(root);
			
			int i = 0;
			
			while(!frontier.isEmpty()) {
				
				TreeNode curr = frontier.poll();
				if(curr != null) {
					try {
						curr.left = new TreeNode(Integer.parseInt(lcData[2*i + 1]));
					} catch(Exception e) {
						curr.left = null;
					}finally {
						frontier.add(curr.left);
					}
					
					try {
						curr.right = new TreeNode(Integer.parseInt(lcData[2*i + 2]));
					} catch(Exception e) {
						curr.right = null;
					}finally {
						frontier.add(curr.right);
					}
				}
				
				i++;
				
			}
		}
		
		return root;
		
	}
	
	
	public static void main(String[] args) {
		
		
		String s = "[1,2,3,4,5,6,null]";
		String[] data = ArrayBuilder.buildArray(s);
		
		TreeNode root = binaryTreeBuilder(s);
		
		System.out.println(root.val + "\n" 
				+ root.left.val + " " + root.right.val + "\n"
				+ root.left.left.val + " " + root.left.right.val + "   "  + root.right.left.val + " " + root.right.right
				);
	}
}
