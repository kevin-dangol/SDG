
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class dietC02 implements ActionListener{

    static JLabel label, total;
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JTextField meatConsumption, emissionMeat, dairyConsumption, emissionDairy;
    static JButton button;

    public dietC02(){

        //main window
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("DIET C02");
        frame.setSize(1080, 720);
        frame.add(panel);

        panel.setLayout(null);

        //INPUTS

        //meat consumption per week
        label = new JLabel("Meat Consumption per week:");
        label.setBounds(10,10,200,25);
        panel.add(label);

        meatConsumption = new JTextField("servings per week");
        meatConsumption.setBounds(185,10,200, 25);
        panel.add(meatConsumption);

        //emission factor for the meat
        label = new JLabel("Emission Factor of meat:");
        label.setBounds(10,50,200,25);
        panel.add(label);

        emissionMeat = new JTextField();
        emissionMeat.setBounds(185,50,200, 25);
        panel.add(emissionMeat);

        //Dairy consumption per week
        label = new JLabel("Dairy Consumption per week:");
        label.setBounds(10,100,200,25);
        panel.add(label);

        dairyConsumption = new JTextField("servings per week");
        dairyConsumption.setBounds(185,100,200, 25);
        panel.add(dairyConsumption);

        //emission factor for the dairy
        label = new JLabel("Emission factor for Dairy:");
        label.setBounds(10,150,200,25);
        panel.add(label);

        emissionDairy = new JTextField();
        emissionDairy.setBounds(185,150,200, 25);
        panel.add(emissionDairy);


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
        
        String meat = meatConsumption.getText(),
               emfMeat = emissionMeat.getText(),
               dairy = dairyConsumption.getText(),
               emfDairy = emissionDairy.getText();
        
        int convMeat = Integer.parseInt(meat),
            convEmfmeat = Integer.parseInt(emfMeat),
            convDairy = Integer.parseInt(dairy),
            convEmfdairy = Integer.parseInt(emfDairy);

        int totalCO2 = (convMeat*convEmfmeat)+(convDairy*convEmfdairy);

        total.setText("Total CO2 from Energy Usage = "+totalCO2);
    }
}
