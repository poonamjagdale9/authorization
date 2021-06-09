package LoginSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLable = new JLabel("UserID:");
    JLabel userPasswordLable = new JLabel("Password:");
    JLabel messageLable = new JLabel();


    // we need to write same hashmap from idandpasswordclass in this class, so loginInfo will be globally available on this page
    HashMap<String, String> loginInfo = new HashMap<String , String >();

    LoginPage(HashMap<String,String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;

        userIDLable.setBounds(50,100,75,25);
        userPasswordLable.setBounds(50,150,75,25);
        messageLable.setBounds(125,250,250,35);
        messageLable.setFont(new Font(null,Font.ITALIC,25));
        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);
        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(userIDLable);
        frame.add(userPasswordLable);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(messageLable);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource()== loginButton){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID)){
                if(loginInfo.get(userID).equals(password)){
                    messageLable.setForeground(Color.green);
                    messageLable.setText("Login successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                }
                else{
                    messageLable.setForeground(Color.red);
                    messageLable.setText("Wrong Password");
                }
            }
            else {
                messageLable.setForeground(Color.red);
                messageLable.setText("User name not found");
            }
        }
    }
}
