class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (j == k) {
                sb.append("-");
                j = 0;
            }
            if (j < k && s.charAt(i) != '-') {
                sb.append(Character.toString(s.charAt(i)).toUpperCase());
                j++;

            }

        }
        String g=sb.reverse().toString();
        if(g.length()>0 && g.charAt(0)=='-'){
            return g.substring(1);
        }

        return g;
    }
}