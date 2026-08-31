class Solution {
    public int pivotInteger(int n) {
        for(int x = 1;x<=n;x++){
            int ls=0,rs=0;
            for(int i=1;i<=x;i++){
                ls+=i;
        }
        for(int j=x;j<=n;j++){
            rs+=j;}
        if(ls==rs) return x;
    }
    return -1;
    }
}