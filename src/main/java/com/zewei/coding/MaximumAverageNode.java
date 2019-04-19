package com.zewei.coding;

import com.zewei.utils.MultiTreeNode;
import com.zewei.utils.TreeNode;

import java.util.ArrayList;

/*
*  Amazon OA2
* */
public class MaximumAverageNode {
    public static void main(String[] agrs) {
        MaximumAverageNode s = new MaximumAverageNode();
        s.testMaximumAverageMultiNode();
    }

    private void testMaximumAverageMultiNode(){
        MultiTreeNode root = buildMultiTree();
        MultiResult result = dfsMultiNode(root);
        System.out.println(result._maxNode._val);
    }

    private static void testMaximumAverageNode(){
        int[] tree = new int[] {1, -5, 11, 1, 2, 4, -2};
        MaximumAverageNode s = new MaximumAverageNode();
        TreeNode root = s.dfsBuildTree(tree, 0);
        TreeNode result = s.maximumAverageNode(root);
        System.out.println(result._val);
    }

    private TreeNode maximumAverageNode(TreeNode tree) {
        Result result = dfs(tree);
        return result._maxNode;
    }

    private MultiTreeNode maximumAverageMultiNode(MultiTreeNode tree) {
        MultiResult result = dfsMultiNode(tree);
        return result._maxNode;
    }

    private Result dfs(TreeNode node) {
        //base case, fake node
        if (node == null) {
            return new Result(null, 0, 0);
        }
        //general case
        Result r1 = dfs(node._left);
        Result r2 = dfs(node._right);
        double sum = r1._sum + r2._sum + node._val;
        double count = r1._count + r2._count + 1;
        //my result
        TreeNode maxNode = node;

        if (r1._sum * count > sum * r1._count) {
            maxNode = r1._maxNode;
        }
        if (r2._sum * count > sum * r2._count) {
            maxNode = r2._maxNode;
        }

        return new Result(maxNode, sum, count);
    }

    private MultiResult dfsMultiNode(MultiTreeNode node) {
        //base case
        if (node == null) {
            return new MultiResult(null, 0, 0);
        }
        //general case
        MultiTreeNode maxNode = null;
        double sum = -Double.MAX_VALUE;
        double count = 1;
        double sum_all = node._val;
        double count_all = node._children != null ? node._children.size() + 1 : 1;

        //for Leaf Node
        if (node._children == null) {
            return new MultiResult(node, node._val, 1);
        }

        //none-leaf node
        for (int i = 0; i < node._children.size(); i++) {
            MultiResult result = dfsMultiNode(node._children.get(i));
            sum_all += result._sum;
            if (result._sum * count > sum * result._count) {
                sum = result._sum;
                count = result._count;
                maxNode = result._maxNode;
            }
        }
        if (sum_all * count > sum * count_all) {
            sum = sum_all;
            count = count_all;
            maxNode = node;
        }

        return new MultiResult(maxNode, sum, count);
    }

    private void dfsPrint(TreeNode node){
        System.out.println(node._val);
        if (node._left != null) {
            dfsPrint(node._left);
        }
        if (node._right != null) {
            dfsPrint(node._right);
        }
    }
    private TreeNode dfsBuildTree(int[] tree, int pos) {
        TreeNode node = new TreeNode(tree[pos]);
        int n = tree.length;
        if (pos*2 + 1 <= n - 1) {
            node._left = dfsBuildTree(tree, pos * 2 + 1);
        }
        if (pos*2 + 2 <= n - 1) {
            node._right = dfsBuildTree(tree, pos * 2 + 2);
        }
        return node;
    }
    private MultiTreeNode buildMultiTree(){
        MultiTreeNode root = new MultiTreeNode(1, new ArrayList<>());

        root._children.add(new MultiTreeNode(-5, new ArrayList<>()));
        root._children.add(new MultiTreeNode(1, new ArrayList<>()));
        root._children.add(new MultiTreeNode(11, new ArrayList<>()));

        root._children.get(0)._children.add(new MultiTreeNode(1, null));
        root._children.get(0)._children.add(new MultiTreeNode(2, null));

        root._children.get(1)._children.add(new MultiTreeNode(3, null));
        root._children.get(1)._children.add(new MultiTreeNode(1, null));

        root._children.get(2)._children.add(new MultiTreeNode(5, null));
        root._children.get(2)._children.add(new MultiTreeNode(6, null));
        return root;
    }
}

class Result{
    TreeNode _maxNode;
    double _sum;
    double _count;
    public Result(TreeNode maxNode, double sum, double count) {
        _maxNode = maxNode;
        _sum = sum;
        _count = count;
    }
}

class MultiResult{
    MultiTreeNode _maxNode;
    double _sum;
    double _count;
    public MultiResult(MultiTreeNode maxNode, double sum, double count) {
        _maxNode = maxNode;
        _sum = sum;
        _count = count;
    }
}