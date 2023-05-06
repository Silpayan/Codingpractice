package aam;

import java.util.*;

public class ClosestLeafNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode closestLeaf(TreeNode root, TreeNode target) {
        if(root == null || target == null) {
            return null;
        }
        Map<TreeNode, List<TreeNode>> mapping = new HashMap();
        buildAdjList(mapping, root, null);

        Queue<TreeNode> queue = new LinkedList();
        Set visited = new HashSet();

        for (TreeNode node: mapping.keySet()) {
            if (node != null && node == target) {
                queue.add(node);
                visited.add(node);
                break;
            }
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (mapping.get(node).size() <= 1) {
                    return node;
                }
                for (TreeNode n: mapping.get(node)) {
                    if (!visited.contains(n)) {
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
        }
        return null;
    }

    public void buildAdjList(Map<TreeNode, List<TreeNode>> mapping, TreeNode node, TreeNode p) {
        if (!mapping.containsKey(node)) {
            mapping.put(node, new ArrayList<>());
        }
        if (!mapping.containsKey(p)) {
            mapping.put(p, new ArrayList<>());
        }
        if (node != null) {
            mapping.get(p).add(node);
            mapping.get(node).add(p);
            if (node.left != null) {
                buildAdjList(mapping, node.left, node);
            }
            if (node.right != null) {
                buildAdjList(mapping, node.right, node);
            }
        }
    }

}


