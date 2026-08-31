class Solution {
    public int eraseOverlapIntervals(int[][] inp) {
        Arrays.sort(inp,(a,b)->a[1]-b[1]);
        int ans =0,n = inp.length;
        int end = Integer.MIN_VALUE;
        for(int[] i : inp){
            if(end > i[0]) ans++;
            else end =i[1];
        }
        return ans;
    }
}