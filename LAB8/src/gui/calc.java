package gui;

import javax.swing.*;
import java.awt.*;

public class calc extends JFrame {

    private final JTextField xField = new JTextField("2", 5);
    private final JTextField yField = new JTextField("3", 5);
    private final JTextField nField = new JTextField("5", 5);
    private final JTextField rField = new JTextField("3", 5);

    private final JRadioButton rbSeries =
            new JRadioButton("Z = -1/1 + Y/2 - X^2/3 + Y^3/4 - ...", true);

    private final JRadioButton rbDoubleSum =
            new JRadioButton("Z = ∑∑ (j^2 + i) / (i^j + j)");

    private final JButton calcButton = new JButton("Считать");
    private final JLabel resultLabel = new JLabel("Результат: ");

    public calc() {
        super("calc diffrent formulas");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 260);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        // ----- inputs -----
        JPanel pInputs = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pInputs.add(new JLabel("X:"));
        pInputs.add(xField);
        pInputs.add(new JLabel("Y:"));
        pInputs.add(yField);
        pInputs.add(new JLabel("N:"));
        pInputs.add(nField);
        pInputs.add(new JLabel("R:"));
        pInputs.add(rField);

        // ----- radio buttons -----
        ButtonGroup group = new ButtonGroup();
        group.add(rbSeries);
        group.add(rbDoubleSum);

        JPanel pRadio = new JPanel();
        pRadio.setLayout(new BoxLayout(pRadio, BoxLayout.Y_AXIS));
        pRadio.add(rbSeries);
        pRadio.add(rbDoubleSum);

        // ----- button -----
        JPanel pBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pBtn.add(calcButton);

        // ----- result -----
        JPanel pRes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pRes.add(resultLabel);

        root.add(pInputs);
        root.add(pRadio);
        root.add(pBtn);
        root.add(pRes);

        setContentPane(root);

        calcButton.addActionListener(e -> calculate());
    }

    private void calculate() {
        double x, y;
        int n, r;

        try {
            x = Double.parseDouble(xField.getText().trim());
            y = Double.parseDouble(yField.getText().trim());
            n = Integer.parseInt(nField.getText().trim());
            r = Integer.parseInt(rField.getText().trim());
        } catch (Exception ex) {
            resultLabel.setText("Результат: ошибка ввода");
            return;
        }

        double z;
        if (rbSeries.isSelected()) {
            z = calcSeries(x, y, n);
        } else {
            z = calcDoubleSum(n, r);
        }

        resultLabel.setText("Результат: " + z);
    }

    //первая формула
    private double calcSeries(double x, double y, int n) {
        double z = 0.0;

        for (int k = 1; k <= n; k++) {
            double value;
            if (k % 2 == 0) {
                value = Math.pow(y, k - 1);
                z += value / k;
            } else {
                value = Math.pow(x, k - 1);
                z -= value / k;
            }
        }
        return z;
    }

    //вторая формула
    private double calcDoubleSum(int n, int r) {
        double z = 0.0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                z += (j * j + i) / (Math.pow(i, j) + j);
            }
        }
        return z;
    }
}