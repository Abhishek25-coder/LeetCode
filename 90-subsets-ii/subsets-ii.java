class Solution {
     static void solve(int[] nums, int index,  List<Integer> output, List<List<Integer>> ans){
        //base case
        if(index>=nums.length){
            //subsequence ready
            //is subsequence ko store krna h ans me
            ans.add(new ArrayList<>(output));
            return;
        }
        //include exclude pattern
        int currvalue = nums[index];
        //include
        output.add(currvalue);
        solve(nums,index+1,output, ans);
        //backtracking step
        output.remove(output.size()-1);

        //while excluding, ignore the next same element and move to new element
        while(index+1<nums.length && nums[index] == nums[index+1]){
            index++;
        }
        //exclude
        solve(nums,index+1,output,ans); 
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(nums,index,output,ans);
        return ans;
    }
} 