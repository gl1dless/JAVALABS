package ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends JFrame {

    public Ball() {
        super("ball going bigger then smaller and moving");

        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new BallPanel());

        setVisible(true);
    }

    static class BallPanel extends JPanel implements ActionListener {

        private double x = 50;
        private double y = 200;

        private final double vx = 2.0;

        private double r = 10;
        private double vr = 0.6;

        private final double rMin = 10;
        private final double rMax = 80;

        private final Timer timer = new Timer(20, this); // ~50 кадров/сек

        public BallPanel() {
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int rr = (int) r;
            int cx = (int) x;
            int cy = (int) y;

            g.setColor(Color.PINK);
            g.drawOval(cx - rr, cy - rr, rr * 2, rr * 2);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            x += vx;

            if (x > getWidth() + rMax) {
                x = -rMax;
            }

            r += vr;

            if (r >= rMax) {
                r = rMax;
                vr = -vr;
            }

            if (r <= rMin) {
                r = rMin;
                vr = -vr;
            }

            repaint();
        }
    }
}