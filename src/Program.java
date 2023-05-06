import javax.swing.*;

public class Program {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();// Tworzenie instancji drzewa binarnego

        tree.add(97, "100");
        tree.add(98, "101");
        tree.add(99, "11");
        tree.add(100, "0");

        // Tworzymy panel z drzewem binarnym, korzystając z węzła root jako korzenia
        BinaryTreeGUI treePanel = new BinaryTreeGUI(tree.root);

        // Tworzymy JScrollPane, aby móc dodać pasek przewijania do panelu z drzewem
        JScrollPane scrollPane = new JScrollPane(treePanel);

        // Tworzenie i konfigurowanie okna JFrame
        JFrame frame = new JFrame("Binary Tree");           // utwórz nowe okno z tytułem "Drzewo binarne"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // ustal akcję zamknięcia okna po kliknięciu przycisku "X"
        frame.getContentPane().add(scrollPane);                // dodaj panel drzewa binarnego wewnątrz panelu przewijania do kontenera okna
        frame.pack();                                         // dopasuj rozmiar okna do rozmiaru jego zawartości
        frame.setLocationRelativeTo(null);                   // umieść okno na środku ekranu
        frame.setVisible(true);                             // pokaż okno i ustaw je jako widoczne


        tree.traverseInOrder(tree.root, 0);
    }
}
