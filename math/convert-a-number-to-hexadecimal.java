class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        char[] m = "0123456789abcdef".toCharArray();
        StringBuffer ans = new StringBuffer();
        while(num != 0){
            int d = num & 15;
            ans.append(m[d]);
           num >>>= 4;
        }
        return ans.reverse().toString();
    }
}