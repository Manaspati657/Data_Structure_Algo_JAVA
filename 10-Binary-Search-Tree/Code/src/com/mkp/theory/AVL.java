package src.com.mkp.theory;

class AVL<Key extends Comparable<Key>>{
    private Node root;
    public AVL() {
    }
    public AVL(Key[] arr) {
        insertArray(arr);
    }
    private void insertArray(Key[] arr) {
        for (Key e:arr){
            insert(e);
        }
    }
    public void insert(Key key) {
        this.root=insert(root,key);
    }

    public Integer height(){
        return height(root);
    }
    private int height(Node node) {
        if(node == null) return -1;
        return node.height;
    }

    public Integer count(){
        return count(root);
    }
    private int count(Node node) {
        if(node==null) return 0;
        return node.count;
    }

    private Node rotateRight(Node node){
        Node temp=node.left;
        Node t2=temp.right;

        temp.right=node;
        node.left=t2;

        setHeightNdCount(node);
        setHeightNdCount(temp);

        return temp;
    }

    private Node rotateLeft(Node node){
        Node temp=node.right;
        Node t2=temp.left;

        temp.left=node;
        node.right=t2;

        setHeightNdCount(node);
        setHeightNdCount(temp);

        return temp;
    }

    private Node insert(Node node, Key key) {
        if(node == null) return new Node(key);
        int comp=key.compareTo(node.key);
        if(comp > 0) node.right=insert(node.right,key);
        else if(comp < 0) node.left=insert(node.left,key);
        setHeightNdCount(node);
//        this checkIsBalanced used key for child node comparison
        return checkIsBalanced(node,key);
//        this checkIsBalanced don't use anything for child node comparison
//        return checkIsBalanced(node);
    }

    private Node checkIsBalanced(Node node) {
        //        if the height difference greater than then the new node is added on the left side.
//        left case L :
        if((height(node.left) - height(node.right)) > 1){
//            check for LL case or LR case

//            if node left side weight is high then the case is LL
//            case LL :
            if(height(node.left) >= 0){
                node=rotateRight(node);
            }

//            if node left side weight is less than 0 then node.left.right weight is high in
//            that condition case is LR
//            case LR :  => L + RR of node.left => LL => right rotate current node
            else if(height(node.left) < 0){
                node.left=rotateLeft(node.left);
                node=rotateRight(node);
            }

        }

//        if the height difference less than -1 then the new node is added on the right side.
//        Right case R :
        if((height(node.left) - height(node.right)) < -1){
//            check for RR case or RL case

//            if node right side weight is less than equal 0  then the case is RR.
//            case RR :
            if(height(node.right) <= 0 ){
                node=rotateLeft(node);
            }

//            if node right side weight is greater than 0, then the node.right.left weight is
//            high so the case is RL.
//            case RL :  => R + LL of node.right => RR => Left rotate current node
            else if(height(node.right) > 0){
                node.right=rotateRight(node.right);
                node=rotateLeft(node);
            }
        }

        return node;

    }

    private Node checkIsBalanced(Node node,Key key) {
//        if the height difference greater than then the new node is added on the left side.
//        left case L :
        if((height(node.left) - height(node.right)) > 1){
//            check for LL case or LR case
            int comp=key.compareTo(node.left.key);

//            if new node is less than node.left then that node added on the left side.
//            case LL :
            if(comp < 0){
                node=rotateRight(node);
            }

//            if new node is greater than node.left then that node added on the right side.
//            case LR :  => L + RR of node.left => LL => right rotate current node
            else if(comp > 0){
                node.left=rotateLeft(node.left);
                node=rotateRight(node);
            }

        }

//        if the height difference less than -1 then the new node is added on the right side.
//        Right case R :
        if((height(node.left) - height(node.right)) < -1){
//            check for RR case or RL case
            int comp=key.compareTo(node.right.key);

//            if new node is greater than node.right then that node added on the right side.
//            case RR :
            if(comp > 0){
                node=rotateLeft(node);
            }

//            if new node is less than node.right then that node added on the left side.
//            case RL :  => R + LL of node.right => RR => Left rotate current node
            else if(comp < 0){
                node.right=rotateRight(node.right);
                node=rotateLeft(node);
            }
        }

        return node;

    }

    private void setHeightNdCount(Node node) {
        node.height=1+Math.max(height(node.left),height(node.right));
//        node.height = Math.max(height(node.left), height(node.right) + 1);
        node.count=1+count(node.left)+count(node.right);
    }

    public void display(){
        preOrder(root,"root node: ");
    }

    private void preOrder(Node node,String msg) {
        if(node == null) return;
        System.out.println(msg+node.key+" height: "+node.height+" count: "+node.count);
        preOrder(node.left,node.key+" left node is : ");
        preOrder(node.right,node.key+" right node is : ");
    }

    public Boolean isBalanced(){
        return isBalanced(root);
    }

    private Boolean isBalanced(Node node) {
        if(node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right) ;
    }

    public void deleteMin() {
        root=deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if(node.left == null) return node.right;
        node.left=deleteMin(node.left);
        setHeightNdCount(node);
        return node;
    }

    public void delete(Key key) {
        root=delete(root,key);
    }

    private Node delete(Node node, Key key) {
        if(node == null ) return node;
        int comp=key.compareTo(node.key);
        if(comp < 0) node.left=delete(node.left,key);
        else if(comp > 0) node.right=delete(node.right,key);
        else{
            if(node.left == null ) return node.right;
            else if(node.right == null) return node.left;

            Node temp=node;
            node=min(temp.right);
            node.right=deleteMin(temp.right);
            node.left=temp.left;
            setHeightNdCount(node);
        }
        return checkIsBalanced(node);
    }

    private Node min(Node temp){
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    private class Node{
        Key key;
        Node left,right;
        Integer count;
        Integer height;
        public Node(Key key) {
            this.key = key;
            this.height=0;
            this.count=1;
        }
    }

}
