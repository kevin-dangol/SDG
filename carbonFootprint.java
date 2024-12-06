
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class carbonFootprint implements ActionListener{
    
    static JLabel label, total;
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JTextField distanceOne, distanceTwo, emmissionFactor, airTravel;
    static String[] transOption = {"Car", "Bike"};
    static JButton button;

    public carbonFootprint(){

        //main window
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("TRASPORTATION");
        frame.setSize(1080, 720);
        frame.add(panel);

        panel.setLayout(null);


        //INPUTS

        //type of the vehical
        label = new JLabel("Type:");
        label.setBounds(10,10,80,25);
        panel.add(label);

        //dropdown to select
        JComboBox<String> dropdown = new JComboBox<>(transOption);
        dropdown.setBounds(50, 10, 165, 25);
        panel.add(dropdown);

        //distance traveled by the selected vehical
        label = new JLabel("Distance Traveled:");
        label.setBounds(10,50,200,25);
        panel.add(label);

        distanceOne = new JTextField();
        distanceOne.setBounds(125,50,200, 25);
        panel.add(distanceOne);

        //Emmission factor of that vehical
        label = new JLabel("Emmission Factor:");
        label.setBounds(10,100,200,25);
        panel.add(label);

        emmissionFactor = new JTextField();
        emmissionFactor.setBounds(125,100,200, 25);
        panel.add(emmissionFactor);

        //How many times has the user traveled by air
        label = new JLabel("Air travel per year:");
        label.setBounds(10,150,200,25);
        panel.add(label);

        airTravel = new JTextField();
        airTravel.setBounds(125,150,200, 25);
        panel.add(airTravel);

        //How much distance has the user traveled by air
        label = new JLabel("Distance Traveled:");
        label.setBounds(10,200,200,25);
        panel.add(label);

        distanceTwo = new JTextField();
        distanceTwo.setBounds(125,200,200, 25);
        panel.add(distanceTwo);


        button = new JButton("Calculate");
        button.setBounds(10,250,100,25);
        button.addActionListener((ActionListener) this);
        panel.add(button);

        total = new JLabel("");
        total.setBounds(10,300,200,25);
        panel.add(total);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //getting the inputs, converting and calucating the total CO2

        String dis1 = distanceOne.getText(),
               dis2 = distanceTwo.getText(),
               emmFact = emmissionFactor.getText(),
               air = airTravel.getText();

        int convDis1 = Integer.parseInt(dis1),
            convDis2 = Integer.parseInt(dis2),
            convEmF = Integer.parseInt(emmFact),
            convAir = Integer.parseInt(air);

        int totalCO2 = (convDis1*convEmF)+(convAir*convDis2);

        total.setText("Total CO2 from Trasportation = "+totalCO2);
    }
}