class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int j = 0;
        int validPairs = 0;
        int start = 0;

        if (k == 1) {
            return nums;
        }

        for (int end = 1; end < n; end++) {

            if (nums[end] == nums[end - 1] + 1) {
                validPairs++;
            }
            if (end - start + 1 > k) {
                if (nums[end - k + 1] == nums[end - k] + 1) {
                    validPairs--;
                }

                start++;
            }

            if (end - start + 1 == k) {

                if (validPairs == k - 1) {
                    result[j] = nums[end];
                } else {
                    result[j] = -1;
                }

                j++;
            }
        }

        return result;
    }
}