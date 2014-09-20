package GUI;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;



public class ShipGUI extends JFrame implements ActionListener{
	
	public ShipGUI(){
		
		setSize(1000, 700);
		
		JPanel Output = new JPanel();
		Output.setBounds(194, 123, 499, 464);
		getContentPane().setLayout(null);
		getContentPane().add(Output);
		
		JTextArea textArea = new JTextArea();
		Output.add(textArea);
		textArea.setEditable(false);
		textArea.setRows(25);
		textArea.setColumns(60);
		
		JPanel Buttons = new JPanel();
		Buttons.setBounds(55, 123, 129, 464);
		Buttons.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAddShip = new JButton("Add Ship");
		Buttons.add(btnAddShip);
		
		JButton btnDisplayByAge = new JButton("Display by Age");
		Buttons.add(btnDisplayByAge);
		
		
		JButton btnDisplayByGender = new JButton("Display by Gender");
		Buttons.add(btnDisplayByGender);
		

		JButton btnDisplayAll = new JButton("Display All");
		Buttons.add(btnDisplayAll);
		
		
		JButton btnAddConvict = new JButton("Add Convict");
		Buttons.add(btnAddConvict);
		
		
		JButton btnRemoveConvict = new JButton("Remove Convict");
		Buttons.add(btnRemoveConvict);
		
		
		JButton btnSaveShips = new JButton("Save Ships");
		Buttons.add(btnSaveShips);
		getContentPane().add(Buttons);
		
		JPanel Header = new JPanel();
		Header.setBounds(55, 5, 919, 107);
		getContentPane().add(Header);
		
		JLabel lblNewLabel = new JLabel("New label");
		Header.add(lblNewLabel);
		
		JPanel Input = new JPanel();
		Input.setBounds(703, 123, 271, 464);
		getContentPane().add(Input);
		btnRemoveConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		initGUI();
	}
	
	
	public void initGUI(){
		this.setVisible(true);
	}
}

