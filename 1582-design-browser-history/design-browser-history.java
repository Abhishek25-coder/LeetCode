class BrowserHistory {
    Deque<String> currHistory;
    Deque<String> forwardHistory;
    public BrowserHistory(String homepage) {
        currHistory = new ArrayDeque<>();
        forwardHistory = new ArrayDeque<>();
        //currHistory me sbse pehle homepage push krna h
        currHistory.push(homepage);
    }
    
    public void visit(String url) {
        //currhistory me url ko push krna h aur forward history empty krni h
        currHistory.push(url);
        while(!forwardHistory.isEmpty()){
            forwardHistory.pop();
        }
    }
    
    public String back(int steps) {
        //normal back krna h but homepage ko back nhi kr skte
        while(steps>0){
            if(currHistory.size() > 1){
                //back kr skte h
                String Backtab = currHistory.pop();
                forwardHistory.push(Backtab);
            }else{
                //back nhi kr skte
                break;
            }
            steps--;
        }
        return currHistory.peek();
    }
    
    public String forward(int steps) {
        while(steps > 0){
            if(forwardHistory.size() > 0){
                //forward kr skta hu
                String Forwardtab = forwardHistory.pop();
                currHistory.push(Forwardtab);
            }else{
                //forward nhi kr skta
                break;
            }
            steps--;
        }
        return currHistory.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */