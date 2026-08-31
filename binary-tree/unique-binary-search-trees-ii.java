/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helperGenerateTrees(1, n);
    }

    private List<TreeNode> helperGenerateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int rootVal = start; rootVal <= end; rootVal += 1) {

            List<TreeNode> leftTrees =  helperGenerateTrees(start, rootVal - 1);
            List<TreeNode> rightTrees = helperGenerateTrees(rootVal + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree: rightTrees) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}