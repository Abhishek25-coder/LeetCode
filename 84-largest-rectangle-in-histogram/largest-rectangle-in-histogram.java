class Solution {
    public static void findprevsmallerindex(int heights[], int prev[]){
        Deque<Integer> st = new ArrayDeque<>();

        //next smaller value = right se left
        //prev smaller value = left se right
        for(int i =0; i<heights.length; i++){
            int currIndex = i;
            while(!st.isEmpty() && heights[st.peek()] >= heights[currIndex]){
                //useless element ko pop krdo
                st.pop();
            }
            if(st.isEmpty()){
                prev[i] = -1;
            }else{
                prev[i] = st.peek();
            }
            //push
            st.push(currIndex);
        }
    }
       public static void findnextsmallerindex(int heights[], int next[]){
        Deque<Integer> st = new ArrayDeque<>();
        int n = heights.length;
        //next smaller value = right se left
        //prev smaller value = left se right
        for(int i = heights.length-1; i>=0; i--){
            int currIndex = i;
            while(!st.isEmpty() && heights[st.peek()] >= heights[currIndex]){
                //useless element ko pop krdo
                st.pop();
            }
            if(st.isEmpty()){
                next[i] = n;
            }else{
                next[i] = st.peek();
            }
            //push
            st.push(currIndex);
        }
     }
    public int largestRectangleArea(int[] heights) {
        //these two store will store index
        int prev[] = new int[heights.length];
        int next[] = new int[heights.length];

        findprevsmallerindex(heights, prev);
        findnextsmallerindex(heights, next);

        int maxArea = -1;
        for(int i = 0;i<heights.length; i++){
            int height = heights[i];
            int width = next[i] - prev[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}