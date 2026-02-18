package lab1.GUIs;
import lab1.logic.affineCeaser;

import javax.swing.*;

public class affineCaesarGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Caesar Cipher");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Input:");
        inputLabel.setBounds(20, 20, 80, 25);
        frame.add(inputLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(100, 20, 250, 25);
        frame.add(inputField);

        JLabel aLabel = new JLabel("a:");
        aLabel.setBounds(20, 60, 80, 25);
        frame.add(aLabel);

        JTextField aField = new JTextField();
        aField.setBounds(100, 60, 250, 25);
        frame.add(aField);

        JLabel bLabel = new JLabel("b:");
        bLabel.setBounds(20, 90, 80, 25);
        frame.add(bLabel);

        JTextField bField = new JTextField();
        bField.setBounds(100, 90, 250, 25);
        frame.add(bField);

        JLabel outputLabel = new JLabel("Output:");
        outputLabel.setBounds(20, 180, 80, 25);
        frame.add(outputLabel);

        JTextField outputField = new JTextField();
        outputField.setBounds(100, 180, 250, 25);
        outputField.setEditable(false);
        frame.add(outputField);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(80, 120, 100, 30);
        frame.add(encryptButton);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(200, 120, 100, 30);
        frame.add(decryptButton);

        encryptButton.addActionListener(e -> {
            String text = inputField.getText();
            int a = Integer.parseInt(aField.getText());
            int b = Integer.parseInt(bField.getText());
            outputField.setText(affineCeaser.encrypt(text, a,b));
        });

        decryptButton.addActionListener(e -> {
            String text = inputField.getText();
            int a = Integer.parseInt(aField.getText());
            int b = Integer.parseInt(bField.getText());
            outputField.setText(affineCeaser.decrypt(text, a,b));
        });

        frame.setVisible(true);
    }
}
