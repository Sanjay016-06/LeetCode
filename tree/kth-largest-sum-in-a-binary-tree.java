
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root==null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(); // this is a minHeap

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left!=null) q.add(curr.left); 
                if(curr.right!=null) q.add(curr.right); 
            }
            pq.add(sum);
            while(pq.size()>k) pq.poll();
        }
        return (pq.size()<k) ? -1 : pq.peek();
    }
}