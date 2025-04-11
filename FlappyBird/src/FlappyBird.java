import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int frameWidth = 360;
    int frameHeight = 640;

    // image attributes
    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    // player
    int playerStartPosX = frameWidth / 8;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;
    Player player;

    // pipe attributes
    int pipeStartPosX = frameWidth;
    int pipeStartPosY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;
    ArrayList<Pipe> pipes;

    Timer gameLoop;
    Timer pipesCooldown;

    int gravity = 1;

    // score dan game over
    boolean gameOver = false;
    int score = 0;
    JLabel scoreLabel;

    // constructor
    public FlappyBird() {
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setFocusable(true);
        addKeyListener(this);

        // load images
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();

        // JLabel untuk score
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setForeground(Color.WHITE);
        this.setLayout(null);
        scoreLabel.setBounds(10, 10, 200, 40);
        this.add(scoreLabel);

        pipesCooldown = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(("pipa"));
                placePipes();
            }
        });
        pipesCooldown.start();
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null);
        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);

        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }

        if (gameOver == true) {
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.setColor(Color.RED);
            g.drawString("Game Over", 60, frameHeight / 2 - 20);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Press R to Restart", 80, frameHeight / 2 + 20);
        }
    }

    public void move() {
        if (gameOver == false) {
            player.setVelocityY(player.getVelocityY() + gravity);
            player.setPosY(player.getPosY() + player.getVelocityY());
            if (player.getPosY() < 0) {
                player.setPosY(0);
            }

            ArrayList<Pipe> pipesToRemove = new ArrayList<>();

            for (int i = 0; i < pipes.size(); i++) {
                Pipe pipe = pipes.get(i);
                pipe.setPosX(pipe.getPosX() + pipe.getVelocityX());

                // pengecekan skor
                if (pipe.isPassed() == false && pipe.getPosX() + pipe.getWidth() < player.getPosX() && i % 2 == 0){
                    pipe.setPassed(true);
                    score++;
                    scoreLabel.setText("Score: " + score);
                }

                // untuk cari tabrakan dengan pipa
                Rectangle playerRect = new Rectangle(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight());
                Rectangle pipeRect = new Rectangle(pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight());

                if (playerRect.intersects(pipeRect)) {
                    gameOver = true;
                }

                if (pipe.getPosX() + pipe.getWidth() < 0) {
                    pipesToRemove.add(pipe);
                }
            }

            for (int i = 0; i < pipesToRemove.size(); i++) {
                pipes.remove(pipesToRemove.get(i));
            }

            // game over jika jatuh ke bawah
            if (player.getPosY() + player.getHeight() > frameHeight) {
                gameOver = true;
            }
        }
    }

    public void placePipes(){
        int randomPosY = (int) (pipeStartPosY - pipeHeight/4 - Math.random() * (pipeHeight/2));
        int openingSpace = frameHeight/4;

        Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidth, pipeHeight, upperPipeImage);
        pipes.add(upperPipe);

        Pipe lowerPipe = new Pipe(pipeStartPosX, (randomPosY + openingSpace + pipeHeight), pipeWidth, pipeHeight, lowerPipeImage);
        pipes.add(lowerPipe);
    }

    public void restartGame() {
        gameOver = false;
        score = 0;
        scoreLabel.setText("Score: 0");
        player.setPosY(playerStartPosY);
        player.setVelocityY(0);
        pipes.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver == false) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                player.setVelocityY(-10);
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                restartGame();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e){}
}
