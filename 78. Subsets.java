class Solution {
    // with arraylist instead of set
    public List<List<Integer>> subsets(int[] nums) {
        // instantiate set<list> and curr,
        // instantiate boolean[]
        // start max at 1, while it is <= nums.length,
        // backtrack(list,new ArrayList<>(), nums, nums.length, used, max)
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        

        boolean[] used = new boolean[nums.length];

        int max = 1;
        while(max <= nums.length){
            backtrack(list,new ArrayList<>(), used, nums, nums.length, max, 0);
            max++;
        }
        list.add(Arrays.asList());
        return new ArrayList<>(list);
    }

    public void backtrack(List<List<Integer>> list, List<Integer> curr, boolean[] used, int[] nums, int n, int max, int start){
        if(curr.size() == max){
            // Collections.sort(sortedCurr);
            list.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<n;i++){
            if(used[i] || (curr.size() > 0 && curr.get(curr.size()-1) > nums[i])) continue;

            curr.add(nums[i]);
            used[i] = true;
            backtrack(list,curr,used, nums, n, max, start+1);

            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
    // backtrack:
    // if curr.size() == max, sort curr and add to list and return,
    // loop through 0 to n,

    // if(used[i]) continue

    // add this val to curr, 
    // used[i] = true

    // backtrack(list,curr,nums,n,used,max)
    // remove val from curr, used[i] = false
}