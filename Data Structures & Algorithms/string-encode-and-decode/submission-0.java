class Solution {

    char seperator = '€';
    public String encode(List<String> strs) {
        String coded = "";
        for (int i=0; i < strs.size(); i++) {
            coded += strs.get(i) + seperator;
        } 
        return coded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int start = 0;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == seperator) {
                String character = str.substring(start, i);
                start = i + 1;
                decoded.add(character);
            }
            i++;
        }
        return decoded;
    }
}