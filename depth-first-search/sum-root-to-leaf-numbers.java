class Solution {
    void fn(TreeNode root,List ans, int s){
        if(root==null) return;
if(root.left==null && root.right==null){
ans.add(s*10+root.val);
return;
}
fn(root.left,ans,s*10+root.val);
fn(root.right,ans,s*10+root.val);

    }
    public int sumNumbers(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        fn(root,ans,0);
        int a=0;
        for(Integer s: ans){
a+=s;
        }
        return a;

    }
}