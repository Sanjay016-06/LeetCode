public class Solution {
    public boolean canAliceWin(int[] nums) {
        int S = 0; 
        int D = 0; 
        int T = 0;
        for (int num : nums) {
            T += num;
            if (num < 10) {
                S += num;
            } else {
                D += num;
            }
        }
        return S > T - S || D > T - D;
    }
}
