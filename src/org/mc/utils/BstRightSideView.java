package org.mc.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.mc.dataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BstRightSideView {
    public int[] get(TreeNode tree) {
        List<Integer> view = new ArrayList<>();

        if (tree != null)
            getImpl(tree, 0, view);

        return ArrayUtils.toPrimitive(view.toArray(new Integer[0]));
    }

    private void getImpl(TreeNode node, int h, List<Integer> view) {
        if (view.size() == h) {
            view.add(node.value);
        }
        else {
            view.set(h, node.value);
        }

        if (node.hasLeft())
            getImpl(node.left, h+1, view);

        if (node.hasRight())
            getImpl(node.right, h+1, view);
    }
}
