package lab1.GUIs;
import lab1.logic.caesar;

import javax.swing.*;

public class CaesarGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Caesar Cipher");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Input:");
        inputLabel.setBounds(20, 20, 80, 25);
        frame.add(inputLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(100, 20, 250, 25);
        frame.add(inputField);

        JLabel keyLabel = new JLabel("Key:");
        keyLabel.setBounds(20, 60, 80, 25);
        frame.add(keyLabel);

        JTextField keyField = new JTextField();
        keyField.setBounds(100, 60, 250, 25);
        frame.add(keyField);

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
            int key = Integer.parseInt(keyField.getText());
            outputField.setText(caesar.encrypt(text, key));
        });

        decryptButton.addActionListener(e -> {
            String text = inputField.getText();
            int key = Integer.parseInt(keyField.getText());
            outputField.setText(caesar.decrypt(text, key));
        });

        JLabel attackLabel= new JLabel("cipher text");
        attackLabel.setBounds(20, 220, 80, 25);
        frame.add(attackLabel);

        JTextField inputAtt = new JTextField();
        inputAtt.setBounds(100, 220, 250, 25);
        frame.add(inputAtt);

        JButton attack = new JButton("attack");
        attack.setBounds(80, 250, 250, 30);
        frame.add(attack);

        JTextField plainText = new JTextField();
        plainText.setBounds(100, 280, 250, 25);
        plainText.setEditable(false);
        frame.add(plainText);

        attack.addActionListener(e -> {
            String text =  inputAtt.getText();
            plainText.setText(caesar.attack(text));
        });



        frame.setVisible(true);
    }
}
