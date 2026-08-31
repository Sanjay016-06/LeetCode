class Solution {
     public int strStr(String haystack, String needle) {
        int indx = 0;
        int needleIndex = 0;
        for (int i = 0; i < haystack.length(); i++) {
            char hs = haystack.charAt(i);
            char n = needle.charAt(needleIndex);
            if ((hs == n) && (needleIndex == needle.length() - 1)) {
                return needleIndex == 0 ? i : indx;
            } else if (hs == n) {
                if (needleIndex == 0) {
                    indx = i;
                }
                needleIndex++;
            } else if(needleIndex > 0){
                i = indx;
                needleIndex = 0;
            }
        }
        return -1;
    }
}