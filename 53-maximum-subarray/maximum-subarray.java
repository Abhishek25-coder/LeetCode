class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            //step 1 = find sum
            sum = sum+nums[i];
            //step 2 = maxi update krna h
            maxi = Math.max(maxi,sum);
            //step 3 = sum check for -ve numbers
            if(sum<0){
                sum = 0;
            }
        }
        return maxi;
    }
}