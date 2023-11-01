package src.com.mkp.theory;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoding {

    HashMap<Character,String> encoder=new HashMap<>();
    HashMap<String,Character> decoder=new HashMap<>();

    Node root;

    public HuffmanCoding(String str) {
        buildTree(str);
    }

    private void buildTree(String str) {
        HashMap<Character,Integer> freqHS=new HashMap<>();
        PriorityQueue<Node> pq=new PriorityQueue<>();

//      create frequency count of character in String and store it in Hashmap as
//      (key : value) pair like (a:2)
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(freqHS.containsKey(ch)){
                int prevFreq=freqHS.get(ch);
                freqHS.put(ch,prevFreq+1);
            }else{
                freqHS.put(ch,1);
            }
        }
//        System.out.println(freqHS);
        Set<Map.Entry<Character,Integer>> entrySet=freqHS.entrySet();
//      Iterate through the Hashmap store it in Priority queue.
        for (Map.Entry<Character,Integer> entry:entrySet) {
            pq.add(new Node(entry.getKey(),entry.getValue()));
        }

//      Build Tree : get the min freq two char and create a node and store it in pq
//                   until it has only one root node in pq.
        while(pq.size() != 1){
            Node min1=pq.remove();
            Node min2=pq.remove();
            Node newNode=new Node('-',min1.frequency+min2.frequency);
            newNode.left=min1;
            newNode.right=min2;
            pq.add(newNode);
        }

        root=pq.remove();
        this.initEncoderDecoder(root,"");
        System.out.println(encoder);
        System.out.println(decoder);
    }

    private void initEncoderDecoder(Node node,String str) {
        if(node == null) return;
        if(node.left == null && node.right == null){
            this.encoder.put(node.ch,str);
            this.decoder.put(str,node.ch);
        }
        initEncoderDecoder(node.left,str+"0");
        initEncoderDecoder(node.right,str+"1");
    }

    public String genEncoder(String str) {
        StringBuilder encode= new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            encode.append(encoder.get(str.charAt(i)));
        }
//        System.out.println(encoder);
        return encode.toString();
    }

    public String genDecoder(String str) {
        StringBuilder decode=new StringBuilder();
        StringBuilder key=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            key.append(str.charAt(i));
            if(decoder.containsKey(key.toString())){
                decode.append(decoder.get(key.toString()));
                key=new StringBuilder();
            }
        }
        return decode.toString();
    }


    private class Node implements Comparable<Node>{

        Character ch;
        int frequency;
        Node left,right;

        public Node(Character ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
            this.left=null;
            this.right=null;
        }

        @Override
        public int compareTo(Node that) {
            return this.frequency-that.frequency;
        }
    }
}
