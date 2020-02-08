package aam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewofTree {

	
	public List leftView(TreeNode root) {
        List leftview = new ArrayList<>();
        Queue q = new LinkedList<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            leftview.add(q.peek().val);
            Queue nextLevel = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode node = q.poll();
                if(node.left != null) nextLevel.add(node.left);
                if(node.right != null) nextLevel.add(node.right);
            }
            q = nextLevel;
        }
        return leftview;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
}
