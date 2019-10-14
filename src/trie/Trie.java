import java.util.Map;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // O(n)
    public void insert(String word) {
        Map<Character, TrieNode> children = root.getChildren();

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.getChildren();

            if (i == word.length() - 1) {
                t.setEndOfWord(true);
            }
        }
    }

    // O(n)
    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            current = current.getChildren().get(c);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord();
    }

    // Traverses down to check that word exists and then on
    // the way up, remove if not part of another word
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char c = word.charAt(index);
        TrieNode node = current.getChildren().get(c);

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(c);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public void view() {
        view(root, 0);
    }

    private void view(TrieNode node, int offset) {
        print(node, offset);
        for (TrieNode children : node.getChildren().values()) {
            view(children, offset + 2);
        }
    }

    private void print(TrieNode node, int offset) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < offset; i++) {
            s.append(" ");
        }
        s.append(String.valueOf(node.getChar()));
        System.out.println(s);
    }
}
