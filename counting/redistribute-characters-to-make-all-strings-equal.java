class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(char ch : word.toCharArray()){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        for(int count: map.values()){
            if(count % words.length != 0){
                return false;
            }
        }
        return true;
    }
}