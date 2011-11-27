package mainWindow;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class FilterPane extends JPanel {
	private final List<String> carClasses;
	private ArrayList<JCheckBox> checkBoxes;
	private final MainWindow mainWindow;

	public FilterPane(List<String> carClasses, MainWindow mainWindow) {
		this.carClasses = carClasses;
		this.mainWindow = mainWindow;
		setLayout(new GridLayout(0, 1));
		checkBoxes = new ArrayList<JCheckBox>();
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
		ArrayList<JCheckBox> collectedCheckBoxes = new ArrayList<JCheckBox>();
		for (JCheckBox checkBox : checkBoxes) {
			if (checkBox.isSelected()) {
				collectedCheckBoxes.add(checkBox);
			}
		}
		mainWindow.updateVehiclesPane(collectedCheckBoxes);
	}

}
