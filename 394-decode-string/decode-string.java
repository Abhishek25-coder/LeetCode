class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        int number = 0;
        StringBuilder curr = new StringBuilder();

        for( char ch: s.toCharArray()){
            //Case 1
            if(Character.isDigit(ch)){
                number = number * 10 + (ch - '0'); 
            }else if(ch == '['){ //Case 2
                 countStack.push(number);
                 stringStack.push(curr);
                 //new values se wapas initialise krdo
                 number = 0;
                 curr = new StringBuilder();
            }else if(ch == ']'){ //Case 3
                int repeatCount = countStack.pop();
                StringBuilder prev = stringStack.pop();
                //ab hum prev me repeatcount times curr ko append krne wale h
                for(int i =1;i<=repeatCount;i++){
                    prev.append(curr);
                }
                //sbse important line
                curr = prev;
            }else{
                curr.append(ch); //Case 4
            }
        }
        return curr.toString();
    }
}