package view.homeGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import controller.VehicleClassController;

@SuppressWarnings("serial")
public class FilterPanel extends JPanel {
	private ArrayList<JCheckBox> checkBoxes;
	private final HomeWindow homeWindow;

	public FilterPanel(HomeWindow homeWindow) throws SQLException {
		this.homeWindow = homeWindow;
		setLayout(new GridLayout(0, 1));
		
		checkBoxes = new ArrayList<JCheckBox>();
		VehicleClassController vcc = new VehicleClassController();
		ArrayList<String> carClasses = vcc.getArrayList();
		
				for (String carClass : carClasses) {
			JCheckBox checkBox = new JCheckBox(carClass);
			add(checkBox);
			checkBoxes.add(checkBox);
			checkBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					collectAllSelectedCheckboxes();
				}
			});
		}
	}

	private void collectAllSelectedCheckboxes() {
		List<String> collectedVehicleClasses = new ArrayList<String>();
		for (JCheckBox checkBox : checkBoxes) {
			if (checkBox.isSelected()) {
				collectedVehicleClasses.add(checkBox.getText());
			}
		}
		homeWindow.onCheckBoxesUpdated(collectedVehicleClasses);
	}

}
