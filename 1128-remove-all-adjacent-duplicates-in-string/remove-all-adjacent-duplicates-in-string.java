class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == ch){
                    //cancel out
                    st.pop();
            }
            else{
                //stack is empty
                st.push(ch);            }
        }

    StringBuilder str = new StringBuilder();

    while(!st.isEmpty()){
        str.append(st.peek());
        st.pop();
       
    }
    return str.reverse().toString();
}
}