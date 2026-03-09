import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArithmeticApp extends JFrame implements ActionListener {
    JTextField txtNum1, txtNum2, txtResult;
    JButton btnAdd, btnSub, btnMul, btnDiv;

    public ArithmeticApp() {
        setTitle("Calculator");
        setSize(250, 450); // Slightly narrower window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // GridBagLayout allows buttons to keep their natural width
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing around elements
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Number 1
        add(new JLabel("Number 1:"), gbc);
        txtNum1 = new JTextField(10);
        add(txtNum1, gbc);

        // Number 2
        add(new JLabel("Number 2:"), gbc);
        txtNum2 = new JTextField(10);
        add(txtNum2, gbc);

        // Buttons - Resetting fill to NONE keeps them at their natural text width
        gbc.fill = GridBagConstraints.NONE; 
        
        btnAdd = createButton("Add (+)");
        btnSub = createButton("Subtract (-)");
        btnMul = createButton("Multiply (*)");
        btnDiv = createButton("Divide (Whole)");

        add(btnAdd, gbc);
        add(btnSub, gbc);
        add(btnMul, gbc);
        add(btnDiv, gbc);

        // Result
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("Result:"), gbc);
        txtResult = new JTextField(10);
        txtResult.setEditable(false);
        add(txtResult, gbc);

        setVisible(true);
    }

    // Helper method to set a specific size for all buttons
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(120, 30)); // Manually set reduced width
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(txtNum1.getText());
            double n2 = Double.parseDouble(txtNum2.getText());
            
            if (e.getSource() == btnAdd) txtResult.setText(String.valueOf(n1 + n2));
            else if (e.getSource() == btnSub) txtResult.setText(String.valueOf(n1 - n2));
            else if (e.getSource() == btnMul) txtResult.setText(String.valueOf(n1 * n2));
            else if (e.getSource() == btnDiv) {
                if (n2 == 0) txtResult.setText("Error: Div by 0");
                else txtResult.setText(String.valueOf((int)(n1 / n2)));
            }
        } catch (NumberFormatException ex) {
            txtResult.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArithmeticApp());
    }
}
