import java.awt.*;
import javax.swing.*;

public class BinaryTreeGUI extends JPanel {

    private BinaryTree.Node root;
    private int nodeSize = 30;// rozmiar węzła
    private int gap = 50;// odstęp między węzłami

    public BinaryTreeGUI(BinaryTree.Node root) { // konstruktor klasy BinaryTreeGUI
        this.root = root;
        setPreferredSize(new Dimension(800, 600));// Ustaw  preferowany rozmiar panelu
        setBackground(Color.GRAY); // ustaw kolor
    }

    @Override
    public void paintComponent(Graphics g) {// Metod do rysowania ||| Graphics g - obiekt udostępniający metody rysowania
        super.paintComponent(g); // line wywołuje oryginalną implementację metody w klasie JPanel w celu wyczyszczenia panelu i przygotowania go do przemalowania.
        if (root != null) {
            drawNode(g, root, getWidth() / 2, 50, getWidth() / 4);// rysuj korzeń drzewa na środku panelu
        }
    }

    private void drawNode(Graphics g, BinaryTree.Node node, int x, int y, int dx) {
        if(node.value == 300) {// ustaw kolor wypełnienia węzła
            g.setColor(Color.GREEN);
        }
        else {
            g.setColor(Color.CYAN);
        }
        g.fillOval(x - nodeSize / 2, y - nodeSize / 2, nodeSize, nodeSize);// narysuj koło jako węzeł
        g.setColor(Color.RED);// ustaw kolor obwódki węzła
        g.drawOval(x - nodeSize / 2, y - nodeSize / 2, nodeSize, nodeSize);// narysuj obwódkę koło jako węzła
        g.setColor(Color.BLACK);// ustaw
        Font font = new Font("Arial", Font.BOLD, 12); // określij ustawienia tekstu
        g.setFont(font);
        if(node.value != 300)
            g.drawString(Integer.toString(node.value), x - nodeSize / 4, y + nodeSize / 4);// wypisz wartość węzła w środku kółka

        if (node.left != null) {// jeśli istnieje lewy węzeł, narysuj go
            int xLeft = x - dx;// oblicz pozycję lewego węzła
            int yLeft = y + gap;
            g.setColor(Color.RED);// ustaw kolor linii
            g.drawLine(x, y, xLeft, yLeft);// narysuj linię łączącą obecny węzeł z lewym węzłem
            drawNode(g, node.left, xLeft, yLeft, dx / 2);// kontynuuj rysowanie dla lewego węzła
        }

        if (node.right != null) {// jeśli istnieje prawy węzeł, narysuj go
            int xRight = x + dx;// oblicz pozycję prawego węzła
            int yRight = y + gap;
            g.setColor(Color.RED);// ustaw kolor linii
            g.drawLine(x, y, xRight, yRight);// narysuj linię łączącą obecny węzeł z prawym węzłem
            drawNode(g, node.right, xRight, yRight, dx / 2);// kontynuuj rysowanie dla prawego węzła
        }
    }
}