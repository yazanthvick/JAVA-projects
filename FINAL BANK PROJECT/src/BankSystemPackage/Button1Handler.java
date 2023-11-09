package BankSystemPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1Handler implements ActionListener {
    JTextField input;

    public Button1Handler(JTextField input){
        this.input = input;
    }

    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, input.getText());
    }
}
