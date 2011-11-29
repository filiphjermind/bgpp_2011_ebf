import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class AllVehicles {
	
	private JFrame frame;
	private Container contentPane;
	
	public AllVehicles() 
	{
		makeFrame();
	}

	private void makeFrame() 
	{
		
		frame = new JFrame();
		contentPane = frame.getContentPane();
		
		//make the panel for the allVehicles tab
		JPanel allVehiclesPanel = new JPanel();
		allVehiclesPanel.setLayout(new BorderLayout());
		contentPane.add(allVehiclesPanel);
		
		
		JPanel tablePanel = new JPanel();
		allVehiclesPanel.add(tablePanel, BorderLayout.CENTER);
	
		JPanel searchPanel = new JPanel();
		FlowLayout searchLayout = new FlowLayout();
		searchLayout.setAlignment(0);
		searchPanel.setLayout(searchLayout);
		allVehiclesPanel.add(searchPanel, BorderLayout.NORTH);
	
		JLabel licenseLabel = new JLabel("License nr.");
		searchPanel.add(licenseLabel);
		
		JTextField licenceText = new JTextField(20);
		searchPanel.add(licenceText);
		
		JButton searchButton = new JButton("Search");
		searchPanel.add(searchButton);
			searchButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new SVGUI();
				}
			});
		
		// Display
		frame.pack();
		frame.setVisible(true);
	
	}
}