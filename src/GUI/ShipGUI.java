package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Classes.*;
import java.io.FileWriter;
import java.io.IOException;
/****************************************************************************
 * 									ShipGUI
 * 
 * This is the GUI (View) of meShip (Lab1). It was created with the help of
 * WindowBuilder for Eclipse. Much of the structure of the code was auto
 * generated. I have moved some lines around to improve readability.
 *****************************************************************************/


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
		//Contains an Output JPanel that contains a table which uses a DefaultTableModel to model the information displayed.
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
		
/**************************************Buttons****************************************************/
		//The action-listeners and associated methods are further down the page.
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
		
/**************************************Header********************************************************/
		//The header uses JLabels with ImageIcons to add some semblence of design for the GUI.
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

		
	/**************************************Input Panel***************************************************************/
		//Contains all of the text boxes, combo boxes and buttons used in the program. 
		JPanel Input = new JPanel();
		Input.setBounds(703, 123, 271, 464);
		getContentPane().add(Input);
		Input.setLayout(null);
		
		//*******************Text Fields*****************//
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
		
		
		//*****************Labels********************//
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
		
		JLabel lblSelectShip = new JLabel("Ship");
		lblSelectShip.setBounds(10, 14, 77, 14);
		Input.add(lblSelectShip);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 57, 46, 14);
		Input.add(lblYear);
		
		
		//***************Combo Boxes***************//
		comboBoxShip = new JComboBox<String>();
		comboBoxShip.setBounds(111, 11, 150, 20);
		Input.add(comboBoxShip);
		comboBoxShip.addItem("All Ships");
		
		comboBoxYear = new JComboBox<String>();
		comboBoxYear.setBounds(111, 51, 150, 20);
		Input.add(comboBoxYear);
		comboBoxYear.addItem("All Years");
		
		//*****************Radio Buttons*************//
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(111, 78, 53, 23);
		Input.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(183, 78, 64, 23);
		Input.add(rdbtnFemale);
		
		ButtonGroup genderButtons = new ButtonGroup();
		genderButtons.add(rdbtnMale);
		genderButtons.add(rdbtnFemale);

		/**************************************Lower Panel***************************************************************/	
		//This panel is purely for the "logo" of the program.
		JPanel panel = new JPanel();
		panel.setBounds(204, 569, 489, 82);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Bottom");
		lblNewLabel_2.setBounds(130, 23, 255, 59);
		lblNewLabel_2.setIcon(new ImageIcon(ShipGUI.class.getResource("/GUI/cooltext1732865982.jpg")));
		panel.add(lblNewLabel_2);
		
		/**************************************Message TextPane***************************************************************/
		//This JTextPane is used to give the users messages as they interact with the program.
		textPane = new JTextPane();
		textPane.setBounds(713, 598, 261, 53);
		getContentPane().add(textPane);
		
		
		/******************************************Button Actions***************************************************************/
		
		/****************************Add Ship*******************************/
		//Add ship makes use of the addShip(fileName) method from the Admiral class.
		btnAddShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dtm.setNumRows(0); //Makes sure the table is empty. 
				try {
					//getFileName() defined below.
					String fileName = getFileName();
					if (fileName != null) {
						myAdmiral.addShip(fileName);
						ShipNode findShip = myAdmiral.getFlagship();
						while(findShip.getShipPtr() != myAdmiral.getFlagship()) {
							findShip = findShip.getShipPtr();
						}
						comboBoxShip.addItem(findShip.getName()); //Adds this ship to the ship comboBox.
					}
					//These catches are for users who either don't select a file or select a file 
					//that is in the wrong format (not txt, or not a properly formatted txt.
				} catch (NullPointerException np) {
					textPane.setText("No ship was added.");
				} catch (NumberFormatException nfp) {
					textPane.setText("No ship added, make sure you select a properly formatted .txt file.");
				}
			}
		});

		/****************************Display All*******************************/
		//DisplayAll makes use of the printAllConvicts from the ConvictPritner class.
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(""); 
				String shipName = (String)comboBoxShip.getSelectedItem();
				String year = (String)comboBoxYear.getSelectedItem();
				ConvictPrinter.printAllConvicts(shipName, year, dtm, myAdmiral);
			}
		});
		
		/****************************Display By Gender*******************************/
		//Uses the printByGender method from ConvictPrinter.
		btnDisplayByGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				dtm.setRowCount(0);
				String gender;
				if (rdbtnMale.isSelected()) gender = "M";
				else if (rdbtnFemale.isSelected()) gender = "F";
				else { //Gives the user a message if they don't select a gender.
					textPane.setText("Please select a gender.");
					return;
				} 
				String shipName = (String)comboBoxShip.getSelectedItem();
				String year = (String)comboBoxYear.getSelectedItem();
				ConvictPrinter.printByGender(shipName, year, gender, dtm, myAdmiral);
			}
		});
		
		/****************************Display By Age*******************************/
		//Uses the printByAge method found in ConvictPrinter
		btnDisplayByAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm.setRowCount(0);
				/*This if-else statement makes sure the user is inputing a 
				number into the age box. If they don't a message appears
				telling them why nothing happened.
				isNumeric(String) is found further on in this class.*/
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
		
		/****************************Remove Convict*******************************/
		//RemoveConvict makes use of the removeConvict method in Admiral.
		btnRemoveConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm.setNumRows(0);
				//These lines just collect data from the various inputs on the screen.
				String ship = (String)comboBoxShip.getSelectedItem();
				String year = (String)comboBoxYear.getSelectedItem();
				String age = textFieldAge.getText();
				String first = textFieldFirst.getText();
				String last = textFieldLast.getText();
				
				//The if-else statement makes sure the user doesn't try to remove a convict to all
				//ships or all years. A specific ship and specific year is required.
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
		
		/****************************Add Convict*******************************/
		//AddConvict makes use of the addConvict method in Admiral
		btnAddConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setNumRows(0);
				String ship = (String)comboBoxShip.getSelectedItem();
				String yearString = (String)comboBoxYear.getSelectedItem();
				
				//This if-else statement makes sure the user doesn't try to add a convict to multiple
				//ships or multiple years. 
				if (ship.equalsIgnoreCase("All Ships") || yearString.equalsIgnoreCase("All Years")){
					textPane.setText("Don't be cruel! Convicts can't be added to all ships or all years, no one is that bad! Please select a ship and a year.");
					return;
				} else{
					//The try-catch statement handles users that don't fill in every data field.
					try {
					int year = Integer.parseInt(yearString);
					myAdmiral.addConvict(ship, year, getConvictString());
					textPane.setText("Convict Successfully Added!");
					} catch (ArrayIndexOutOfBoundsException exception){
						textPane.setText("Unable to add Convict. Make sure all fields are filled.");
					}
				}
			}
		});
		
		/****************************Ship ComboBox*******************************/
		comboBoxShip.addActionListener(new ActionListener() {
			//This method causes the Year ComboBox to fill with the available
			//years for whatever ship is selected. If a ship isn't selected,
			//only All Years is available.
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

		/****************************Save Ship*******************************/
		//SaveShips allows the user to save whatever ship is currently selected in the Ship ComboBox.
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
	
	/*******************************************Methods************************************************/
	//getConvictString is used to create a single line of a standard form that can be read into a new convict
	//node.
	private String getConvictString(){
		String gender = "";
		if (rdbtnMale.isSelected()) gender = "M";
		else if (rdbtnFemale.isSelected()) gender = "F";
		
		String convictLine =   	gender +"/" + textFieldLast.getText() + "/" + textFieldFirst.getText() + "/" 
								+ textFieldAge.getText() + "/" + textFieldConvictedIn.getText() + "/" + textFieldSentence.getText() + "/"
								+ textFieldHome.getText() + "/" + textFieldCrime.getText() + "/" + textFieldProfession.getText();
		return convictLine;
	}

	/****************************initGUI*******************************/
	//A new Admiral is always created for a GUI.
	public void initGUI(){
		this.setVisible(true);
		this.myAdmiral = new Admiral();
	}
	
	/***************************getFileName*******************************/
	//Uses a JFileCooser to get a path, which can then be passed into an 
	//EasyReader object.
	public String getFileName() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION){
			//This message to the user will be replaced
			//by an error message immediately afterwards
			//if there is an error reading in the file.
			textPane.setText("Ship Added");
			return fc.getSelectedFile().getPath();
		}
		else {
			textPane.setText("No Ship Added");
			return null;
		}
	}
	
	/****************************saveFile*******************************/
	public void saveFile(String shipName) {
		
		textPane.setText("");
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			/*The logic of this method follows the ConvicPrinter closely.
			 * It contains nested do-while loops that ensure every single
			 * ConvictNode is read in in an order consistent with the 
			 * structure of the Linked List.
			 */
			try (FileWriter fw = new FileWriter(fc.getSelectedFile())) {
				fw.write(shipName + "\n");
				YearNode curYear = myAdmiral.getShip(shipName).getYearPtr();
				fw.write("" + curYear.getYearSailed() + "\n");

				do { //Loops through years
					GenderNode curGender = curYear.getRight();
					do {//Loops through Genders (only 2)
						if (curGender.getDown() != null) {
							ConvictNode curConv = curGender.getDown();
							do {//Loops through Convicts
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
					//Always writes "*****" before reading in a new year.
					fw.write("*****\n");
					
					//This statement makes sure that a year is printed after every 
					//set of ConvictNodes UNLESS there are no more YearNodes.
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

