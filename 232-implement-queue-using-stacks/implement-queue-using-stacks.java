class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        //step 1 : shift all elements of st1 to st2
        while(!st1.isEmpty()){
            int topElement = st1.peek();
            st1.pop();
            st2.push(topElement);
        }

        //step 2 : insert element in st1
        st1.push(x);

        //step 3 : shift all elements from st2 to st1;
         while(!st2.isEmpty()){
            int topElement = st2.peek();
            st2.pop();
            st1.push(topElement);
         }
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */