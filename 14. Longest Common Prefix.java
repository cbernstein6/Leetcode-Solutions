class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];

        for(int i=1;i<strs.length;i++){
            str = compare(str,strs[i]);
        }
        return str;

    }
    public String compare(String s1, String s2){
        StringBuilder str = new StringBuilder(s1);

        int i=0;
        while(i < Math.min(s1.length(),s2.length()) && s1.charAt(i) == s2.charAt(i)){
            i++;
        }
        str.delete(i,str.length());
        return str.toString();
    }
}