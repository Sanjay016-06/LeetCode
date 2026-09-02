class Solution {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        int dir[][]={{0,1},{-1,0},{0,-1},{1,0}};
        int i=0;
        int x=0;
        int y=0;
        for(int j=0;j<n;j++)
            {
                if(instructions.charAt(j)=='L')
                {
                    i=(i+1)%4;
                }
                else if(instructions.charAt(j)=='R')
                {
                    i=(i+3)%4;
                }
                else
                {
                    x+=dir[i][0];
                    y+=dir[i][1];
                }
            }
        return x==0 && y==0 || i!=0;
    }
}