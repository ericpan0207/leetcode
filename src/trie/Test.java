import java.util.*;

public class Test {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("hello");
        t.insert("help");
        t.insert("halo");
        t.insert("test");
        t.view(t.root, 0);
    }
}
