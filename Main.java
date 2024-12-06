import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main{

    private static JLabel label;
    private static JFrame frame = new JFrame(), registerFrame = new JFrame();
    private static JPanel panel = new JPanel(), registerPanel = new JPanel();
    private static JTextField userName, newUsername;
    private static JButton loginButton, registerButton;
    private static JPasswordField passWord, newPassword;

    private Map<String, String> users;
    public int totalUsers = 1;

    public static void main(String[] args) {
        Main login = new Main();
        login.login();
    }

    public void login(){

        users = new HashMap<>();
        totalUsers = 3;

        users.put("user", "password");
        users.put("admin", "admin123");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("LOGIN");
        frame.setSize(300, 300);
        frame.add(panel);

        panel.setLayout(null);

        // INPUTS
        label = new JLabel("Username:");
        label.setBounds(10, 10, 80, 25);
        panel.add(label);

        userName = new JTextField();
        userName.setBounds(80, 10, 200, 25);
        panel.add(userName);

        label = new JLabel("Password:");
        label.setBounds(10, 50, 80, 25);
        panel.add(label);

        passWord = new JPasswordField();
        passWord.setBounds(75, 50, 200, 25);
        panel.add(passWord);

        loginButton = new JButton("Login");
        loginButton.setBounds(10,150,100,25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userName.getText();
                String password = new String(passWord.getPassword());

                if (users.containsKey(username) && users.get(username).equals(password)) {
                    if (username.equals("admin")) {
                        JOptionPane.showMessageDialog(frame, "Admin login successful!");
                        new adminUser(totalUsers);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Login successful!");
                        new mainUser();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password");
                }
            }
        });
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(125,150,100,25);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        panel.add(registerButton);

        frame.setVisible(true);
    }

    public void registerUser(){

        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.setTitle("REGISTER");
        registerFrame.setSize(300, 300);
        registerFrame.add(registerPanel);

        registerPanel.setLayout(null);

        label = new JLabel("Username:");
        label.setBounds(10, 10, 80, 25);
        registerPanel.add(label);

        newUsername = new JTextField();
        newUsername.setBounds(80, 10, 200, 25);
        registerPanel.add(newUsername);

        label = new JLabel("Password:");
        label.setBounds(10, 50, 80, 25);
        registerPanel.add(label);

        newPassword = new JPasswordField();
        newPassword.setBounds(80, 50, 200, 25);
        registerPanel.add(newPassword);

        registerButton = new JButton("Register");
        registerButton.setBounds(10,150,100,25);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUser = newUsername.getText();
                String newPass = new String(newPassword.getPassword());

                if (newUser.isEmpty() || newPass.isEmpty()) {

                    JOptionPane.showMessageDialog(registerFrame, "Username or password cannot be empty");

                } else if (users.containsKey(newUser)) {

                    JOptionPane.showMessageDialog(registerFrame, "Username already exists");

                } else {

                    users.put(newUser, newPass);
                    totalUsers++;
                    JOptionPane.showMessageDialog(registerFrame, "Registration successful!");
                    registerFrame.dispose();

                }
            }
        });
        registerPanel.add(registerButton);

        registerFrame.setVisible(true);
    }
}
