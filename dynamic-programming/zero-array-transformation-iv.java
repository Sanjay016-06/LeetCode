class Solution {
    Integer[][]dp;
    public int minZeroArray(int[] nums, int[][] queries) {
        
         int ans=-1;
        for(int i=0;i<nums.length;i++){
             int t=nums[i];
            dp=new Integer[queries.length][t+1];
            int k=f(0,queries,i,t,0);
           ans=Math.max(ans,k);
        }
        if(ans>queries.length)return -1;
        return ans;
    }
    public int bs(int[][]q,int t){
        int s=0;
        int e=q.length-1;
        int ans=-1;
        while(s<=e){
            int m=(s+e)/2;
            if(q[m][0]<t){
                s=m+1;
                ans=m;
            }
            else e=m-1;
        }
        return ans;
    }
     public int bs1(int[][]q,int t){
        int s=0;
        int e=q.length-1;
        int ans=q.length;
        while(s<=e){
            int m=(s+e)/2;
            if(q[m][0]>t){
                e=m-1;
                ans=m;
            }
            else s=m+1;
        }
        return ans;
    }
    public int f(int idx,int[][]q,int e,int t,int i){
        if(t==0){
            return idx;
        }
        if(t<0)return q.length+1;
        if(idx>=q.length){
            if(t==0)return q.length;
            return q.length+1;
        }
        if(dp[idx][t]!=null)return dp[idx][t];
        int ans=q.length+1;
      if(q[idx][0]<=e&&q[idx][1]>=e){
        ans=Math.min(ans,f(idx+1,q,e,t-q[idx][2],0));
      }
        ans=Math.min(ans,f(idx+1,q,e,t,i));
        return dp[idx][t]=ans;
    }
}