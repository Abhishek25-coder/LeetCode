class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int additions = 0;

        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }else{
                //ch==')'
                if(st.isEmpty()){
                    additions++;
                }else{
                    st.pop();
                }
            }
        }
        // final ans ke liye -> additions,st.size()
        int finalAns = additions + st.size();
        return finalAns;
    }
}