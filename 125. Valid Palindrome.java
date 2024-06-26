class Solution {
    public boolean isPalindrome(String s) {
        String split = s.replaceAll("[^a-zA-Z0-9]","");

        int left=0,right=split.length()-1;
        // System.out.println(split);
        split = split.toLowerCase();
        while(left < right){
            if(split.charAt(left) != split.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}