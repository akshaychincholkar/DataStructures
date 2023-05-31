package com.game.ds.trie;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

// Java implementation of search and insert operations
// on Trie
public class Trie{
    public static void main(String[] args) {
        root.insert("the");
        root.insert("there");
        root.insert("their");
        root.insert("them");
        root.insert("akshay");

        System.out.println("akshay :"+root.search("akshay"));
        System.out.println("aksh prefix :"+root.prefix("aksh"));
    }
    static final int SIZE = 26;
    static TrieNode root = new TrieNode();
    static class TrieNode{
        TrieNode[] trie = new TrieNode[SIZE];
        boolean isEndOfWord;
        TrieNode(){
            trie = new TrieNode[SIZE];
            isEndOfWord = false;
            Arrays.fill(trie,null);
        }
        public void insert(String s){
            TrieNode ptr = root;
            // suppose want to insert: the
            for(int i = 0 ;i<s.length();i++){
                char c = s.charAt(i);
                int index = c - 'a';
                if(ptr.trie[c-'a']==null) ptr.trie[index] = new TrieNode();
                ptr = ptr.trie[index];
            }
            ptr.isEndOfWord = true;
        }
        public boolean search(String key){
            TrieNode pCrawler = root;
            for(int i = 0 ;i<key.length();i++){
                int c = key.charAt(i);
                int index = c-'a';
                if(pCrawler.trie[index]== null)return false;
                pCrawler = pCrawler.trie[index];
            }
            return pCrawler.isEndOfWord;
        }
        public boolean prefix(String key){
            TrieNode pCrawler = root;
            for(int i = 0 ;i<key.length();i++){
                int c = key.charAt(i);
                int index = c-'a';
                if(pCrawler.trie[index]== null)return false;
                pCrawler = pCrawler.trie[index];
            }
            return true;
        }
    }
}

























/*
public class Trie {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl.isEndOfWord);
    }

    // Driver
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
// This code is contributed by Sumit Ghosh

*/
