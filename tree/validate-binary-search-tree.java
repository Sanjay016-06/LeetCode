class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBinarySearchTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isBinarySearchTree(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBinarySearchTree(root.left, min, root.val) && isBinarySearchTree(root.right, root.val, max);
    }
}