package org.example;


import junit.framework.Assert;
import junit.framework.TestCase;

public class MaxLevelSumBinaryTreeTest extends TestCase {

    public void testDAC() {

        MaxLevelSumBinaryTree.TreeNode treeNode = new MaxLevelSumBinaryTree.TreeNode(-100,
                new MaxLevelSumBinaryTree.TreeNode(-200,
                new MaxLevelSumBinaryTree.TreeNode(-20), new MaxLevelSumBinaryTree.TreeNode(-5)),

                new MaxLevelSumBinaryTree.TreeNode(-300,
                        new MaxLevelSumBinaryTree.TreeNode(-10), null));

        int res = new MaxLevelSumBinaryTree().maxLevelSum(treeNode);
        Assert.assertEquals(3, res);
    }

}
