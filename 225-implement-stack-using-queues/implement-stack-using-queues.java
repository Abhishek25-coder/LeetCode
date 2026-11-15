class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        //step 1 : add elements in q2
        q2.offer(x);
        
        //step 2 : shift all elements from q1 to q2
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        //step 3 : swap elements of q2,q1
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
       return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */