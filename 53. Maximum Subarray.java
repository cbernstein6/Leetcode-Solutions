class Solution {
    public int maxSubArray(int[] nums) {
        // loop through nums while i < n

        // curr = max of curr + nums[i], nums[i]
        // max = max of max and curr

        int max = Integer.MIN_VALUE, curr = 0;
        int i=0, n = nums.length;

        while(i < n){
            curr = Math.max(curr+nums[i],nums[i]);
            max = Math.max(max,curr);
            i++;
        }
        return max;
    }
}