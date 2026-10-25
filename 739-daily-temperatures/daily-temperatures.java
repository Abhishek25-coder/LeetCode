class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int previousDay = st.pop();
                ans[previousDay] = i - previousDay;
            }
            st.push(i);
        }
        return ans;
        //using iteration
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(temperatures[j] > temperatures[i]){
        //             int days = j-i;
        //             ans[i] = days;
        //             break; 
        //         }
        //     }
        // }
        // return ans;
    }
}