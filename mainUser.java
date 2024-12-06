

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class mainUser implements ActionListener{

    static JLabel label, invalid;
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JTextField option;
    static String[] options = {"Carbon FootPrint", "Energy Usage", "Diet", "Waste"};
    static JButton button;

    public mainUser(){
        // Scanner input = new Scanner(System.in);

        // System.out.println("Select:");
        // System.out.println("1: Carbon FootPrint\n2: Energy Usage\n3: Diet\n4: Waste");
        // int option = input.nextInt();

        // switch (option) {
        //     case 1:
        //         new carbonFootprint();
        //         break;

        //     case 2:
        //         new energyUsage();
        //         break;

        //     case 3:
        //         new dietC02();
        //         break;

        //     case 4:
        //         new wasteC02();
        //         break;

        //     default:
        //         break;
        // }
        
        // input.close();

        //main window
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("MAIN MENU");
        frame.setSize(300, 300);
        frame.add(panel);

        panel.setLayout(null);

        label = new JLabel("Welcome User!");
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
        button.addActionListener((ActionListener) this);
        panel.add(button);
        
        invalid = new JLabel("");
        invalid.setBounds(10,170,200,25);
        panel.add(invalid);

        frame.setVisible(true);
    }

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
}