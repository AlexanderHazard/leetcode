package org.example;

public class MaxLevelSumBinaryTree {

    public int maxLevelSum(TreeNode root) {
    }

    public Integer levelSum(TreeNode node, int level, int tgtLevel) {
        if (level == tgtLevel) {
            return node.val;
        }

        Integer leftVal = null;
        Integer rightVal = null;

        if (node.left != null && node.right != null) {

        }

        if (node.left != null) {
            leftVal = levelSum(node.left, level + 1, tgtLevel);
        }

        if (node.right != null) {
            rightVal = levelSum(node.right, level + 1, tgtLevel);
        }


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
