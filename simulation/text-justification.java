class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (count + 1 + words[last].length() > maxWidth) break;
                    count += 1 + words[last].length();
                    last++;
                
            }
            StringBuilder s = new StringBuilder();
            s.append(words[index]);
            int diff = last - index - 1;
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    s.append(" ");
                    s.append(words[i]);
                }
                for (int i = s.length(); i < maxWidth; i++) {
                    s.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int extraspaces = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int sp = spaces; sp > 0; sp--) {
                        s.append(" ");
                    }

                    if (extraspaces > 0) {
                        s.append(" ");
                        extraspaces--;
                    }
                    s.append(" ");
                    s.append(words[i]);

                }
            }
            lines.add(s.toString());
            index = last;
        }
        return lines;

    }
}