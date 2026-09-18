class Solution {
    static void solve(int[] candidates,int target,int index, List<List<Integer>> ans, List<Integer> output){
        //base case
        if(target==0){
            //target 0 ka mtlb mere output wali list me ek answer bn gya h
            //store this ans into ans wali list
            ans.add(new ArrayList(output));
            return;
        }
        if(index>=candidates.length){
            return;
        }
        if(target<0){
            return;
        }
        //include exclude pattern

        //include
        //index aage badhega duplicate values neglect krne ke liye
        output.add(candidates[index]);
        solve(candidates,target-candidates[index],index+1,ans,output);
        
        //backtrack
        output.remove(output.size()-1);

        //to generate unique combination
        while(index+1  < candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }

        //exclude
        solve(candidates,target,index+1,ans,output);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(candidates,target,index,ans,output);
        return ans;
    }
}