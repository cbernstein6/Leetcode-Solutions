class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        // if array is sorted,
        // check if arr is not rotated as base case, and return last index if it isnt
        if(nums[0] < nums[nums.length-1]) return binary(nums,target,0,nums.length-1);

        int piv = pivot(nums,target);

        if(target >= nums[0]) return binary(nums,target,0,piv);
        
        return binary(nums,target,piv+1,nums.length-1);
    }

    public int binary(int[] nums, int target, int start, int end){
        int left=start,right = end;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target) return mid;
            if(target > nums[mid]) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }

    public int pivot(int[] nums, int target){
        // we have to look for val v such that nums[v+1] < v
        // binary search to that,
        
        // if nums[left] < nums[mid] left=mid+1
        // else if nums[right] > nums[mid] right = mid-1

        int left = 0, right = nums.length-1;

        while(left <= right){
            int mid = (left+right)/2;
            // System.out.println(mid);
            if(nums[mid] > nums[mid+1]) return mid;

            if(nums[left] <= nums[mid]) left=mid+1;
            else if(nums[right] > nums[mid]) right = mid-1;

            else{
                // System.out.println("HELP");
                return -1;
            }
        }
        return -1;
    }
}