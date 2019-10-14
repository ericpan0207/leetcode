import java.util.*;

public class TrieNode {
    private char c;
    // Can save on space by using a list instead: TrieNode[128]
    private Map<Character, TrieNode> children;
    private boolean isEndOfWord;

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
        isEndOfWord = isEnd;
    }

    public boolean isEndOfWord() {
        return this.isEndOfWord;
    }
}
