class Solution {
    public int strangePrinter(String s) {
        int dp[][]= new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
        {
            dp[i][i]=1;
        }
        for(int i=1;i<s.length();i++)
        {
            
            for(int j=i-1;j>=0;j--)
            {
                int min=Integer.MAX_VALUE;
                for(int k=j;k<i;k++)
                {
                    int part1=dp[j][k];
                    int part2=k==i-1?0:dp[k+1][i-1];
                    if(s.charAt(k)==s.charAt(i))
                    {
                        min=Math.min(part1+part2,min);
                    }
                    else
                    {
                        min=Math.min(part1+part2+1,min);
                    }
                }
              
                dp[j][i]=min;
            }
        }

        return dp[0][dp.length-1];
        
    }
}