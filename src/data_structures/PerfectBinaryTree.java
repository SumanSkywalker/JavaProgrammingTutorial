package data_structures;

import java.util.*;

class PerfectBinaryTree {
    static PerfectTreeNode root;
    private static ArrayList<PerfectTreeNode> Nodes = new ArrayList<>();

    void insertNode() {
        if (PerfectBinaryTree.Nodes.isEmpty()) {
            PerfectBinaryTree.root = new PerfectTreeNode(-1);
            PerfectBinaryTree.Nodes.add(PerfectBinaryTree.root);
        } else {
            PerfectTreeNode current = PerfectBinaryTree.Nodes.get(0);
            if (current.left == null) {
                current.left = new PerfectTreeNode(-1);
                PerfectBinaryTree.Nodes.add(current.left);
            } else {
                current.right = new PerfectTreeNode(-1);
                PerfectBinaryTree.Nodes.add(current.right);
                if (PerfectBinaryTree.Nodes.get(0).left != null && PerfectBinaryTree.Nodes.get(0).right != null) {
                    PerfectBinaryTree.Nodes.remove(0);
                }
            }
        }
    }

    void printTree(PerfectTreeNode root) {
        if (root != null) {
            //System.out.println(root.data); //(pre-order)
            if (root.left != null) {
                printTree(root.left);
            }
            //System.out.println(root.data); //(in-order)
            if (root.right != null) {
                printTree(root.right);
            }
            System.out.println(root.data); //(post-order)
        }
    }

    PerfectTreeNode reassignNode(PerfectTreeNode root, int data) {
        if (root != null) {
            if (root.left != null && root.left.data == -1) {
                return reassignNode(root.left, data);
            } else if (root.right != null && root.right.data == -1) {
                return reassignNode(root.right, data);
            }
            if (root.data == -1) root.data = data; //(post-order)
        }
        return root;
    }

    int treeHeight(PerfectTreeNode root, int height) {
        if (root != null) {
            height = Math.max(treeHeight(root.left, height), treeHeight(root.right, height));
            height++;
        }
        return height;
    }

    void findParents(Hashtable<Integer, Integer> ht, PerfectTreeNode root) {
        if (root != null) {
            //System.out.println(root.data); //(pre-order)
            if (root.left != null) {
                findParents(ht, root.left);
            }
            //System.out.println(root.data); //(in-order)
            if (root.right != null) {
                findParents(ht, root.right);
            }
            if (root.left != null && root.right != null) {
                ht.put(root.left.data, root.data);
                ht.put(root.right.data, root.data);
            }
        }
    }
}

class PerfectTreeNode {
    int data;
    PerfectTreeNode right = null;
    PerfectTreeNode left = null;

    PerfectTreeNode(int data) {
        this.data = data;
    }
}

class PerfectTreeSolution {
    public static void main(String[] args) {
        PerfectBinaryTree tree = new PerfectBinaryTree();
        //Calculate n - no.of.tree nodes
        int h = 3;
        int n = new PerfectTreeSolution().TreeNodesCount(h);

        //Creating a perfect binary tree with n nodes of value -1.
        for (int i = 0; i < n; i++) tree.insertNode();

        //Reassigning the nodal values with given input values using DFS post-order traversal.
        for (int i = 1; i <= n; i++) tree.reassignNode(PerfectBinaryTree.root, i);

        //Printing the elements of the tree.
        tree.printTree(PerfectBinaryTree.root);

        //Creating an HashTable with node as keys and parent values
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        tree.findParents(ht, PerfectBinaryTree.root);
        ht.put(n, -1);

        //Determining the Tree Height.
        System.out.println("Tree Height: " + tree.treeHeight(PerfectBinaryTree.root, 0));
    }

    private int TreeNodesCount(int h) {
        int height = 1;
        for (int i = 1; i < h; i++) {
            height = (height*2) + 1;
        }
        return height;
    }
}
