class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Initialize a hashmap where the key is a character count array and the value is a list of strings
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for (String s : strs) {
            // Create a character count array of size 26
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }
            
            // Convert the character count array to a string key
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append('#');
                keyBuilder.append(count);
            }
            String key = keyBuilder.toString();
            
            // Append the string to the corresponding list in the hashmap
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(s);
        }
        
        // Return the grouped anagrams
        return new ArrayList<>(anagrams.values());
    }
}