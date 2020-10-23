
public class MyBinarySearchTree {
    static TreeNode root;

    void add(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            TreeNode current = root;
            while (true) {
                if (current != null) {
                    if (data < current.data) {
                        if (current.left != null) {
                            current = current.left;
                        } else {
                            current.left = new TreeNode(data);
                            break;
                        }
                    } else {
                        if (current.right != null) {
                            current = current.right;
                        } else {
                            current.right = new TreeNode(data);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }

    public void remove(int data) {
        if (root != null) {
            TreeNode current = root;
            TreeNode previous = current;
            while (true) {
                if (current != null) {
                    if (current.data == data) {
                        if (previous.right == current) {
                            previous.right = current.right;
                            break;
                        } else if (previous.left == current) {
                            previous.left = current.left;
                            break;
                        }
                    }
                    if (data < current.data) {
                        if (current.left != null) {
                            previous = current;
                            current = current.left;
                        }
                    } else if (current.right != null) {
                        previous = current;
                        current = current.right;
                    }
                }
            }
        }
    }

    public void printTree(TreeNode root) {
        if (root != null) {
            //System.out.println(root.data); //(pre-order)
            if (root.left != null) {
                printTree(root.left);
            }
            //System.out.println(root.data); //(in-order)
            if (root.right != null) {
                printTree(root.right);
            }
            //System.out.println(root.data); //(post-order)
        }
    }

    public int treeHeight(TreeNode root, int treeHeight) {
        if (root != null) {
            treeHeight = Math.max(treeHeight(root.left, treeHeight), treeHeight(root.right, treeHeight));
            treeHeight++;
        }
        return treeHeight;
    }
}

class TreeNode {
    int data;
    TreeNode right = null;
    TreeNode left = null;

    public TreeNode(int data) {
        this.data = data;
    }
}

class TreeSolution {
    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.add(9);
        tree.add(4);
        tree.add(1);
        tree.add(6);
        tree.add(20);
        tree.add(15);
        tree.add(170);
        tree.printTree(MyBinarySearchTree.root);
        System.out.println();
        System.out.println(tree.treeHeight(MyBinarySearchTree.root, 0));
    }
}
