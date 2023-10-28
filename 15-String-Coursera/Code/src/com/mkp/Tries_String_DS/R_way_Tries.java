package src.com.mkp.Tries_String_DS;

public class R_way_Tries {

//    R- R is either All ascii value or any range of ascii value.

/*
*    Time complexity for put: O(L) - L is length of the string;
*                        Search: O(log R of L )
*    Space complexity : (R+L)N ( in space complexity it gives worst case because it has so many of null entry).
*
* */


//    private static final int R=26;
    private static final int R=256;  // 256 for all ASCII character.
    private Node root;

    public void put(String s){
       root= put(root,s,0);
    }

    private Node put(Node node, String s, int d) {
        if(node == null) node=new Node();
        if(d==s.length()) {
            node.isWord=true;
            return node;
        }
        // if we take only a to z then we have to subtract from a so that it will add between 0 and 25
//        int ch=s.charAt(d)-'a';
        int ch=s.charAt(d);
        node.children[ch]=put(node.children[ch],s,d+1);

        return node;
    }
    
    private boolean isEmptyChildren(Node node){

        for (int i = 0; i < R; i++) {
            if(node.children[i] != null) return false;
        }
        
        return true;
    }

    public boolean search(String s){
        return search(root,s,0);
    }

    private boolean search(Node node, String s,int d) {
        if(node == null) return false;
        if(node.isWord && d == s.length()) return true;
        if(d >= s.length()) return false;
        return search(node.children[s.charAt(d)],s,d+1);
    }

    public void remove(String s){
        root=remove(root,s,0);
    }

    private Node remove(Node node, String s, int d) {
        if(node == null) return null ;
        if(d == s.length()){
            if(node.isWord) node.isWord=false;
            if(isEmptyChildren(node)){
                node=null;
            }
            return node;
        }
        node.children[s.charAt(d)]= remove(node.children[s.charAt(d)],s,d+1);

        if(isEmptyChildren(node) && !root.isWord) node = null;
        return node;
    }

    private static class Node{
         boolean isWord;
         Node[] children;

        public Node() {
            children=new Node[R];
            isWord=false;
        }
    }
}
