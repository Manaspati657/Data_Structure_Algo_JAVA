package src.com.mkp.v1.theory;

public class MainTest {
    public static void main(String[] args) {
//        Unordered Priority Queue.
/*        UnorderedMaxPQ<Integer> pq=new UnorderedMaxPQ<>();
        pq.insert(2);
        pq.insert(5);
        pq.insert(6);
        pq.insert(8);
        pq.insert(9);
        pq.insert(10);
        pq.insert(3);
        pq.insert(1);
        System.out.println(pq);
        System.out.println(pq.getMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq);*/

        BinaryHeapMaxPQ<Integer> pq=new BinaryHeapMaxPQ<>();
        pq.insert(45);
        pq.insert(20);
        pq.insert(14);
        pq.insert(12);
        pq.insert(19);
        pq.insert(31);
        pq.insert(7);
        pq.insert(11);
        pq.insert(13);
        System.out.println(pq);
        System.out.println("Get max "+pq.getMax());
        pq.sort();
        System.out.println(pq);
        pq.convertMaxPQ();
        System.out.println(pq);
//        System.out.println(pq.deleteMax());
//        System.out.println(pq);
//        System.out.println(pq.deleteMax());
//        System.out.println(pq);
//        System.out.println(pq.deleteMax());
//        System.out.println(pq);
//        System.out.println(pq.deleteMax());
//        System.out.println(pq);
//        System.out.println(pq.deleteMax());
//        System.out.println(pq);
//        System.out.println(pq.deleteMax());
//        System.out.println(pq);
//        System.out.println(pq.deleteMax());
//        System.out.println(pq);

    }
}
