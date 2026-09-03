class Solution {
    public int missingNumber(int[] nums) {
        int xorSum = 0;

        //xorSum with array elements
        for(int n: nums){
            xorSum = xorSum^n;
        }
        //xorSum with range elements
        int n = nums.length;
        for(int i =0;i<=n;i++){
            xorSum = xorSum^i;
        }
        return xorSum;
    }
}