package chapter17;

/**
 *
 * @author Jacob Stewart, 11/19/2020, Simple gui calculator, CIT-130
 */
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class SimpleCalculator extends JFrame implements ActionListener {

    public static final int WIDTH = 350;
    public static final int HEIGHT = 400;

    private JTextField output;
    private int firstNum;
    private int secondNum;

    public static void main(String[] args) {
        SimpleCalculator aCalc = new SimpleCalculator();
        aCalc.setVisible(true);
    }

    public SimpleCalculator() {
        setTitle("Simple Calculator: Jacob Stewart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBackground(Color.LIGHT_GRAY);
        add(outputPanel, BorderLayout.CENTER);

        output = new JTextField(30);
        output.setEditable(false);
        output.setBackground(Color.LIGHT_GRAY);
        outputPanel.add(output, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        buttonPanel.setPreferredSize(new Dimension(WIDTH, 300));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        add(buttonPanel, BorderLayout.SOUTH);

        JButton one = new JButton("1");
        one.addActionListener(this);
        buttonPanel.add(one);

        JButton two = new JButton("2");
        two.addActionListener(this);
        buttonPanel.add(two);

        JButton three = new JButton("3");
        three.addActionListener(this);
        buttonPanel.add(three);

        JButton divide = new JButton("/");
        divide.addActionListener(this);
        buttonPanel.add(divide);

        JButton four = new JButton("4");
        four.addActionListener(this);
        buttonPanel.add(four);

        JButton five = new JButton("5");
        five.addActionListener(this);
        buttonPanel.add(five);

        JButton six = new JButton("6");
        six.addActionListener(this);
        buttonPanel.add(six);

        JButton multiply = new JButton("*");
        multiply.addActionListener(this);
        buttonPanel.add(multiply);

        JButton seven = new JButton("7");
        seven.addActionListener(this);
        buttonPanel.add(seven);

        JButton eight = new JButton("8");
        eight.addActionListener(this);
        buttonPanel.add(eight);

        JButton nine = new JButton("9");
        nine.addActionListener(this);
        buttonPanel.add(nine);

        JButton minus = new JButton("-");
        minus.addActionListener(this);
        buttonPanel.add(minus);

        JButton clear = new JButton("C");
        clear.addActionListener(this);
        buttonPanel.add(clear);

        JButton zero = new JButton("0");
        zero.addActionListener(this);
        buttonPanel.add(zero);

        JButton equals = new JButton("=");
        equals.addActionListener(this);
        buttonPanel.add(equals);

        JButton plus = new JButton("+");
        plus.addActionListener(this);
        buttonPanel.add(plus);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            correctFormat(e);
        } catch (NumberFormatException e2) {
            output.setText("Error: Can only use two operands - Hit clear to "
                    + "continue");
        }
    }

    public void correctFormat(ActionEvent e) {
        String aC = e.getActionCommand();

        if (aC.equals("1") || aC.equals("2") || aC.equals("3") || aC.equals("4")
                || aC.equals("5") || aC.equals("6") || aC.equals("7")
                || aC.equals("8") || aC.equals("9") || aC.equals("0")) {

            output.setText(output.getText() + aC);

        } else if (aC.equals("/") || aC.equals("*") || aC.equals("-")
                || aC.equals("+")) {

            String outText = output.getText();
            String first = outText;
            firstNum = stringToInt(first);
            output.setText(outText + " " + aC + " ");

        } else if (aC.equals("=")) {

            String outText = output.getText();
            String second = "";

            if (outText.contains("/")) {
                second = outText.substring((outText.indexOf("/") + 2));
                secondNum = stringToInt(second);
                Integer result = firstNum / secondNum;
                output.setText(result.toString());
            } else if (outText.contains("*")) {
                second = outText.substring((outText.indexOf("*") + 2));
                secondNum = stringToInt(second);
                Integer result = firstNum * secondNum;
                output.setText(result.toString());
            } else if (outText.contains("-")) {
                second = outText.substring((outText.indexOf("-") + 2));
                secondNum = stringToInt(second);
                Integer result = firstNum - secondNum;
                output.setText(result.toString());
            } else if (outText.contains("+")) {
                second = outText.substring((outText.indexOf("+") + 2));
                secondNum = stringToInt(second);
                Integer result = firstNum + secondNum;
                output.setText(result.toString());
            }
        } else if (aC.equals("C")) {
            output.setText("");
            firstNum = 0;
            secondNum = 0;
        }
    }

    private static int stringToInt(String stringObject) {
        return Integer.parseInt(stringObject.trim());
    }
}
