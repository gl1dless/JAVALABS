package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class Snake extends JFrame {

    private final JLabel scoreLabel = new JLabel("Score: 0");
    private final JLabel lengthLabel = new JLabel("Length: 3");

    private final JButton startButton = new JButton("Start");
    private final JButton pauseButton = new JButton("Pause");
    private final JButton restartButton = new JButton("Restart");

    public Snake() {
        super("SNAKE THE GAME");

        GameSettings s = GameSettings.getInstance();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(
                s.fieldWidth * s.cellSize + 20,
                s.fieldHeight * s.cellSize + 90
        );
        setLocationRelativeTo(null);

        GamePanel panel = new GamePanel(scoreLabel, lengthLabel);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(scoreLabel);
        top.add(lengthLabel);

        JPanel bottom = new JPanel();
        bottom.add(startButton);
        bottom.add(pauseButton);
        bottom.add(restartButton);

        startButton.addActionListener(e -> panel.start());
        pauseButton.addActionListener(e -> panel.pause());
        restartButton.addActionListener(e -> panel.restart());

        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    static class GamePanel extends JPanel
            implements ActionListener, KeyListener {

        private final GameSettings s = GameSettings.getInstance();

        private final LinkedList<Point> snake = new LinkedList<>();
        private Point food;

        private int dx = 1, dy = 0;
        private int score = 0;

        private final Timer timer = new Timer(s.delay, this);
        private final Random rnd = new Random();

        private final JLabel scoreLabel;
        private final JLabel lengthLabel;

        public GamePanel(JLabel scoreLabel, JLabel lengthLabel) {
            this.scoreLabel = scoreLabel;
            this.lengthLabel = lengthLabel;

            setFocusable(true);
            addKeyListener(this);

            restart();
        }

        public void restart() {
            timer.stop();

            snake.clear();
            snake.add(new Point(5, 5));
            snake.add(new Point(4, 5));
            snake.add(new Point(3, 5));

            dx = 1;
            dy = 0;
            score = 0;

            spawnFood();
            updateLabels();
            repaint();
        }

        private void spawnFood() {
            food = new Point(
                    rnd.nextInt(s.fieldWidth),
                    rnd.nextInt(s.fieldHeight)
            );
        }

        public void start() {
            timer.start();
            requestFocusInWindow();
        }

        public void pause() {
            timer.stop();
        }

        private void updateLabels() {
            scoreLabel.setText("Score: " + score);
            lengthLabel.setText("Length: " + snake.size());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.RED);
            g.fillRect(
                    food.x * s.cellSize,
                    food.y * s.cellSize,
                    s.cellSize,
                    s.cellSize
            );

            g.setColor(Color.GREEN);
            for (Point p : snake) {
                g.fillRect(
                        p.x * s.cellSize,
                        p.y * s.cellSize,
                        s.cellSize,
                        s.cellSize
                );
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Point head = snake.getFirst();
            Point newHead = new Point(head.x + dx, head.y + dy);

            if (newHead.x < 0 || newHead.y < 0 ||
                    newHead.x >= s.fieldWidth ||
                    newHead.y >= s.fieldHeight) {
                timer.stop();
                return;
            }

            if (snake.contains(newHead)) {
                timer.stop();
                return;
            }

            snake.addFirst(newHead);

            if (newHead.equals(food)) {
                score += 10;
                spawnFood();
            } else {
                snake.removeLast();
            }

            updateLabels();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> {
                    if (dy != 1) { dx = 0; dy = -1; }
                }
                case KeyEvent.VK_DOWN -> {
                    if (dy != -1) { dx = 0; dy = 1; }
                }
                case KeyEvent.VK_LEFT -> {
                    if (dx != 1) { dx = -1; dy = 0; }
                }
                case KeyEvent.VK_RIGHT -> {
                    if (dx != -1) { dx = 1; dy = 0; }
                }
            }
        }

        @Override public void keyReleased(KeyEvent e) {}
        @Override public void keyTyped(KeyEvent e) {}
    }
}