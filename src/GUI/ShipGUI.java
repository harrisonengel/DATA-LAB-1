package GUI;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class ShipGUI extends javax.swing.JFrame{
	
	public ShipGUI(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 39, 65, 110, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 22, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnAddShip = new JButton("Add Ship");
		GridBagConstraints gbc_btnAddShip = new GridBagConstraints();
		gbc_btnAddShip.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddShip.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddShip.gridx = 1;
		gbc_btnAddShip.gridy = 1;
		getContentPane().add(btnAddShip, gbc_btnAddShip);
		
		JButton btnDisplayByAge = new JButton("Display by Age");
		GridBagConstraints gbc_btnDisplayByAge = new GridBagConstraints();
		gbc_btnDisplayByAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayByAge.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplayByAge.gridx = 1;
		gbc_btnDisplayByAge.gridy = 3;
		getContentPane().add(btnDisplayByAge, gbc_btnDisplayByAge);
		
		JButton btnDisplayByGender = new JButton("Display by Gender");
		GridBagConstraints gbc_btnDisplayByGender = new GridBagConstraints();
		gbc_btnDisplayByGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayByGender.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplayByGender.gridx = 1;
		gbc_btnDisplayByGender.gridy = 4;
		getContentPane().add(btnDisplayByGender, gbc_btnDisplayByGender);
		
		JButton btnDisplayAll = new JButton("Display All");
		GridBagConstraints gbc_btnDisplayAll = new GridBagConstraints();
		gbc_btnDisplayAll.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayAll.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplayAll.gridx = 1;
		gbc_btnDisplayAll.gridy = 5;
		getContentPane().add(btnDisplayAll, gbc_btnDisplayAll);
		
		JButton btnAddConvict = new JButton("Add Convict");
		GridBagConstraints gbc_btnAddConvict = new GridBagConstraints();
		gbc_btnAddConvict.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddConvict.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddConvict.gridx = 1;
		gbc_btnAddConvict.gridy = 6;
		getContentPane().add(btnAddConvict, gbc_btnAddConvict);
		
		JButton btnRemoveConvict = new JButton("Remove Convict");
		GridBagConstraints gbc_btnRemoveConvict = new GridBagConstraints();
		gbc_btnRemoveConvict.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemoveConvict.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveConvict.gridx = 1;
		gbc_btnRemoveConvict.gridy = 7;
		getContentPane().add(btnRemoveConvict, gbc_btnRemoveConvict);
		
		JButton btnSaveShips = new JButton("Save Ships");
		GridBagConstraints gbc_btnSaveShips = new GridBagConstraints();
		gbc_btnSaveShips.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveShips.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSaveShips.gridx = 1;
		gbc_btnSaveShips.gridy = 8;
		getContentPane().add(btnSaveShips, gbc_btnSaveShips);
		initGUI();
	}
	
	
	public void initGUI(){
		this.setVisible(true);
	}
	
}

