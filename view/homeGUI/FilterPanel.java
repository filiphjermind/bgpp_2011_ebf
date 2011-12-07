package view.homeGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import controller.VehicleClassControl;

@SuppressWarnings("serial")
public class FilterPanel extends JPanel {
	private ArrayList<JCheckBox> checkBoxes;
	private final HomeWindow homeWindow;

	public FilterPanel(HomeWindow homeWindow) throws SQLException {
		this.homeWindow = homeWindow;
		setLayout(new GridLayout(0, 1));
		
		checkBoxes = new ArrayList<JCheckBox>();
		VehicleClassControl vcc = new VehicleClassControl();
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
		List<JCheckBox> collectedCheckBoxes = new ArrayList<JCheckBox>();
		for (JCheckBox checkBox : checkBoxes) {
			if (checkBox.isSelected()) {
				collectedCheckBoxes.add(checkBox);
			}
		}
		//TODO send forespørgsel til database med information om de valgte checkboxes (collectedCheckBoxes)
	}

}
