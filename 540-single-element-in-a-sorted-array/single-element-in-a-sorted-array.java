class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xorSum = 0;
        for(int n: nums){
            xorSum = xorSum^n;
        }
        return xorSum;
    }
}