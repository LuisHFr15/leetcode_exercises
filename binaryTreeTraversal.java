/*
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

import java.util.ArrayList;
import java.util.List;

public class binaryTreeTraversal {
    public class TreeNode {
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
  
    public void dfs(TreeNode root, List<List<Integer>> nodesLevels, int currentLevel) {
        if(root == null) return;

        if(nodesLevels.size() <= currentLevel) {
            nodesLevels.add(new ArrayList<>());
        }

        int nodeValue = root.val;
        nodesLevels.get(currentLevel).add(nodeValue);

        dfs(root.left, nodesLevels, currentLevel + 1);
        dfs(root.right, nodesLevels, currentLevel + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodesLevels = new ArrayList<>();

        if(root == null) {
            return nodesLevels;
        }
        
        dfs(root, nodesLevels, 0);

        return nodesLevels;
    }
}
