class Solution {
    public long maxArrayValue(int[] nums) {
     	long sum=0;
	     long current=nums[nums.length-1];
		 for(int i=nums.length-2;i>=0;i--)
		 {
			if(current>=nums[i])
			{
			   	current+=nums[i];
			}
			else {
			   current=nums[i];
			}
		 }
	
        return current;
    }
}