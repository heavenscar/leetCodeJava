package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the 
 * shortest path from the root node down to the nearest leaf node.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MinimumDepthofBinaryTree {
	
    public int minDepth(TreeNode root) {
    	Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    	Queue<TreeNode> temp;
    	int depth = 0;
    	int min = Integer.MAX_VALUE;
    	
    	if (root == null) return 0;
    	
    	// simply use a modified breadth-first search to find the first leaf node.
    	nodeQueue.offer(root);
    	while (!nodeQueue.isEmpty()) {
			temp = new LinkedList<TreeNode>();
			depth++;
    		for (TreeNode node : nodeQueue) {
    			if (!isLeaf(node)) {
    				System.out.println("not leaf!");
    				if (node.right != null) temp.offer(node.right);
    				if (node.left != null) temp.offer(node.left);
    			} else {
    				if (depth < min) {
    					System.out.println(min+", "+depth);
    					min = depth;
    				}
    				break;
    			}
    		}
    		nodeQueue = temp;
    	}
        return min;
    }
    
    // helper method to tell if a node is leaf or not.
    private boolean isLeaf(TreeNode node) {
    	return node.right == null && node.left == null;
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x;}
	}
	
	// small test, not covering all condition obviously.
	public static void main(String[] args) {
		MinimumDepthofBinaryTree solution = new MinimumDepthofBinaryTree();
		TreeNode root = solution.new TreeNode(1);
		System.out.println(solution.minDepth(root));
	}
}
