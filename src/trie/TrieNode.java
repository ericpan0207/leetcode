import java.util.*;

public class TrieNode {
    private char c;
    private Map<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
}
