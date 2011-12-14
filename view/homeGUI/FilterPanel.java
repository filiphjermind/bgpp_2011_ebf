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

/**
 * This class is responsible of giving the user an opportunity to filter
 * the reservations in the reservation table based on vehicle classes.
 *
 */

@SuppressWarnings("serial")
public class FilterPanel extends JPanel {
	private ArrayList<JCheckBox> checkBoxes;
	private final HomeWindow homeWindow;

	/**
	 * This constructor is responsible of making a new object that initializes 
	 * the checkboxes in the panel among other things
	 * @param homeWindow the homeWindow in which this class i instantiated
	 * @throws SQLException
	 */
	public FilterPanel(HomeWindow homeWindow) throws SQLException {
		this.homeWindow = homeWindow;
		setLayout(new GridLayout(0, 1));
		makeCheckBoxes();
		collectAllSelectedCheckboxes();
	}

	/**
	 * This class takes care of making checkboxes and adding action listener to the checkboxes 
	 * and referencing them in a list for later use. 
	 * @throws SQLException
	 */
	private void makeCheckBoxes() throws SQLException {
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

	/**
	 * This method should be called every time a checkbox is clicked. It
	 * takes care of collectiong all the checkboxes which are selected and
	 * telling it to homewindow.
	 */
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
