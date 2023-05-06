public class BinaryTree {

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
    Node root;

    BinaryTree()
    {
        root = null;
    }

    public void add( int value, String path) {

        if (root == null)
            root = new Node(300);
        Node temp = root;
        for (int i = 0; i < path.length(); i++)
        {
            if (path.charAt(i) == '0') {
                if (root.left == null) {
                    root.left = new Node(300);
                }
                root = root.left;
            }
            else {
                if (root.right == null) {
                    root.right = new Node(300);
                }
                root = root.right;
            }
        }
        root.value = value;
        root = temp;
    }

    public void traverseInOrder(Node node, int level) {
        if (node != null) {
            traverseInOrder(node.left, level + 1);
            for (int i = 0; i < level; i++)
                System.out.print("   ");
            System.out.println(node.value);
            traverseInOrder(node.right, level + 1);
        }
    }
}
