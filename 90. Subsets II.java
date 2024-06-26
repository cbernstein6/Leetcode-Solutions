class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // set of list integers
        // boolean arr for used
        // helper(list,new arraylist, nums, used, 0)
        // return new arraylist<>(set)
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<>());
        helper(set, new ArrayList<>(), nums, 0);
        return new ArrayList<>(set);
    }

    public void helper(Set<List<Integer>> set, List<Integer> curr, int[] nums, int start){
        if(start == nums.length) return;

        // loop through from start to nums.length-1,
        // if(!used) add to curr and used[i] = true
        // backtrack with start+1

        for(int i=start;i<nums.length;i++){
            if(curr.size() == 0 || nums[i] >= curr.get(curr.size()-1)){
                curr.add(nums[i]);

                set.add(new ArrayList(curr));

                helper(set,curr,nums,start+1);
                curr.remove(curr.size()-1);
            }
        }
    }
}