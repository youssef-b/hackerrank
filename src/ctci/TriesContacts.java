package ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-contacts
 */
public class TriesContacts {

    static class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        int numberOfLeafChildren=0;

        public TrieNode() {}

        public TrieNode(char c){
            this.c = c;
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String contact) {
            Map<Character, TrieNode> children = root.children;

            for(char c : contact.toCharArray()){
                TrieNode t;
                if(children.containsKey(c)){
                    t = children.get(c);
                }else{
                    t = new TrieNode(c);
                    children.put(c, t);
                }
                t.numberOfLeafChildren++;
                children = t.children;
            }
        }

        public int searchPartial(String partial){
            Map<Character, TrieNode> children = root.children;
            TrieNode t = null;
            for(int i=0; i< partial.length(); i++){
                char c = partial.charAt(i);
                t = children.get(c);
                if (t==null)
                    return 0;
                children = t.children;
            }
            return t != null ? t.numberOfLeafChildren : 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie trie = new Trie();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if("add".equalsIgnoreCase(op))
                trie.insert(contact);
            else if ("find".equalsIgnoreCase(op))
                System.out.println(trie.searchPartial(contact));
        }

    }
}
