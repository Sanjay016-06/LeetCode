class Solution {
    public int getLucky(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i) - 96);
        }
        int sum = 0;
        for(int j=1;j<=k;j++){
            sum = 0;
            for(int i=0;i<sb.length();i++){
                int d = sb.charAt(i) - '0';
                sum += d;
            }
            sb.delete(0,sb.length());
            sb.append(sum);
        }
        return sum;
    }
}