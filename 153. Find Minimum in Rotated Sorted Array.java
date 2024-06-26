class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.min(nums[0],nums[1]);
        
        int last = nums[nums.length-1];
        if(nums[0] < last) return nums[0];
        if(last < nums[0] && last < nums[nums.length-2]) return last;
        // check if nums.length < 3 before checks
        
        // left = 0, right = nums.length-1
        // while left <= right
        // int mid = (left+right)/2
        // if nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1], return nums[mid]
        // if nums[mid] > nums[left], left = mid+1
        // else right = mid-1
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            // System.out.println(nums[mid]+" "+nums[right]);

            if(nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]) return nums[mid];
            if(nums[left] < nums[right]) return nums[left];

            if(nums[mid] >= nums[left]) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}