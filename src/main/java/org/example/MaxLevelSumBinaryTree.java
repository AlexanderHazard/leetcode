package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MaxLevelSumBinaryTree {

    public int maxLevelSum(TreeNode root) {
        Integer[] levelsSum = new Integer[11];
        //Arrays.fill(levelsSum, 0);
        levelSum(root, 0, levelsSum);

        int max = 0;
        int maxVal = levelsSum[0];

        for (int i = 1; i < levelsSum.length; i++) {
            log.info("Looking for level");
            Integer cand = levelsSum[i];
            if (cand == null) {
                break;
            }

            if (cand > maxVal) {
                max = i;
                maxVal = cand;
            }
        }

        return max+1;
    }

    public void levelSum(TreeNode node, int level, Integer[] levelsSum) {
        if (node == null) {
            return;
        }

        levelsSum[level] = levelsSum[level] != null ? levelsSum[level] + node.val : node.val;

        levelSum(node.left, level + 1, levelsSum);
        levelSum(node.right, level + 1, levelsSum);
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
