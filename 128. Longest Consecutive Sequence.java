class Solution {//CHATGPT IMPROVEMENT
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (!map.containsKey(n)) {
                int leftLen = map.getOrDefault(n - 1, 0);
                int rightLen = map.getOrDefault(n + 1, 0);
                int len = 1 + leftLen + rightLen;

                max = Math.max(max, len);

                // Update the boundaries
                map.put(n, len);
                if (leftLen > 0) {
                    map.put(n - leftLen, len);
                }
                if (rightLen > 0) {
                    map.put(n + rightLen, len);
                }
            }
        }

        return max;
    }
}
