class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();

        int left = 0, best = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }
            lastSeen.put(c, i);

            best = Math.max(best, i-left+1);
        }

        return best;
    }
}
