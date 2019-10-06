import java.util.*;

public class TrieNode {
    private char c;
    private Map<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }

    public TrieNode(char c) {
        this();
        this.c = c;
    }

    public char getChar() {
        return c;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setEndOfWord(boolean isEnd) {
        isWord = isEnd;
    }
}
