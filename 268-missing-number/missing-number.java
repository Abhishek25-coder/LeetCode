class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n* (n+1)/2;
        
        int newsum=0;
        for(int j=0;j<nums.length;j++){
            newsum+=nums[j];
        }return sum-newsum;
    }
}