class Solution {
    public int differenceOfSums(int n, int m) {
        int sum=0;
        int sum1=0;
        for(int i=0;i<=n;i++){
            if(i%m!=0){
                sum=sum+i;           
            }
            else continue;
        }
        for(int j=0;j<=n;j++){
            if(j%m==0) sum1=sum1+j;
            else continue;
        }
        return sum-sum1;
    }
}