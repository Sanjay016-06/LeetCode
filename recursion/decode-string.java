class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int k=0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = (k * 10) + (c - '0');
                continue;
            }

            if(c=='['){
                intStack.push(k);
                k = 0;
                stringStack.push(String.valueOf(c));
                continue;
            }

            if(c != ']'){
                stringStack.push(String.valueOf(c));
                continue;
            }

            StringBuilder item = new StringBuilder();
            while(!stringStack.peek().equals("[")){
                item.insert(0, stringStack.pop());
            }

            stringStack.pop();

            StringBuilder replacement = new StringBuilder();
            int n = intStack.pop();
            for(int i=0; i<n; i++){
                replacement.append(item);
            }
            
            stringStack.push(replacement.toString());
        }

        StringBuilder result = new StringBuilder();
        while(!stringStack.isEmpty()){
            result.insert(0, stringStack.pop());
        }
        return result.toString();
    }
}