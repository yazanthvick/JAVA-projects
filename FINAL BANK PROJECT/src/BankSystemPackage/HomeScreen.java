package BankSystemPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeScreen extends JFrame {

    Container container;
    DataLoader loader = new DataLoader();
    Credential cred;

    public HomeScreen(){
        super(BankHeadOffice.getBankHeadOffice().getBankName() + " Banking System");
        showSignInUI();
    }
    public void showSignInUI(){
        container = this.getContentPane();
        container.setLayout(null);

        // UI componentes
        JLabel title = new JLabel(BankHeadOffice.getBankHeadOffice().getBankName()+" Banking Logging System");
        title.setFont(new Font("Arial", Font.BOLD,22));
        JLabel usernameL = new JLabel("User Name:");
        usernameL.setFont(new Font("Arial", Font.BOLD,16));
        JLabel passwordL = new JLabel("Password: ");
        passwordL.setFont(new Font("Arial", Font.BOLD,16));
        JTextField usernameT = new JTextField();
        JTextField passwordT = new JPasswordField();
        JButton signin = new JButton("Sign in");

        signin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cred = loader.login(usernameT.getText(),passwordT.getText());
                if( cred == null){
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password ... Try again");
                }else{
                    if(cred.getUserType() == CredentialUserTypes.CUSTOMER_USER){
                        clearContentPane();
                        showCustomerUI();
                    }

                }

            }
        });

        // Layout for UI components
        title.setBounds(50,20,300,40);
        usernameL.setBounds(60,80,100,30);
        passwordL.setBounds(60,110,100,30);
        usernameT.setBounds(160,80,180,30);
        passwordT.setBounds(160,110,180,30);
        signin.setBounds(120,160,170,40);
        // Adding UI components to the container
        container.add(title);
        container.add(usernameL);
        container.add(passwordL);
        container.add(usernameT);
        container.add(passwordT);
        container.add(signin);


        this.setSize(420,270);
        this.setLocation(400,200);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showCustomerUI(){
        Customer customer = cred.getCustomer();
        JLabel customerTitle = new JLabel("Welcome "+ customer.getCustomerName());
        customerTitle.setFont(new Font("Arial", Font.BOLD,24));
        customerTitle.setBounds(100,20,300,40);

        JPanel accountSummary = new JPanel();
        accountSummary.setBounds(30,80,350,200);
        accountSummary.setLayout(null);

        JLabel accountTitle = new JLabel("Accounts:");
        accountTitle.setFont(new Font("Arial", Font.BOLD,18));
        accountTitle.setForeground(Color.blue);
        accountTitle.setBounds(1,1,100,30);
        CheckingAccount checking = customer.getCheckingAccount();

        if(checking != null){
            System.out.println(checking.getAccountBalance());
            JLabel checkingAccountTitle = new JLabel("Checking Account: ");
            checkingAccountTitle.setFont(new Font("Arial", Font.PLAIN,12));
            checkingAccountTitle.setBounds(1,30,150,30);
            JLabel amountTitle = new JLabel(String.valueOf(checking.getAccountBalance()));
            amountTitle.setFont(new Font("Arial", Font.PLAIN,12));
            amountTitle.setForeground(Color.blue);
            amountTitle.setBounds(160,30,50,30);
            JButton checkingAccountButton = new JButton("Details");
            checkingAccountButton.setFont(new Font("Arial", Font.PLAIN,12));
            checkingAccountButton.setBounds(250,30,80,30);
            checkingAccountButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //show AccountUI
                    clearContentPane();
                    showAccountUI(checking);
                }
            });
            accountSummary.add(checkingAccountTitle);
            accountSummary.add(checkingAccountButton);
            accountSummary.add(amountTitle);
        }
        SavingAccount saving = customer.getSavingAccount();
        if(saving != null){

            JLabel savingAccountTitle = new JLabel("Saving Account: ");
            savingAccountTitle.setFont(new Font("Arial", Font.PLAIN,12));
            savingAccountTitle.setBounds(1,65,150,30);
            JLabel amountTitle = new JLabel(String.valueOf(saving.getAccountBalance()));
            amountTitle.setFont(new Font("Arial", Font.PLAIN,12));
            amountTitle.setForeground(Color.blue);
            amountTitle.setBounds(160,65,50,30);
            JButton savingAccountButton = new JButton("Details");
            savingAccountButton.setFont(new Font("Arial", Font.PLAIN,12));
            savingAccountButton.setBounds(250,65,80,30);

            accountSummary.add(savingAccountTitle);
            accountSummary.add(savingAccountButton);
            accountSummary.add(amountTitle);
        }


        accountSummary.add(accountTitle);

        container.add(customerTitle);
        container.add(accountSummary);
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu newMenu = new JMenu("New");
        JMenuItem project = new JMenuItem("Project");

        JMenuItem signout = new JMenuItem("Sign Out");
        menubar.add(file);
        file.add(newMenu);
        file.add(signout);
        newMenu.add(project);
        this.setJMenuBar(menubar);

        signout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clearContentPane();
                showSignInUI();
            }
        });

        this.setSize(400,400);
        this.setLocation(350,100);
    }

    public void showAccountUI(Account acct){
        if(acct instanceof CheckingAccount){
            CheckingAccount checking = (CheckingAccount)acct;
            JLabel accountTitle = new JLabel("Checking Account "+ checking.getAccountName());
            accountTitle.setFont(new Font("Arial", Font.BOLD,24));
            accountTitle.setBounds(30,20,300,40);

            JPanel accountDetails = new JPanel();
            accountDetails.setBounds(30,80,350,200);
            accountDetails.setLayout(null);

            JLabel accountNumberTitle = new JLabel("Account #: "+checking.getAccountNumber());
            accountNumberTitle.setFont(new Font("Arial", Font.BOLD,12));
            accountNumberTitle.setBounds(1,1,120,30);
            JLabel balanceTitle = new JLabel("Balance: "+checking.getAccountBalance());
            balanceTitle.setFont(new Font("Arial", Font.BOLD,12));
            balanceTitle.setBounds(120,1,120,30);
            JLabel branchTitle = new JLabel("Branch: TD");
            branchTitle.setFont(new Font("Arial", Font.BOLD,12));
            branchTitle.setBounds(240,1,120,30);

            JLabel feesTitle = new JLabel("Fees: "+checking.getAccountFees());
            feesTitle.setFont(new Font("Arial", Font.BOLD,12));
            feesTitle.setBounds(1,30,120,30);
            JLabel waivedThresoldTitle = new JLabel("Threshold: "+checking.getMinimumWaivedFeesAmount());
            waivedThresoldTitle.setFont(new Font("Arial", Font.BOLD,12));
            waivedThresoldTitle.setBounds(120,30,120,30);
            JLabel maxTransactionsTitle = new JLabel("Max Trans: "+checking.getMaxNumberOfTransactions());
            maxTransactionsTitle.setFont(new Font("Arial", Font.BOLD,12));
            maxTransactionsTitle.setBounds(240,30,120,30);

            JTextArea allTransactions = new JTextArea();
            allTransactions.setLineWrap(true);
            allTransactions.setBounds(1,65,350,250);
            ArrayList<Transaction> trans = checking.getAccountTransactions();
            for(int i=0;i<trans.size();i++){
                Transaction t = trans.get(i);
                allTransactions.append(t.toString());
            }


            accountDetails.add(accountNumberTitle);
            accountDetails.add(balanceTitle);
            accountDetails.add(branchTitle);
            accountDetails.add(feesTitle);
            accountDetails.add(waivedThresoldTitle);
            accountDetails.add(maxTransactionsTitle);
            accountDetails.add(allTransactions);


            container.add(accountTitle);
            container.add(accountDetails);
        }else if(acct instanceof SavingAccount){

        }
    }
    public void clearContentPane(){
        this.setJMenuBar(null);
        container.removeAll();
        container.revalidate();
        container.repaint();
    }
    public static void main(String[] args) {
        new HomeScreen();
    }
}
