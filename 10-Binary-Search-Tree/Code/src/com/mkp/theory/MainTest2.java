package src.com.mkp.theory;

public class MainTest2 {
    public static void main(String[] args) {
//       BST all operation is clog(N)

/*//        BST<Integer,String> bst=new BST<>();
//        bst.insert(15,"manas");
//        bst.insert(7,"abc");
//        bst.insert(3,"xyz");
//        bst.insert(11,"mno");
//        bst.insert(8,"ysd");
//        bst.insert(13,"urg");
//        bst.insert(20,"pqr");
//        bst.insert(1,"tuv");
//        bst.insert(17,"def");
//        System.out.println(bst.getValue(3));
//        System.out.println("Floor : "+bst.getFloor(4));
//        System.out.println("Ceil : "+bst.getCeil(4));
//        System.out.println("smallest key : "+bst.min());
//        System.out.println("largest key : "+bst.max());
//        System.out.println("size : "+bst.size());
//        System.out.println(bst.getAllKeys());
//        bst.delete(7);
//        System.out.println(bst.getAllKeys());
//        System.out.println("length : "+bst.size());
//        bst.deleteMin();
//        bst.deleteMin();
        BST<Integer,String> bst=new BST<>();
        bst.insert(15,"manas");
        bst.insert(9,"abc");
        bst.insert(12,"xyz");
        bst.insert(11,"mno");
        bst.insert(13,"tuv");
        System.out.println("size: "+bst.size());
        System.out.println("Floor : "+bst.getFloor(10));
        System.out.println("Ceil : "+bst.getCeil(10));

        System.out.println("is Balanced: "+bst.isBalanced()); //false
        bst.display();
        BST<Integer,String> bst1=new BST<>();
        bst1.insert(15,"manas");
        bst1.insert(16,"abc");
        bst1.insert(17,"xyz");
        bst1.insert(18,"xyz");
        bst1.insert(19,"xyz");
        bst1.insert(20,"xyz");
        bst1.insert(21,"xyz");
        System.out.println("size: "+bst.size());
        System.out.println("is Balanced: "+bst.isBalanced()); //false
        bst.display();*/

//       Red black bst - Self balanced in any case it will perform all the curd operation in O(logn) time .
//        Red_Black_BST<Integer,String> bst=new Red_Black_BST<>();
//        bst.insert(15,"manas");
//        bst.insert(9,"abc");
//        bst.insert(12,"xyz");
//        bst.insert(13,"mno");
//        bst.insert(11,"utg");
//        System.out.println("size: "+bst.size());
//        System.out.println("is Balanced: "+bst.isBalanced()); //true
//        bst.display();
//        System.out.println("key value: "+bst.getValue(13));
//        System.out.println("Floor : "+bst.getFloor(10));
//        System.out.println("Ceil : "+bst.getCeil(10));
//        System.out.println("smallest key : "+bst.min());
//        System.out.println("largest key : "+bst.max());
//        System.out.println("size : "+bst.size());
//        System.out.println(bst.getAllKeys());
//        bst.deleteMin();
//        bst.delete(7);
//        System.out.println(bst.getAllKeys());
//        System.out.println("length : "+bst.size());


//        Red_Black_BST<Integer,String> bst1=new Red_Black_BST<>();
//        bst1.insert(15,"manas");
//        bst1.insert(16,"abc");
//        bst1.insert(17,"xyz");
//        bst1.insert(18,"xyz");
//        bst1.insert(19,"xyz");
//        bst1.insert(20,"xyz");
//        bst1.insert(21,"xyz");
//        System.out.println("size: "+bst.size());
//        System.out.println("is Balanced: "+bst.isBalanced()); //true
//        bst.display();

        Red_Black_BST<Integer,String> bst=new Red_Black_BST<>();
        for (int i = 1; i <=100; i++) {
            bst.insert(i,"xyz");
        }
        System.out.println("size: "+bst.size());
        System.out.println("Height: "+bst.height());
        System.out.println("is Balanced: "+bst.isBalanced());
//        bst.display();


//        AVL tree = new AVL();
//
//        for(int i=0; i < 100; i++) {
//            tree.insert(i);
//        }
//
//        System.out.println(tree.height());
//        tree.display();
    }
}
