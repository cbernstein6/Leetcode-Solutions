class Solution {
    public int maxArea(int[] height) {
        int max = 0, left=0, right = height.length-1;
        while(left < right){
            int minTop = Math.min(height[left],height[right]);
            max = Math.max(max,minTop * (right-left));

            if(height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}