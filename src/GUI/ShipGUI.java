package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Classes.*;
import java.io.FileWriter;
import java.io.IOException;



public class ShipGUI extends JFrame {
	private JTextField textFieldAge;
	private JTextField textFieldFirst;
	private JTextField textFieldLast;
	private JTextField textFieldConvictedIn;
	private JTextField textFieldSentence;
	private JTextField textFieldHome;
	private JTextField textFieldCrime;
	private JTextField textFieldProfession;
	private Admiral myAdmiral;
	private JComboBox<String> comboBoxShip;
	private JComboBox<String> comboBoxYear;
	private DefaultTableModel dtm;
	private JTable table;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JTextPane textPane;
	
	public ShipGUI(){
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 700);

		/**************************************Output Panel with a Table****************************************************/
		JPanel Output = new JPanel();
		Output.setBounds(194, 104, 499, 483);
		getContentPane().add(Output);
		Output.setLayout(null);
		
		Object columnNames[] = {"Last", "First", "Age", "Convicted", "Sentence", "Home", "Crime", "Profession", "Gender", "Year", "Ship"};
		dtm = new DefaultTableModel(columnNames, 0);
		table = new JTable(dtm);
		table.setBounds(1, 26, 789, 0);
		table.setRowSelectionAllowed(false);
		Output.add(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 499, 483);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Output.add(scrollPane);
		
		JPanel Buttons = new JPanel();
		Buttons.setBounds(31, 123, 153, 464);
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
		
		
		JButton btnSaveShips = new JButton("Save Ship");
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
		
		textFieldAge = new JTextField();
		textFieldAge.setBounds(111, 126, 150, 20);
		Input.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		textFieldFirst = new JTextField();
		textFieldFirst.setBounds(111, 170, 150, 20);
		Input.add(textFieldFirst);
		textFieldFirst.setColumns(10);
		
		textFieldLast = new JTextField();
		textFieldLast.setBounds(111, 214, 150, 20);
		Input.add(textFieldLast);
		textFieldLast.setColumns(10);
		
		textFieldConvictedIn = new JTextField();
		textFieldConvictedIn.setBounds(111, 259, 150, 20);
		Input.add(textFieldConvictedIn);
		textFieldConvictedIn.setColumns(10);
		
		textFieldSentence = new JTextField();
		textFieldSentence.setBounds(111, 306, 150, 20);
		Input.add(textFieldSentence);
		textFieldSentence.setColumns(10);
		
		textFieldHome = new JTextField();
		textFieldHome.setBounds(111, 350, 150, 20);
		Input.add(textFieldHome);
		textFieldHome.setColumns(10);
		
		textFieldCrime = new JTextField();
		textFieldCrime.setBounds(111, 391, 150, 20);
		Input.add(textFieldCrime);
		textFieldCrime.setColumns(10);
		
		textFieldProfession = new JTextField();
		textFieldProfession.setBounds(111, 433, 150, 20);
		Input.add(textFieldProfession);
		textFieldProfession.setColumns(10);
		
		JLabel lbProfession = new JLabel("Profession");
		lbProfession.setBounds(10, 439, 96, 14);
		Input.add(lbProfession);
		
		JLabel lblCrime = new JLabel("Crime");
		lblCrime.setBounds(10, 393, 46, 14);
		Input.add(lblCrime);
		
		JLabel lblLocation = new JLabel("Home");
		lblLocation.setBounds(10, 353, 91, 14);
		Input.add(lblLocation);
		
		JLabel lblSentence = new JLabel("Sentence Length");
		lblSentence.setBounds(10, 310, 91, 14);
		Input.add(lblSentence);
		
		JLabel lblSentencedBy = new JLabel("Convicted In");
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
		
		comboBoxShip = new JComboBox<String>();
		comboBoxShip.setBounds(111, 11, 150, 20);
		Input.add(comboBoxShip);
		comboBoxShip.addItem("All Ships");
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(111, 78, 53, 23);
		Input.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(183, 78, 64, 23);
		Input.add(rdbtnFemale);
		
		ButtonGroup genderButtons = new ButtonGroup();
		genderButtons.add(rdbtnMale);
		genderButtons.add(rdbtnFemale);
		
		JLabel lblSelectShip = new JLabel("Ship");
		lblSelectShip.setBounds(10, 14, 77, 14);
		Input.add(lblSelectShip);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 57, 46, 14);
		Input.add(lblYear);
		
		comboBoxYear = new JComboBox<String>();
		comboBoxYear.setBounds(111, 51, 150, 20);
		Input.add(comboBoxYear);
		comboBoxYear.addItem("All Years");
		
		
		JPanel panel = new JPanel();
		panel.setBounds(204, 569, 489, 82);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Bottom");
		lblNewLabel_2.setBounds(130, 23, 255, 59);
		lblNewLabel_2.setIcon(new ImageIcon(ShipGUI.class.getResource("/GUI/cooltext1732865982.jpg")));
		panel.add(lblNewLabel_2);
		
		textPane = new JTextPane();
		textPane.setBounds(713, 598, 261, 53);
		getContentPane().add(textPane);
		
		btnAddShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm.setNumRows(0);
				try {String fileName = getFileName();
				if (fileName != null) {
					myAdmiral.addShip(getFileName());
					comboBoxShip.addItem(myAdmiral.getCurrentShip().getName());
				}
				} catch (NullPointerException np){
					textPane.setText("No ship was added.");
				} catch (NumberFormatException nfp){
					textPane.setText("No ship added, make sure you select a properly formatted .txt file.");
				}
			}
		});
		
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				String shipName = (String)comboBoxShip.getSelectedItem();
				String year = (String)comboBoxYear.getSelectedItem();
				ConvictPrinter.printAllConvicts(shipName, year, dtm, myAdmiral);
			}
		});
		
		btnDisplayByGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				dtm.setRowCount(0);
				String gender;
				if (rdbtnMale.isSelected()) gender = "M";
				else if (rdbtnFemale.isSelected()) gender = "F";
				else {
					textPane.setText("Please select a gender.");
					return;
				}
				String shipName = (String)comboBoxShip.getSelectedItem();
				String year = (String)comboBoxYear.getSelectedItem();
				ConvictPrinter.printByGender(shipName, year, gender, dtm, myAdmiral);
			}
		});
		
		btnDisplayByAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm.setRowCount(0);
				if (ConvictPrinter.isNumeric(textFieldAge.getText())){
					String age = textFieldAge.getText();
					String shipName = (String)comboBoxShip.getSelectedItem();
					String year = (String)comboBoxYear.getSelectedItem();
					ConvictPrinter.printByAge(shipName, year, age, dtm, myAdmiral);
					textPane.setText("");
				} else{
					dtm.setNumRows(0);
					textPane.setText("Please enter a numeric age into the age field.");
					return;
				}
			}		
		});
		
		
		btnRemoveConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm.setNumRows(0);
				String ship = (String)comboBoxShip.getSelectedItem();
				String year = (String)comboBoxYear.getSelectedItem();
				String age = textFieldAge.getText();
				String first = textFieldFirst.getText();
				String last = textFieldLast.getText();
				
				if (ship.equalsIgnoreCase("All Ships") || year.equalsIgnoreCase("All Years")){
					textPane.setText("Be more specific. Select a ship and a year.");
					return;
				}
				else {
					myAdmiral.removeConvict(ship, year, age, first, last);
					textPane.setText("Convict successfully removed! (hopefully for good behavior)");
				}
			}
		});
		
		btnAddConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setNumRows(0);
				String ship = (String)comboBoxShip.getSelectedItem();
				String yearString = (String)comboBoxYear.getSelectedItem();
				
				if (ship.equalsIgnoreCase("All Ships") || yearString.equalsIgnoreCase("All Years")){
					textPane.setText("Don't be cruel! Convicts can't be added to all ships or all years, no one is that bad! Please select a ship and a year.");
					return;
				} else{
					try {int year = Integer.parseInt(yearString);
					myAdmiral.addConvict(ship, year, getConvictString());
					comboBoxShip.addItem(myAdmiral.getCurrentShip().getName());
					textPane.setText("Convict Successfully Added!");
					} catch (ArrayIndexOutOfBoundsException exception){
						textPane.setText("Unable to read file. Make sure your .txt file is formatted correctly.");
					}
				}
			}
		});
		
		comboBoxShip.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0){
					comboBoxYear.removeAllItems();
					comboBoxYear.addItem("All Years");
					String ship = (String)comboBoxShip.getSelectedItem();
					if (!ship.equals("All Ships")){
						for (Object s: myAdmiral.getShip(ship).getAvailableYears()){
							comboBoxYear.addItem("" + s);
						}
					}
				}
		});
		
		btnSaveShips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				String shipName = (String)comboBoxShip.getSelectedItem();
				if (!shipName.equalsIgnoreCase("All Ships"))saveFile(shipName);
				else textPane.setText("You can't save all ships at once. Each ship must be saved individually. Sorry if you have a large fleet.");
			}
		});
		
		initGUI();
	}
	
	
	private String getConvictString(){
		String gender = "";
		if (rdbtnMale.isSelected()) gender = "M";
		else if (rdbtnFemale.isSelected()) gender = "F";
		
		
		String convictLine =   	gender +"/" + textFieldLast.getText() + "/" + textFieldFirst.getText() + "/" 
								+ textFieldAge.getText() + "/" + textFieldConvictedIn.getText() + "/" + textFieldSentence.getText() + "/"
								+ textFieldHome.getText() + "/" + textFieldCrime.getText() + "/" + textFieldProfession.getText();
		return convictLine;
	}
	
	public void initGUI(){
		this.setVisible(true);
		this.myAdmiral = new Admiral();
	}
	
	public String getFileName() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION){
			textPane.setText("Ship Added");
			return fc.getSelectedFile().getPath();
		}
		else {
			textPane.setText("No Ship Added");
			return null;
		}
	}
	
	public void saveFile(String shipName) {
		
		textPane.setText("");
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			try (FileWriter fw = new FileWriter(fc.getSelectedFile())) {
				fw.write(shipName + "\n");
				YearNode curYear = myAdmiral.getShip(shipName).getYearPtr();
				fw.write("" + curYear.getYearSailed() + "\n");

				do {
					GenderNode curGender = curYear.getRight();
					do {
						if (curGender.getDown() != null) {
							ConvictNode curConv = curGender.getDown();
							do {
								fw.write(curGender.getGender() + "/"
										+ curConv.getLastName() + "/"
										+ curConv.getFirstName() + "/"
										+ curConv.getAge() + "/"
										+ curConv.getWhereConvicted() + "/"
										+ curConv.getJailSentence() + "/"
										+ curConv.getHomeAdd() + "/"
										+ curConv.getCrime() + "/"
										+ curConv.getProfession() + "/\n");
								curConv = curConv.getNext();
							} while (curConv != curGender.getDown());
						}
						curGender = curGender.getRight();

					} while (curGender != null);
					curYear = curYear.getDown();
					fw.write("*****\n");
					if (curYear != myAdmiral.getShip(shipName).getYearPtr())
						fw.write("" + curYear.getYearSailed() + "\n");
				} while (curYear != myAdmiral.getShip(shipName).getYearPtr());
				textPane.setText("Ship Saved!");
			} catch (IOException i) {
				textPane.setText("Unable to save file. Did you select the .txt file that the ship came from?");
			}
		}
	}
}

