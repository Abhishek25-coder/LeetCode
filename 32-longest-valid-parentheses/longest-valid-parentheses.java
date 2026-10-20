class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        int MaxLen = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop();
                //agar jo pop hua h wo opening bracket ka index
                //nhi tha to pkka stack empty hoga
                if(st.isEmpty()){
                    //invalid case
                    //reset krdo
                    st.push(i);
                }
                else{
                    //valid case
                    int currLen = i - st.peek();
                    MaxLen = Math.max(MaxLen,currLen);
                }
            }
        }
        return MaxLen;
    }
}