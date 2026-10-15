class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char ch: s.toCharArray()){
            //if this is a open bracket
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
            //if there is a closing bracket
            //first check if stack is empty or not
            if(st.isEmpty()){
                return false;
            }
            if(ch == ')' && st.peek() != '('){
                //no match
                return false;
            }
            else if(ch == '}' && st.peek() != '{'){
                //no match
                return false;
            }
            else if(ch == ']' && st.peek() != '['){
                //no match
                return false;
            }
            else{
                //match -> pop out all characters
                st.pop();
            }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        else{
            return false;
        } 
    }
}