package src.com.mkp.v1.problems;

import src.com.mkp.v1.theory.AVL;

public class BFS {

//    Breadth First Search(BFS) is technique to iterate level wise on a tree

//    Level Order Traversal technique is defined as a method to traverse a Tree such that all nodes
//    present in the same level are traversed completely before traversing the next level.
    public static void main(String[] args) {
        AVL<Integer> tree = new AVL<>(new Integer[]{5,3,2,4,8,9,6});
//        tree.traverseBFS();
//        tree.display();

//        https://leetcode.com/problems/binary-tree-level-order-traversal/description/
//        System.out.println(tree.levelOrder());

//        https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
//        System.out.println(tree.levelOrderII());

//        https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//          System.out.println(tree.zigzagLevelOrder());

//        https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//          tree.iterateLevel();

//        https://leetcode.com/problems/binary-tree-right-side-view/
        System.out.println(tree.rightSideView());

//        AVL<Double> tree = new AVL<>(new Double[]{5.0, 3.0, 2.0, 4.0, 8.0, 9.0, 6.0});

//        https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
//        System.out.println(tree.averageOfLevels());

    }

}
