package src.com.mkp.theory;

public class Segment_Tree {

    private Node root;

    public Segment_Tree(int[] arr) {
        root = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int[] arr, int sI, int eI) {
        if(sI==eI){
//          leaf node created
            Node temp=new Node(sI,eI);
            temp.data=arr[sI];
            return temp;
        }

//        root node created
        Node node = new Node(sI,eI);
        int mid=sI+(eI-sI)/2;
        node.left=constructTree(arr,sI,mid);
        node.right=constructTree(arr,mid+1,eI);

        node.data=node.left.data+node.right.data;

        return node;

    }

    public int query(int s,int e){
        return query(root,s,e);
    }

    private int query(Node node, int s, int e) {
        if(node.sIndex >= s && node.eIndex <= e) return node.data;
        if(node.sIndex > e || node.eIndex < s) return 0;
        return query(node.left,s,e)+query(node.right,s,e);
    }

    public void updateIndexValue(int index, int value) {
        root=updateIndexValue(root,index,value);
    }

    private Node updateIndexValue(Node node, int index, int value) {
        if(node.sIndex == index && node.eIndex== index) {
            node.data=value;
            return node;
        }
        if(index < node.sIndex  || index > node.eIndex) return node;
        updateIndexValue(node.left,index,value);
        updateIndexValue(node.right,index,value);
        node.data=node.left.data+node.right.data;
        return node;
    }


    public void display(){
        inOrder(root,"root node is : ");
    }
    private void inOrder(Node node, String msg) {
        if(node == null) return;
        System.out.println(msg+node.data+" index : ["+node.sIndex+","+node.eIndex+"]");
        inOrder(node.left,node.data+" left node is : ");
        inOrder(node.right,node.data+" right node is : ");
    }



    private class Node{
        int data;
        int sIndex,eIndex;
        Node left,right;

        public Node(int sIndex, int eIndex) {
            this.sIndex = sIndex;
            this.eIndex = eIndex;
        }
    }
}
