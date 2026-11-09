class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        List<Integer> res = new LinkedList<>();
        int n = nums.length;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}