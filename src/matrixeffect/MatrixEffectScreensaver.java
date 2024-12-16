package matrixeffect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MatrixEffectScreensaver extends JPanel {

    private static final long serialVersionUID = 1L;

    private char[] zeichen;
    private int[] yPosition;
    private Random random = new Random();

    // Anzahl der Zeichen pro Spalte
    private static final int ZEICHEN_PRO_SPALTE = 10;

    public MatrixEffectScreensaver() {
        zeichen = "ABC💕😘❤️ϖͶὮ₼⃀₯↪↺⇅⇏▤▨◌◉◒⁵⁷³⁹⅖⅜⅘⅕∃∀ⅨⅤ∑ↅ∷≇≢⋚DEFGHIJK௹૱₳₤ℳ₠ʤĤĦŊŒʨLMNOPQRSTUVWXYZ0123456789!@#$%^&﷼€№№℗©‱⁂⁜*()".toCharArray();
        yPosition = new int[80];
        for (int i = 0; i < yPosition.length; i++) {
            yPosition[i] = random.nextInt(600) - 600; // Initialisiere unterhalb der oberen Fensterkante
        }

        Timer timer = new Timer(40, e -> repaint());
        timer.start();
        
        // Beendet den Bildschirmschoner bei Mausbewegung oder Tastendruck
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.exit(0);
            }
        });
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.GREEN);

        for (int i = 0; i < yPosition.length; i++) {
            // Erzeugt mehrere Zeichen in einer Spalte
            for (int j = 0; j < ZEICHEN_PRO_SPALTE; j++) {
                // Zufälliges Zeichen
                char ch = zeichen[random.nextInt(zeichen.length)];
                
                // Zeichnet das Zeichen in der Spalte i und dem Offset j*Abstand
                g.drawString(Character.toString(ch), i * 45, yPosition[i] + j * 20);
            }

            yPosition[i] += 20;  // Geschwindigkeit der Zeichen

            // Wenn die Zeichen das Ende des Bildschirms erreicht haben, starten sie neu
            if (yPosition[i] > getHeight()) {
                yPosition[i] = -random.nextInt(600);  // Startet leicht oberhalb des Fensters
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setUndecorated(true);  // Entfernt Rand und Fensterdekoration
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Vollbildmodus
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MatrixEffectScreensaver matrixEffect = new MatrixEffectScreensaver();
            frame.add(matrixEffect);
            frame.setVisible(true);
        });
    }
}
