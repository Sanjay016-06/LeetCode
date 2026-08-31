class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = (int)(Math.log(n)/Math.log(2))+1;
        int[][] st = new int[m][n];

        for(int i=0;i<n;i++)st[0][i] = nums[i];

        for(int i=1;i<=m;i++){
            for(int j=0;j+(1<<i)<=n;j++){
                st[i][j] = Math.max(st[i-1][j], st[i-1][j+(1<<(i-1))]);
            }
        }

        int[] out = new int[n-k+1];
        int logK = (int)(Math.log(k)/Math.log(2));
        for(int i=0;i<=n-k;i++){
            out[i] = Math.max(st[logK][i], st[logK][i+k-1-(1<<logK)+1]);
        }
        return out;
    }
}