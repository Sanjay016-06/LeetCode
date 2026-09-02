class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        Map<String,Integer>dp=new HashMap<>();
        return solve(cuts,0,n,dp);
    }
    private int solve(int []cuts,int i,int j,Map<String,Integer>dp){

        String key=i+","+j;
        if(dp.containsKey(key))return dp.get(key);

        boolean found=false;

        int min=Integer.MAX_VALUE;
        for(int index:cuts){
            
            if(index>i&&index<j){
                found=true;
                int temp=(j-i)+solve(cuts,i,index,dp)+solve(cuts,index,j,dp);
                if(temp<min){
                    min=temp;
                }
            }
            
        }
        int result=0;
        if(found!=true) result=0;
        else result=min;
        dp.put(key,result);
        return result;
        
    }
}