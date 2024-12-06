
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class energyUsage implements ActionListener{

    static JLabel label, total;
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JTextField electricity, emissionHeat, heatingOil, emissionOil;
    static JButton button;

    public energyUsage(){

        //main window
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("ENERGY USAGE");
        frame.setSize(1080, 720);
        frame.add(panel);

        panel.setLayout(null);

        //INPUTS

        //electricity consumption
        label = new JLabel("Electricity Consumption:");
        label.setBounds(10,10,200,25);
        panel.add(label);

        electricity = new JTextField("per month");
        electricity.setBounds(215,10,200, 25);
        panel.add(electricity);

        //heating type used by user
        label = new JLabel("Emission Factor of heating used:");
        label.setBounds(10,50,200,25);
        panel.add(label);

        emissionHeat = new JTextField();
        emissionHeat.setBounds(215,50,200, 25);
        panel.add(emissionHeat);

        //amountoil used by the 
        label = new JLabel("Amount of Oil Used:");
        label.setBounds(10,100,200,25);
        panel.add(label);

        heatingOil = new JTextField("In leters");
        heatingOil.setBounds(215,100,200, 25);
        panel.add(heatingOil);

        //EMF FOR THE OIL
        label = new JLabel("Emission factor for oil:");
        label.setBounds(10,150,200,25);
        panel.add(label);

        emissionOil = new JTextField();
        emissionOil.setBounds(215,150,200, 25);
        panel.add(emissionOil);


        button = new JButton("Calculate");
        button.setBounds(10,200,100,25);
        button.addActionListener((ActionListener) this);
        panel.add(button);

        total = new JLabel("");
        total.setBounds(10,250,200,25);
        panel.add(total);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String eleCity = electricity.getText(),
               heat = emissionHeat.getText(),
               oil = heatingOil.getText(),
               emfOil = emissionOil.getText();
        
        int convElecity = Integer.parseInt(eleCity),
            convOil = Integer.parseInt(oil),
            convEmfoil = Integer.parseInt(emfOil),
            convHeat = Integer.parseInt(heat);

        int totalCO2 = (convElecity*convHeat)+(convOil*convEmfoil);

        total.setText("Total CO2 from Energy Usage = "+totalCO2);
    }
}
