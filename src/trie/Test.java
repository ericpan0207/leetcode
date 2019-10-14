import java.util.*;

public class Test {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("hello");
        t.insert("help");
        t.insert("halo");
        t.insert("test");
        t.view();
        System.out.println(t.find("help"));
        System.out.println(t.find("rip"));
        t.delete("halo");
        t.view();
    }
}
