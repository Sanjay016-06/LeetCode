class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        bt(nums, new ArrayList<>(), 0);
        return result;
    }

    void bt(int[] nums, List<Integer> temp, int idx) {

        result.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.length; i++) {

            temp.add(nums[i]);

            bt(nums, temp, i + 1);

            temp.remove(temp.size() - 1);
        }
    }
}