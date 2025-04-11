import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class StartForm extends JFrame {
    public StartForm() {
        setTitle("Flappy Bird - Start");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // panel utama dengan latar belakang
        JPanel panel = new JPanel() {
            Image bg = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        // label judul
        JLabel titleLabel = new JLabel("FLAPPY BIRD");
        titleLabel.setFont(new Font("Futura Md BT", Font.BOLD, 38));
        titleLabel.setForeground(new Color(255, 215, 0));
        titleLabel.setBounds(30, 100, 300, 60);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // shadow effect untuk judul
        JLabel shadowLabel = new JLabel("FLAPPY BIRD");
        shadowLabel.setFont(new Font("Futura Md BT", Font.BOLD, 38));
        shadowLabel.setForeground(new Color(0, 0, 0, 180));
        shadowLabel.setBounds(33, 103, 300, 60);
        shadowLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(shadowLabel);
        panel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Press Start to Play!");
        subtitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setBounds(30, 170, 300, 30);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleLabel);

        // tombol mulai
        JButton startButton = new JButton("START GAME") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(255, 200, 0),
                        0, getHeight(), new Color(255, 140, 0)
                );

                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                g2.setColor(new Color(255, 255, 255, 100));
                g2.fillRoundRect(0, 0, getWidth(), getHeight()/2, 20, 20);

                g2.dispose();

                super.paintComponent(g);
            }
        };

        startButton.setFont(new Font("Arial", Font.BOLD, 22));
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(80, 400, 200, 60);
        startButton.setBorder(new EmptyBorder(5, 15, 5, 15));
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // tutup Start Menu
                launchGame(); // buka Game
            }
        });

        panel.add(startButton);
        setContentPane(panel);
    }

    private void launchGame() {
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 640);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        flappyBird.requestFocus();
        frame.setVisible(true);
    }
}