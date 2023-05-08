import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.*;

public class Program {

    public static void main(String[] args){

        System.out.println("Choose test (1-4) : ");
        String path = new String();
        char test_number;
        try {
            int x = System.in.read();
            path = "test" +  (char)(x);
        } catch (IOException e)  {
            System.out.println("Error reading from user");
        }

        BinaryTree tree = new BinaryTree();
        try {
            File codes = new File(path + "/map.txt");
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

        short[] text = new short[1000000];
        int n = 0;
        File file = new File(path + "/compressed.bin");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            byte[] bytesArray = new byte[(int) file.length()];
            fis.read(bytesArray);

            for (byte b : bytesArray) {
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
            tree.root = temp;
            output.close();

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }


        BinaryTreeGUI treePanel = new BinaryTreeGUI(tree.root);
        JScrollPane scrollPane = new JScrollPane(treePanel);

        JFrame frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}