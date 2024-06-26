class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;

        int i=s.length()-1;
        while(i > -1){
            char c = s.charAt(i);
            if(Character.isLetter(c)) count++;
            else if(count > 0) return count;

            i--;

        }
        return count;
    }
}