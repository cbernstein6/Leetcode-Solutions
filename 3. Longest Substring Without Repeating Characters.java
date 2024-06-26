class Solution {
    public int lengthOfLongestSubstring(String s) {
        // initiate max val and curr

        // loop through s
        // minimum index we can consider is i-curr
        // if map contains key, index has to be >= i-curr
        // if substring is already in map, make curr = i-map.get(substring)
        // else curr++
        // map.put(char,index)
        // max = max(max,curr)


        int max=0,curr=0;
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= i-curr) curr = i-map.get(c);
            // else curr++;
            map.put(c,i);
            max = Math.max(max,curr);
        }

        return max;
    }
}