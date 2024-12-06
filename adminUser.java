import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class adminUser{

    static JLabel label, invalid;
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JTextField option;
    static String[] options = {"Carbon FootPrint", "Energy Usage", "Diet", "Waste"};
    static JButton button, userButton;
    
    int totalUsers;

    public adminUser(int totalUsers){

        this.totalUsers = totalUsers;
        
        //main window
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("MAIN MENU");
        frame.setSize(300, 400);
        frame.add(panel);

        panel.setLayout(null);

        label = new JLabel("Welcome Admin!");
        label.setBounds(10,10,200,25);
        panel.add(label);

        label = new JLabel("1: Carbon FootPrint");
        label.setBounds(10,30,200,25);
        panel.add(label);

        label = new JLabel("2: Energy Usage");
        label.setBounds(10,50,200,25);
        panel.add(label);

        label = new JLabel("3: Diet");
        label.setBounds(10,70,200,25);
        panel.add(label);

        label = new JLabel("4: Waste");
        label.setBounds(10,90,200,25);
        panel.add(label);


        label = new JLabel("Enter No.:");
        label.setBounds(10,120,200,25);
        panel.add(label);

        option = new JTextField();
        option.setBounds(70,120,200, 25);
        panel.add(option);


        button = new JButton("select");
        button.setBounds(10,150,100,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = option.getText();
                int convSelected = Integer.parseInt(selected);
                System.out.println("Selected: "+convSelected);

                if(convSelected == 1){
                    new carbonFootprint();
                } else if (convSelected == 2){
                    new energyUsage();
                } else if (convSelected == 3){
                    new dietC02();
                } else if (convSelected == 4){
                    new wasteC02();
                } else{
                    invalid.setText("Invalid");
                }
            }
        });
        panel.add(button);

        userButton = new JButton("Show Users");
        userButton.setBounds(10,185,150,25);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invalid.setText("total users = "+totalUsers);
            }
        });
        panel.add(userButton);
        
        invalid = new JLabel("");
        invalid.setBounds(10,215,200,25);
        panel.add(invalid);

        frame.setVisible(true);
    }
}