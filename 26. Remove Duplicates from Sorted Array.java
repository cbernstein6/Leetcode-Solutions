class Solution {
    public int removeDuplicates(int[] nums) {
        // keep track of current index with 'index'
        // if i > 0 and i != nums[i-1] put val in nums[index], increment index
        // return index

        int index = 1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}