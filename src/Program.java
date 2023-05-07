import java.io.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Program {
    public static void main(String[] args){
        //first step -> reading Huffman's Tree

        BinaryTree tree = new BinaryTree();
        try {
            File codes = new File("map.txt");
            Scanner in = new Scanner(codes);
            while (in.hasNext()) {
                String temp = in.next();
                String code = in.next();
                int x = Integer.parseInt(temp.substring(0, temp.length() - 1));
                tree.add(x, code);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        tree.traverseInOrder(tree.root, 0);
        // second step -> reading compression file and turning it into binary form
        short[] text = new short[1000000];
        int n = 0;
        File file = new File("compressed.bin");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            byte[] bytesArray = new byte[(int) file.length()];
            fis.read(bytesArray);

            for (int i = 0; i < bytesArray.length; i++) {
                byte b = bytesArray[i];
                for (int j = 7; j >= 0; j--) {
                    int bit = (b >> j) & 1;
                    text[n++] = (short) ('0' + bit);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try
        {
            FileOutputStream output = new FileOutputStream("output.bmp");

            BinaryTree.Node temp = tree.root;

            for (int i = 0; i < n; i++)
            {
                if (text[i] == '1')
                    tree.root = tree.root.right;
                else tree.root = tree.root.left;

                if (tree.root.value != 300)
                {
                    output.write((tree.root.value));
                    tree.root = temp;
                }
            }
            output.close();

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }


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

    }
}