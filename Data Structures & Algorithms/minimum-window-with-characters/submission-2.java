class Solution {

    public boolean isWindowValid(HashMap<Character, Integer> required, HashMap<Character, Integer> have) {
        for (Character c : required.keySet()) {
            if (have.getOrDefault(c, 0) < required.get(c)) {
                return false;
            }
        }
        return true;
    }

    public int getStartOfFirstInvalid(HashMap<Character, Integer> required, HashMap<Character, Integer> have, String s, int start) {
        while (isWindowValid(required, have)) {
            char d = s.charAt(start);
            have.put(d, have.get(d) - 1);
            start++;
        }
        return start;
    }

    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();

        HashMap<Character, Integer> required = new HashMap<>();

        for (Character c : t.toCharArray()) {
            if (required.containsKey(c)) required.put(c, required.get(c) + 1) ;
            else required.put(c, 1);
        }

        HashMap<Character, Integer> have = new HashMap<>();
        int start = 0, end = -1;
        String bestValid = "";
        
    

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            have.put(c, have.getOrDefault(c, 0) + 1);
            
            if (isWindowValid(required, have)) {
                int firstInvalid = getStartOfFirstInvalid(required, have, s, start);

                String shortest = s.substring(firstInvalid - 1, i + 1);

                if (bestValid.length() == 0 || shortest.length() < bestValid.length()) {
                    bestValid = shortest;
                }

                start = firstInvalid;
                
            }
        }

        return bestValid;
    }
}
