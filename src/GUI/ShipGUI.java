package GUI;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;



public class ShipGUI extends JFrame {
	private JTextField textFieldGender;
	private JTextField textFieldAge;
	private JTextField textFieldFirst;
	private JTextField textFieldLast;
	private JTextField textFieldSentencedBy;
	private JTextField textFieldSentence;
	private JTextField textFieldLocation;
	private JTextField textFieldCrime;
	private JTextField textFieldOccupation;
	
	public ShipGUI(){
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setSize(1000, 700);
		
		JPanel Output = new JPanel();
		Output.setBounds(194, 104, 499, 483);
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
		btnAddShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		Buttons.add(btnAddShip);
		
		JButton btnDisplayByAge = new JButton("Display by Age");
		btnDisplayByAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Buttons.add(btnDisplayByAge);
		
		
		JButton btnDisplayByGender = new JButton("Display by Gender");
		btnDisplayByGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Buttons.add(btnDisplayByGender);
		

		JButton btnDisplayAll = new JButton("Display All");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Buttons.add(btnDisplayAll);
		
		
		JButton btnAddConvict = new JButton("Add Convict");
		btnAddConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Buttons.add(btnAddConvict);
		
		
		JButton btnRemoveConvict = new JButton("Remove Convict");
		Buttons.add(btnRemoveConvict);
		
		
		JButton btnSaveShips = new JButton("Save Ships");
		btnSaveShips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Buttons.add(btnSaveShips);
		getContentPane().add(Buttons);
		
		JPanel Header = new JPanel();
		Header.setBounds(55, 5, 919, 88);
		getContentPane().add(Header);
		 
		ImageIcon icon = new ImageIcon("/GUI/theocean.jpg"); 
		Header.setLayout(null);
		
		JLabel lblTopLabel = new JLabel(icon);
		lblTopLabel.setBounds(192, 0, 540, 89);
		Header.add(lblTopLabel);
		lblTopLabel.setIcon(new ImageIcon(ShipGUI.class.getResource("/GUI/theocean.jpg")));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ShipGUI.class.getResource("/GUI/homeimage.jpg")));
		lblNewLabel.setBounds(726, -6, 193, 111);
		Header.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ShipGUI.class.getResource("/GUI/homeimage.jpg")));
		lblNewLabel_1.setBounds(0, 0, 204, 98);
		Header.add(lblNewLabel_1);
		
		JPanel Input = new JPanel();
		Input.setBounds(703, 123, 271, 464);
		getContentPane().add(Input);
		Input.setLayout(null);
		
		textFieldGender = new JTextField();
		textFieldGender.setBounds(111, 79, 150, 20);
		Input.add(textFieldGender);
		textFieldGender.setColumns(10);
		
		textFieldAge = new JTextField();
		textFieldAge.setBounds(111, 214, 150, 20);
		Input.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		textFieldFirst = new JTextField();
		textFieldFirst.setBounds(111, 170, 150, 20);
		Input.add(textFieldFirst);
		textFieldFirst.setColumns(10);
		
		textFieldLast = new JTextField();
		textFieldLast.setBounds(111, 124, 150, 20);
		Input.add(textFieldLast);
		textFieldLast.setColumns(10);
		
		textFieldSentencedBy = new JTextField();
		textFieldSentencedBy.setBounds(111, 259, 150, 20);
		Input.add(textFieldSentencedBy);
		textFieldSentencedBy.setColumns(10);
		
		textFieldSentence = new JTextField();
		textFieldSentence.setBounds(111, 306, 150, 20);
		Input.add(textFieldSentence);
		textFieldSentence.setColumns(10);
		
		textFieldLocation = new JTextField();
		textFieldLocation.setBounds(111, 350, 150, 20);
		Input.add(textFieldLocation);
		textFieldLocation.setColumns(10);
		
		textFieldCrime = new JTextField();
		textFieldCrime.setBounds(111, 391, 150, 20);
		Input.add(textFieldCrime);
		textFieldCrime.setColumns(10);
		
		textFieldOccupation = new JTextField();
		textFieldOccupation.setBounds(116, 433, 145, 20);
		Input.add(textFieldOccupation);
		textFieldOccupation.setColumns(10);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(10, 439, 96, 14);
		Input.add(lblOccupation);
		
		JLabel lblCrime = new JLabel("Crime");
		lblCrime.setBounds(10, 393, 46, 14);
		Input.add(lblCrime);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(10, 353, 91, 14);
		Input.add(lblLocation);
		
		JLabel lblSentence = new JLabel("Sentence");
		lblSentence.setBounds(10, 310, 77, 14);
		Input.add(lblSentence);
		
		JLabel lblSentencedBy = new JLabel("Sentenced By");
		lblSentencedBy.setBounds(10, 262, 91, 14);
		Input.add(lblSentencedBy);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 217, 77, 14);
		Input.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 173, 91, 14);
		Input.add(lblFirstName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 129, 46, 14);
		Input.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 82, 46, 14);
		Input.add(lblGender);
		
		JPanel panel = new JPanel();
		panel.setBounds(204, 569, 489, 82);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Bottom");
		lblNewLabel_2.setBounds(130, 23, 255, 59);
		lblNewLabel_2.setIcon(new ImageIcon(ShipGUI.class.getResource("/GUI/cooltext1732865982.jpg")));
		panel.add(lblNewLabel_2);
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

