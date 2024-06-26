class Solution {
    public int searchInsert(int[] nums, int target) {
        // binary search
        // if mid == target or mid < target and mid+1 > target

        // return nums.length

        int left=0,right=nums.length-1;

        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target && (mid+1 == nums.length || nums[mid+1] > target)) return mid+1;

            if(nums[mid] < target) left = mid+1;
            else right=mid-1;
        }
        return target < nums[0] ? 0 : nums.length;
    }
}