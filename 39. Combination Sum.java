class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList(), candidates,target,0);
        // backtrack with candidates,target,0
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> curr, int[] candidates, int target, int sum){
        // save candidates.length as n

        // loop from 0 to n-1
        // check if curr.size()-1 < candidates[i], return


        // add candidates[i] to sum and to curr
        // if sum == target, add curr to list, remove val from curr, and return
        // if candidates[i] + sum > target, remove and return
        // else backtrack with everything

        int n = candidates.length;
        for(int i=0;i<n;i++){
            int m = curr.size(), val = candidates[i];
            if(m > 0 && curr.get(m-1) < val) return;

            sum += val;
            curr.add(val);

            if(sum >= target){
                if(sum == target) list.add(new ArrayList(curr));
                curr.remove(curr.size()-1);
                return;
            }

            // System.out.println(curr);
            backtrack(list,curr,candidates,target,sum);
            
            sum -= val;
            curr.remove(curr.size()-1);
        }
    }
}