public class Program {
    public static void main(String[] args){

        //System.out.println("who is gay?");
        //System.out.println("Hello world");

        BinaryTree tree = new BinaryTree();

        //97 100
        //98 101
        //99 11
        //100 0

        tree.add(97, "100", 0);
        //tree.add(98, "101", 0);
        //tree.add(99, "11", 0);
        //tree.add(100, "0", 0);

        tree.traverseInOrder(tree.root, 0);
    }
}
