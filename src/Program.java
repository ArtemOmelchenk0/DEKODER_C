public class Program {
    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();

        tree.add(97, "100");
        tree.add(98, "101");
        tree.add(99, "11");
        tree.add(100, "0");

        tree.traverseInOrder(tree.root, 0);
    }
}
