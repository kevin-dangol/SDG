
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class wasteC02 implements ActionListener{

    static JLabel label, total;
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JTextField wasteGenerated, emissionWaste, recycleRate;
    static JButton button;

    public wasteC02(){

        //main window
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("DIET C02");
        frame.setSize(1080, 720);
        frame.add(panel);

        panel.setLayout(null);

        //INPUTS

        //Waste generated per week
        label = new JLabel("Waste Generated:");
        label.setBounds(10,10,200,25);
        panel.add(label);

        wasteGenerated = new JTextField("pounds per week");
        wasteGenerated.setBounds(165,10,200, 25);
        panel.add(wasteGenerated);

        //emission factor for the waste
        label = new JLabel("Emission Factor of waste:");
        label.setBounds(10,50,200,25);
        panel.add(label);

        emissionWaste = new JTextField();
        emissionWaste.setBounds(165,50,200, 25);
        panel.add(emissionWaste);

        //Recycle rate
        label = new JLabel("Recycling rate:");
        label.setBounds(10,100,200,25);
        panel.add(label);

        recycleRate = new JTextField();
        recycleRate.setBounds(165,100,200, 25);
        panel.add(recycleRate);


        button = new JButton("Calculate");
        button.setBounds(10,150,100,25);
        button.addActionListener((ActionListener) this);
        panel.add(button);

        total = new JLabel("");
        total.setBounds(10,250,200,25);
        panel.add(total);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String waste = wasteGenerated.getText(),
               emfWaste = emissionWaste.getText(),
               recycle = recycleRate.getText();
        
        int convWaste = Integer.parseInt(waste),
            convEmfwate = Integer.parseInt(emfWaste),
            convRecycle = Integer.parseInt(recycle);

        int totalCO2 = (convWaste*convEmfwate)+(1-convRecycle);

        total.setText("Total CO2 from Energy Usage = "+totalCO2);
    }
}
