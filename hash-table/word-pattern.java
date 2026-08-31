class Solution {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if(words.length != pattern.length()){
            return false;
        }

        HashMap<Character, String> mapPW = new HashMap<>();
        HashMap<String, Character> mapWP = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){

            char ch = pattern.charAt(i);
            String word = words[i];

            if(mapPW.containsKey(ch)){
                if(!mapPW.get(ch).equals(word)){
                    return false;
                }
            }else{
                mapPW.put(ch, word);
            }

            if(mapWP.containsKey(word)){
                if(mapWP.get(word) != ch){
                    return false;
                }
            }else{
                mapWP.put(word, ch);
            }
        }

        return true;
    }
}