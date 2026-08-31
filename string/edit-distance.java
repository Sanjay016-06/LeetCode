class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1]; 
        for (int col = 0; col <= word2.length(); col++) dp[0][col] = col;
        for (int row = 1; row <= word1.length(); row++) dp[row][0] = row;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j - 1], 
                        Math.min(dp[i][j - 1], dp[i - 1][j])
                    ) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}