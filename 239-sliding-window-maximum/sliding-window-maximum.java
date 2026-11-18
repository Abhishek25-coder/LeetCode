class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //store indexes in dq not values
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int ansIndex = 0;

        //process first k size window
        for(int i=0;i<k;i++){
            int element = nums[i];
        while(!dq.isEmpty() && nums[dq.peekLast()] < element){
            dq.pollLast();
        }
        //baki current element ke index ko insert krna hi h
        dq.offerLast(i);
    }
    //find ans for first window
    ans[ansIndex] = nums[dq.peekFirst()];
    ansIndex++;

    //baki k size windows ko process krna h
    for(int i=k;i<n;i++){
        //remove
        while(!dq.isEmpty() && dq.peekFirst() <= i-k){
            dq.pollFirst(); 
        }
        //addition
         while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
            dq.pollLast();
        }
        //baki current element ke index ko insert krna hi h
        dq.offerLast(i);

        //find ans
        ans[ansIndex] = nums[dq.peekFirst()];
        ansIndex++;
    }
    return ans;
}
}