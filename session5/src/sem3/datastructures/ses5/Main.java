package sem3.datastructures.ses5;

public class Main {

    public static void main(String[] args)
    {
        // Generate tree manually
        BSTNode<Integer, Integer> root = new BSTNode<>(40,40);
        root.setLeft(new BSTNode<>(25,25));
        root.left().setLeft(new BSTNode<>(10,10));
        root.left().setRight(new BSTNode<>(32,32));
        root.setRight(new BSTNode<>(78,78));

        // Traversal methods
        root.preOrder(true);
        root.inOrder(true);
        root.postOrder(true);

        System.out.println("---------------------");

        // Generate tree from input
        int[] oInts = GenerateInput.GenerateOrderedNumbers(10);
        BSTNode<Integer, Integer> oRoot = new BSTNode<>(oInts[0], oInts[0]);
        for(int i = 1 ; i < oInts.length; i++)
            oRoot.insert(oInts[i]);

        System.out.println(oRoot.height());

        int[] rInts = GenerateInput.GenerateRandomNumbers(10);
        BSTNode<Integer, Integer> rRoot = new BSTNode<>(rInts[0], rInts[0]);
        for(int i = 1 ; i < rInts.length; i++)
            rRoot.insert(rInts[i]);

        System.out.println(rRoot.height());

        System.out.println("---------------------");
        root.levelOrder();

    }
}
