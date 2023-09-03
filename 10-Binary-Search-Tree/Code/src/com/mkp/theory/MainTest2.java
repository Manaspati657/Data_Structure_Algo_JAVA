package src.com.mkp.theory;

public class MainTest2 {
    public static void main(String[] args) {
        BST<Integer,String> bst=new BST<>();
        bst.insert(15,"manas");
        bst.insert(7,"abc");
        bst.insert(3,"xyz");
        bst.insert(8,"mno");
        bst.insert(20,"pqr");
        bst.insert(17,"def");
        System.out.println(bst.getValue(3));
        System.out.println("Floor : "+bst.getFloor(4));
        System.out.println("Ceil : "+bst.getCeil(4));
        System.out.println("length : "+bst.size());
        System.out.println(bst.getAllKeys());
        bst.deleteMin();
        bst.deleteMin();
        System.out.println(bst.getAllKeys());

    }
}
