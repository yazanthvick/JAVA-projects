package BankSystemPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestWindow extends JFrame {

    public TestWindow(){
        super("Test Window Application");
        Container container = this.getContentPane();
        /* Flow Layout example
        container.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Enter User Name");
        JTextField text1 = new JTextField(30);
        JButton button1 = new JButton("Login");

        container.add(label1);
        container.add(text1);
        container.add(button1);
         */
        /* Using Border Layout
        container.setLayout(new BorderLayout());

        JLabel label1 = new JLabel("Enter User Name");
        JTextField text1 = new JTextField(30);
        JButton button1 = new JButton("Login");

        container.add(label1,BorderLayout.NORTH);
        container.add(text1,BorderLayout.WEST);
        container.add(button1,BorderLayout.SOUTH);
       */
        /* Using Grid Layout
        container.setLayout(new GridLayout(2,2));

        JLabel label1 = new JLabel("Enter User Name");
        JTextField text1 = new JTextField(30);
        JButton button1 = new JButton("Login");

        container.add(label1);
        container.add(text1);
        container.add(button1);
         */
        /* Using Null layout
        container.setLayout(null);


        JLabel label1 = new JLabel("Enter User Name");
        JTextField text1 = new JTextField(30);
        JButton button1 = new JButton("Login");

        label1.setBounds(50,50,100,20);
        text1.setBounds(160,50,100,20);
        button1.setBounds(100,80,100,30);

        container.add(label1);
        container.add(text1);
        container.add(button1);
        */

        // Using JPanel
        container.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        JLabel label1 = new JLabel("Enter User Name");
        JTextField text1 = new JTextField(30);
        JButton button1 = new JButton("Login");

        label1.setBounds(50,50,100,20);
        text1.setBounds(160,50,100,20);
        button1.setBounds(100,80,100,30);
        // First way of handling event by creating another class that impelemtns ActionLister
        // then this will force us to override actionPerformed abstract method.
        // then we pass this object to the addActionLister for the button
        // as a result every time you click button1 it will call the hander1.actionPerformed
        /*
        Button1Handler handler1 = new Button1Handler(text1);
        button1.addActionListener(handler1);
        //button1.addActionListener(new Button1Handler(text1));
        */
        // second way of handling events
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, text1.getText());
            }
        }
        );

        panel1.add(label1);
        panel1.add(text1);
        panel1.add(button1);

        container.add(new JLabel("Welcome to Banking System"), BorderLayout.NORTH);
        container.add(panel1, BorderLayout.CENTER);

        this.setLocation(400,200);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    //TestWindow window = new TestWindow();
    new TestWindow();
    }
}
