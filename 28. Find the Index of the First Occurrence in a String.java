class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == needle.length()) return haystack.equals(needle) ? 0 : -1;
        
        int left = 0, right = needle.length();

        while(left + needle.length() < haystack.length() + 1){
            String sub = haystack.substring(left,left + needle.length());
            // System.out.println(sub);
            if(sub.equals(needle)) return left;
            left++;
        }
        return -1;
    }
}