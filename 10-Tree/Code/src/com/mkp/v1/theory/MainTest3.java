package src.com.mkp.v1.theory;

public class MainTest3 {
    public static void main(String[] args) {
        int[] arr={5,9,2,8,-2,3,6,4};
        Segment_Tree tree=new Segment_Tree(arr);
//        tree.display();
        System.out.println(tree.query(3,5));//9
        System.out.println(tree.query(2,6));//17
        tree.updateIndexValue(3,7);
        tree.updateIndexValue(5,2);
        System.out.println(tree.query(4,5));//0

    }
}
