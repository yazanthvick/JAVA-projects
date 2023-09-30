package BANKSYSTEM;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI extends JFrame {
    Container container;
    public TestGUI(){
        container = this.getContentPane();
        JPanel panel = new JPanel();

        container.setLayout(new BorderLayout());
        panel.setLayout(null);

        JLabel label = new JLabel("TD Banking Login System");

        JLabel label1 = new JLabel("Username: ");
        JLabel label2 = new JLabel("Password: ");
        JTextField textField= new JTextField(40);
        JTextField textField2 = new JTextField(40);
        JButton button = new JButton("Sign In");


        container.add(label,BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);

        label1.setBounds(50,50,100,20);
        label2.setBounds(50,80,100,20);
        textField.setBounds(160,50,100,20);
        textField2.setBounds(160,80,100,20);
        button.setBounds(100,100,100,30);

        panel.add(label1);
        panel.add(textField);
        panel.add(button);
        panel.add(label2);
        panel.add(textField2);
        button.addActionListener(new ActionListener(){
                                      public void actionPerformed(ActionEvent e){
                                          JOptionPane.showMessageDialog(null, textField.getText());
                                      }
                                  }
        );

        this.setLocation(400,200);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object o = new Object();
    }
    public void showCustomerUI(){
        this.removeAll();
        this.repaint();


    }

    public static void main(String[] args) {


    }

}
