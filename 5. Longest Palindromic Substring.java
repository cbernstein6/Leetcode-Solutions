class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        // two possible ways to expand per letter
        // single bridging out both sides,
        // double of i,i+1 expanding out

        String max = "";
        // loop through each letter, check for single and double
        for(int i=0;i<s.length()-1;i++){
            String curr = bridge(s,i,i);
            String curr2 = bridge(s,i,i+1);

            // System.out.println(curr);
            // System.out.println(curr2);
            // System.out.println("\n");

            max = curr.length() > max.length() ? curr : max;
            max = curr2.length() > max.length() ? curr2 : max;
        }
        return max;

        // left and right index, while they are in the len of str, check if they are the same and go back.
        
    }
    public String bridge(String s, int left, int right){
        
        if(left != right && s.charAt(left) != s.charAt(right)) return "";

        StringBuilder str = new StringBuilder();

        if(left == right){
            str.append(s.charAt(left));
            left--;
            right++;
        }

        while(left > -1 && right < s.length() && s.charAt(left) == s.charAt(right) && left != right){
            str.insert(0,s.charAt(left));
            str.append(s.charAt(right));

            left--;
            right++;
        }

        // System.out.println(str.toString());
        return str.toString();
    }
}