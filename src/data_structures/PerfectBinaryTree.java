package data_structures;

import java.util.ArrayList;

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
        //Creating a perfect binary tree with nodal value -1.
        tree.insertNode();
        tree.insertNode();
        tree.insertNode();
        tree.insertNode();
        tree.insertNode();
        tree.insertNode();
        tree.insertNode();

        //Reassigning the nodal values with given input values using DFS post-order traversal.
        tree.reassignNode(PerfectBinaryTree.root, 1);
        tree.reassignNode(PerfectBinaryTree.root, 2);
        tree.reassignNode(PerfectBinaryTree.root, 3);
        tree.reassignNode(PerfectBinaryTree.root, 4);
        tree.reassignNode(PerfectBinaryTree.root, 5);
        tree.reassignNode(PerfectBinaryTree.root, 6);
        tree.reassignNode(PerfectBinaryTree.root, 7);
        tree.printTree(PerfectBinaryTree.root);

        //Determining the Tree Height
        System.out.println("Tree Height: " + tree.treeHeight(PerfectBinaryTree.root, 0));
    }
}

