class PrefixTree {
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }


    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();     
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children.containsKey(c)) 
                current = current.children.get(c);
            else {
                TrieNode child = new TrieNode();
                current.children.put(c, child);
                current = child;
            }
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children.containsKey(c)) 
                current = current.children.get(c);
            else 
                return false;
        }
        if (current.isEndOfWord) return true;
        else return false;
        
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.children.containsKey(c)) 
                current = current.children.get(c);
            else 
                return false;
        }
        return true;
    }
}
