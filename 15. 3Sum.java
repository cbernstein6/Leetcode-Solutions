
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();

        for(int i=0;i<nums.length-2;i++){
            int num = nums[i], left = i+1, right = nums.length-1;
            if(num > 0 || (i > 0 && num == nums[i-1])) continue;
            while(left < right){
                int total = num + nums[left] + nums[right];
                if(total == 0){
                    list.add(Arrays.asList(num,nums[left],nums[right]));
                    left++;
                    right--;
                }
                else if(total < 0) left++;
                else right--;
            }
        }

        return new ArrayList(list);
    }
}