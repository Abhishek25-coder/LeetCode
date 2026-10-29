class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();

        //apply monotonic stack pattern
        for(char ch: num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek() > ch){
                st.pop();
                k--;
            }
            //currrent element ko push krna h
            st.push(ch);
        }
        //step 2: agar kuch k removal pending h to uss condition me 
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        //answer build krna h, reverse krna h aur leading zeroes ko remove krna h
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop();
        }
        //reverse ans
        ans.reverse();
        //remove leading zeroes
        int index = 0;
        while(index < ans.length() && ans.charAt(index) == '0'){
            index++;
        } 
        String result = ans.substring(index);

        if(result.length() == 0){
            return "0";
        }else{
            return result;
        }
    }
}