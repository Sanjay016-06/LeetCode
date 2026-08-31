public class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        boolean negative = x < 0;
        if (negative) {
            sb.deleteCharAt(0); // remove '-'
            sb.reverse();
            sb.insert(0, '-');
        } else {
            sb.reverse();
        }
        try {
            int result = Integer.parseInt(sb.toString());
            return result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
