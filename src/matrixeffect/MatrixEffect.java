package matrixeffect;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MatrixEffect extends JPanel {

    // Fügt eine serialVersionUID hinzu, um die Warnung zu beseitigen
    private static final long serialVersionUID = 1L;

    private char[] zeichen;
    private int[] yPosition;
    private Random random = new Random();

    public MatrixEffect() {
        zeichen = "ABC💕😘❤️ϖͶὮ₼⃀₯↪↺⇅⇏▤▨◌◉◒⁵⁷³⁹⅖⅜⅘⅕∃∀ⅨⅤ∑ↅ∷≇≢⋚DEFGHIJK௹૱₳₤ℳ₠ʤĤĦŊŒʨLMNOPQRSTUVWXYZ0123456789!@#$%^&﷼€№№℗©‱⁂⁜*()".toCharArray();
        yPosition = new int[100]; // Anzahl der "Spalten" oder "Bahnen"
        for (int i = 0; i < yPosition.length; i++) {
            yPosition[i] = random.nextInt(600) - 600; // Initialisiert die Position der Zeichen zufällig
        }

        Timer timer = new Timer(55, e -> repaint());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.GREEN);
        //g.setColor(Color.PINK);
        for (int i = 0; i < yPosition.length; i++) {
            char ch = zeichen[random.nextInt(zeichen.length)];
            g.drawString(Character.toString(ch), i * 30, yPosition[i]);

            yPosition[i] += 25;  // Geschwindigkeit der Zeichen

            if (yPosition[i] > getHeight()) {
                yPosition[i] = -random.nextInt(600);  // Wiederholung der Zeichen von oben
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Matrix Effect");
            MatrixEffect matrixEffect = new MatrixEffect();
            frame.add(matrixEffect);
            frame.setSize(1400,1050);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
