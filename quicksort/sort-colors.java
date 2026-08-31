class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) count[num]++;
        int i = 0;
        for (int j = 0; j < 3; j++) {
            while (count[j]-- > 0) nums[i++] = j;
        }
    }
}