package src.com.mkp.problems;

import src.com.mkp.theory.BST_2;

public class DFS {
    public static void main(String[] args) {

//        BST_2<Integer> tree=new BST_2<>(new Integer[]{5,3,2,4,8,6,9});
//        1: PreOrder traversal : N -> L -> R
//        tree.displayPreOrder();
//        System.out.println();
//        2: InOrder traversal : L -> N -> R
//        tree.displayInOrder();
//        System.out.println();
//        3: PostOrder traversal : L -> R -> N
//        tree.displayPostOrder();
//        System.out.println(tree.height());

//        https://leetcode.com/problems/diameter-of-binary-tree/description/
//        System.out.println(tree.diameterOfBinaryTree());

//        https://leetcode.com/problems/invert-binary-tree/
//          tree.display();
//          tree.invertTree();
//          System.out.println();
//          tree.display();

//        https://leetcode.com/problems/maximum-depth-of-binary-tree/
//        System.out.println(tree.maxDepth());

//        https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//        BST_2<Integer> tree=new BST_2<>();
//        tree.sortedArrayToBST(new Integer[]{-10,-3,0,5,9});
//        tree.display();

//        https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
          BST_2<Integer> tree=new BST_2<>(new Integer[]{5,3,2,4,8,6,9});
//          this methods take extra space for storing the nodes in sorting format and then create
//         the skew tree from the list
//          tree.flatten();
//          without using any extra space
//          tree.flatten2();
//        tree.displayPreOrder();

//        https://leetcode.com/problems/validate-binary-search-tree/description/
//        System.out.println(tree.isValidBST());

        //    https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//        System.out.println(tree.kthSmallest(9));

//        Path sum problems::

//        https://leetcode.com/problems/path-sum/
//        System.out.println(tree.hasPathSum(22));

//        https://leetcode.com/problems/sum-root-to-leaf-numbers/
        System.out.println(tree.sumAllPathNumbers());
    }
}






















