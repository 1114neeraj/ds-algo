package algo;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerDeserTree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        inOrder(root, builder);
        return builder.toString();
    }
    
    private void inOrder(TreeNode node, StringBuilder builder) {
        
        if(node == null) {
            builder.append('X').append(' ');
            return;
        }
        
        builder.append(node.val).append(' ');
        inOrder(node.left, builder);
        inOrder(node.right, builder);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Deque<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(" ")));
        return construct(queue);
    }
    
    private TreeNode construct(Deque<String> queue) {
        
        String value = queue.remove();
        
        if(value.equals("X")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(value));
        
        node.left = construct(queue);
        node.right = construct(queue);
        
        return node;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		right.left = new TreeNode(4);
		right.right = new TreeNode(5);
		root.right = right;
		
		SerDeserTree obj = new SerDeserTree();
		String result = obj.serialize(root);
		System.out.println(result);
	}
	
}
