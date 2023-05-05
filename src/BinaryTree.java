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


    /*private Node addRecursive(Node current, int value, String path, int i) {
        if (current == null) {
            if (i == (path.length() - 1))
                return new Node(value);
            else return new Node(300);
        }

        System.out.print(path.charAt(i));
        if (path.charAt(i) == '0') {
            current.left = addRecursive(current.left, value, path, i + 1);
        } else if (path.charAt(i) == '1') {
            current.right = addRecursive(current.right, value, path, i + 1);
        }

        return current;
    }*/

    private Node addRecursive(Node current, int value, String path, int i) {
        if (current == null) {
            if (i == (path.length() - 1))
                return new Node(value);
            else return new Node(300);
        }

        for (int idx = 0; i < path.length(); i++)

        System.out.print(path.charAt(i));
        if (path.charAt(i) == '0') {
            current.left = addRecursive(current.left, value, path, i + 1);
        } else if (path.charAt(i) == '1') {
            current.right = addRecursive(current.right, value, path, i + 1);
        }

        return current;
    }

    public void add(int value, String path, int i)
    {
        root = addRecursive(root, value, path, i);
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
