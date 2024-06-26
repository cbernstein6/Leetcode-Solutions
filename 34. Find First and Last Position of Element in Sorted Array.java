class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];

        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            // System.out.println(nums[mid]);
            if(nums[mid] == target){
                arr[0] = binRange(nums,left,mid,target);
                // System.out.println(binRange(nums,left,mid,target)+"  "+binRangeRight(nums,mid,right,target));
                arr[1] = binRangeRight(nums,mid,right,target);
                return arr;
            }

            if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }

        return new int[]{-1,-1};
        
        // while left <= right
        // mid = left+right / 2
        // if mid == target,
        //  arr[0] = binRange(nums,left,mid,target)
        //  arr[1] = binRange(nums,mid,right,target)

        // else if nums[mid] < target, left = mid+1
        // else right = mid-1
    }

    public int binRange(int[] nums, int left, int right, int target){
        if(nums[left] == target) return left;
        while(left <= right){
            // mid = left+right / 2
            // if nums[mid] == target and nums[mid-1] != target, return mid
            // else if nums[mid] == target, right = mid-1
            // else, left = mid+1

            int mid = (left+right) / 2;
            if(nums[mid] == target && nums[mid-1] != target) return mid;
            else if(nums[mid] == target) right = mid-1;
            else left = mid+1;
        }

        return -1;
    }
    public int binRangeRight(int[] nums, int left, int right, int target){
        if(nums[right] == target) return right;
        while(left <= right){
            // mid = left+right / 2
            // if nums[mid] == target and nums[mid-1] != target, return mid
            // else if nums[mid] == target, right = mid-1
            // else, left = mid+1

            int mid = (left+right) / 2;
            if(nums[mid] == target && nums[mid+1] != target) return mid;
            else if(nums[mid] == target) left = mid+1;
            else right = mid-1;
        }

        return -1;
    }
}