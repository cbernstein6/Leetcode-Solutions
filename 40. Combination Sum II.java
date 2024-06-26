class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // initialize biglist and list
        // sort candidates
        // if target < candidates[0], return biglist

        // helper(biglist,list,0,candidates,0,target)
        Set<List<Integer>> bigList = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        if(target < candidates[0]) return new ArrayList<>(bigList);

        helper(bigList,list,0,candidates,0,target);
        return new ArrayList<>(bigList);
    }

    public void helper(Set<List<Integer>> bigList, List<Integer> list, int score, int[] candidates, int start, int target){
        // if start == candidates.lengt, return

        // if score == target, add list copy to biglist, return

        // for(int i=start;i<candidates.length;i++)
        // int curr = candidates[i];
        // if(score + curr > target) return
        // score += candidates[i];
        // list.add(curr)

        // helper(biglist,list,score,candidates,start+1,target)
        // score -= candidates[i]
        // list.remove(list.size()-1)

        if(score == target){
            bigList.add(new ArrayList<>(list));
            return;
        }
        if(score > target || start == candidates.length) return;

        for(int i=start;i<candidates.length;i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            int curr = candidates[i];
            if(score + curr > target) return;
            score += curr;
            list.add(curr);

            helper(bigList,list,score,candidates,i+1,target);
            score -= candidates[i];
            list.remove(list.size()-1);
        }
    }
}