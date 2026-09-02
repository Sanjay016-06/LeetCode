import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int cumulativeSum = 0;  
        int result = 0;         

        for (int i = satisfaction.length - 1; i >= 0; i--) {
            
            cumulativeSum += satisfaction[i];

            if (cumulativeSum <= 0) {
                break;
            }

            result += cumulativeSum;
        }

        return result;
    }
}