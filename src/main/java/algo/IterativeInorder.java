package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorderTraversal = new ArrayList<>();
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		
		while(current!=null && !stack.isEmpty()) {
			
			while(current!=null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			inorderTraversal.add(current.val);
			current = current.right;
			
		}
		
		return inorderTraversal;
	}

}
