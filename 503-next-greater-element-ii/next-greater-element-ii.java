class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        // Store indices in stack
        Deque<Integer> st = new ArrayDeque<>();
        // Traverse 2 times for circular array
        for(int i = 2 * n - 1; i >= 0; i--) {
            int currindex = i % n;
            // Remove useless elements
            while(!st.isEmpty() &&
                  nums[st.peek()] <= nums[currindex]) {
                st.pop();
            }
            // Find next greater element
            if(i < n && !st.isEmpty()) {
                result[currindex] = nums[st.peek()];
            }
            // Push current index
            st.push(currindex);
        }
        return result;
    }
}