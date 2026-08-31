class Solution {
    public int differenceOfSum(int[] nums) {
       int sum=0;
       int s=0;
       for(int x:nums){
        sum = sum+x;
       } 
       for(int h:nums){
        while(h!=0){
            int d = h%10;
            h /= 10;
            s=s+d;
        }
       }
       return sum - s;
    }
}