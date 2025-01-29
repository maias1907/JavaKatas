package katas.exercises;

/**
 * Kth Smallest Element in a Binary Search Tree
 *
 * Given a BST, write a function to find the Kth smallest element.
 *
 * Example:
 *
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *
 * The 3rd smallest element is 4.
 *
 * Expected time complexity is O(n), while n is the tree height.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementInBST {
    private static int count = 0;
    private static int result = -1;

    public static int kthSmallest(TreeNode root, int k) {
        count=0;
        if(treeSize(root)<k)
        {
            return  -1;
        }

        inOrderTraversal(root,k);


        return result;
    }
    public static int treeSize(TreeNode root) {
        if (root == null) {
            return 0;  // If the tree is empty, return 0
        }
        // Recursively count the nodes in the left subtree, right subtree, and add 1 for the current node
        return 1 + treeSize(root.left) + treeSize(root.right);
    }
    private static void inOrderTraversal(TreeNode node, int k) {
        // Base case: if node is null, return

        if (node == null) {
            return;
        }

        // Traverse the left subtree

            inOrderTraversal(node.left, k);


        // Increment the count

         count=count+1;
        // If count matches k, set the result to the current node's value
        if (count == k) {

            result = node.val;
            return;
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int k = 3;
        int kthSmallestValue = kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element is: " + kthSmallestValue); // Output: 4
    }

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}
