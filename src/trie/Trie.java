import java.util.Map;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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

    public void view(TrieNode node, int offset) {
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
