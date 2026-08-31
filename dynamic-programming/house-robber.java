class Solution {
    public int rob(int[] nums) {
        int a=0,b=0,m=0;
        for(int i:nums){
            m = Math.max(a,b+i);
            b =a;
            a =m;
        }
        return m;
    }
}