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
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //2D array ko 1D array me convert krunga
        int[] height = new int[cols];

        int maxArea = -1;

        //ab rows ko base ka tarah treat krunga
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    //height[i][j] = '0';
                    height[j] = 0;
                }
            }
            //after each row addition,feed to largest area wala function and maxarea ko update kro
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}