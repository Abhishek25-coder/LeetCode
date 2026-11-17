class RecentCounter {
Deque<Integer> q;
    public RecentCounter() {
        q = new ArrayDeque<>();
    }
    public int ping(int t) {
     //step 1 : request ko q me dalo
     q.offer(t);

     //step 2 : invalid request ko remove kro
     while(!q.isEmpty() && q.peek() < t-3000){
        q.poll();
     }   
     //ab sari request valid bachi h
      return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */