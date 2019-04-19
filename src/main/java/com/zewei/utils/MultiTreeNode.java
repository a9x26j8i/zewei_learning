package com.zewei.utils;

import java.util.ArrayList;

public class MultiTreeNode {
    public Integer _val;
    public ArrayList<MultiTreeNode> _children;
    public MultiTreeNode(int val, ArrayList<MultiTreeNode> children) {
        _val = val;
        _children = children;
    }
}
