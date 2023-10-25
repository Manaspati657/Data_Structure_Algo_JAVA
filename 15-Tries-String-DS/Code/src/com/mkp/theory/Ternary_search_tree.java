package src.com.mkp.theory;

public class Ternary_search_tree {

//    every node has three child node middle(middle is for equal character) ,
//    left(is for less than middle) and right (is for greater than middle).

    private Node root;

    public void put(String s){
        root=put(root,s,0);
    }

    private Node put(Node node, String s, int d) {
        char c=s.charAt(d);
        if(node ==null) node =new Node(c);
        if(c > node.value) node.right=put(node.right,s,d);
        else if(c < node.value ) node.left=put(node.left,s,d);
        else if(d < s.length()-1) node.middle=put(node.middle,s,d+1);
        else node.isWord=true;
        return node;
    }

    public boolean search(String s){
        return search(root,s,0);
    }

    private boolean search(Node node, String s, int d) {
        if(node == null) return false;
        char ch=s.charAt(d);
        if(ch > node.value) return search(node.right,s,d);
        else if(ch < node.value) return search(node.left,s,d);
        else if(d == s.length()-1 && node.isWord) return true;
        else if(d > s.length()-1) return false;

        return search(node.middle,s,d+1);
    }


    private class Node{
        boolean isWord;
        char value;
        Node left,middle,right;

        public Node(char v) {
            this.value=v;
        }
    }

}
