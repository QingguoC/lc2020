class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() <= 1) return s;
        StringBuilder sb;
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(char c: charArr){
            if(c != ']'){
                stack.push(c);
            } else{
                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    sb.append(stack.pop());
                }
                String toRepeat = reverse(sb.toString());
                stack.pop();
                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.append(stack.pop());
                }
                int repeat = Integer.valueOf(reverse(sb.toString()));
                String full = "";
                for(int i = 0; i < repeat; i++){
                    full = full + toRepeat;
                }
                for(char m: full.toCharArray()){
                    stack.push(m);
                }
            }
        }
        sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return reverse(sb.toString());
    }
    
    private String reverse(String s){
        if(s == null || s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        for(int i = charArr.length - 1; i>= 0; i--){
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
}

//stack char
