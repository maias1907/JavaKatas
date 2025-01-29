import katas.exercises.KthSmallestElementInBST;


import org.junit.jupiter.api.Test;

import static katas.exercises.KthSmallestElementInBST.kthSmallest;
import static org.junit.jupiter.api.Assertions.*;

public class KthSmallestElementInBSTTest {

    @Test
    public void testKthSmallestBalancedTree() {
        // Tree:
        //        5
        //       / \
        //      3   6
        //     / \
        //    2   4
       KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(6);
        root.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.right = new KthSmallestElementInBST.TreeNode(4);

        int k = 3;
        int kthSmallestValue = kthSmallest(root, k);
        assertEquals(4, kthSmallestValue, "The 3rd smallest element should be 4.");
    }

    @Test
    public void testKthSmallestSkewedTree() {
        // Skewed tree (right-heavy):
        // 1 -> 2 -> 3 -> 4 -> 5
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(1);
        root.right = new KthSmallestElementInBST.TreeNode(2);
        root.right.right = new KthSmallestElementInBST.TreeNode(3);
        root.right.right.right = new KthSmallestElementInBST.TreeNode(4);
        root.right.right.right.right = new KthSmallestElementInBST.TreeNode(5);

        int k = 2;
        int result = kthSmallest(root, k);
        assertEquals(2, result, "The 2nd smallest element should be 2.");
    }

    @Test
    public void testKthSmallestSingleNode() {
        // Single node tree
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(10);

        int k = 1;
        int result = kthSmallest(root, k);
        assertEquals(10, result, "The 1st smallest element in a single node tree should be 10.");
    }

   @Test
    public void testKthSmallestFirstElement() {
        // Tree:
        //        3
        //       / \
        //      1   4
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(3);
        root.left = new KthSmallestElementInBST.TreeNode(1);
        root.right = new KthSmallestElementInBST.TreeNode(4);

        int k = 1;
        int result = kthSmallest(root, k);
        assertEquals(1, result, "The 1st smallest element should be 1.");
    }

    @Test
    public void testKthSmallestLastElement() {
        // Tree:
        //        3
        //       / \
        //      1   4
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(3);
        root.left = new KthSmallestElementInBST.TreeNode(1);
        root.right = new KthSmallestElementInBST.TreeNode(4);

        int k = 3;
        int result = kthSmallest(root, k);
        assertEquals(4, result, "The 3rd smallest element should be 4.");
    }

    @Test
    public void testKthSmallestInvalidK() {
        // Tree:
        //        5
        //       / \
        //      3   6
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST. TreeNode(6);

        int k = 5; // Invalid k, as there are only 3 elements
        int result = kthSmallest(root, k);
        assertEquals(-1, result, "Invalid k should return -1.");


            }


}
