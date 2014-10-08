package GUI;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import Classes.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;;

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
	
	public ShipGUI(){
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setSize(1000, 700);
		
		JPanel Output = new JPanel();
		Output.setBounds(194, 104, 499, 483);
		getContentPane().setLayout(null);
		getContentPane().add(Output);
		
		Object columnNames[] = {"Last", "First", "Age", "Convicted", "Sentence", "Home", "Crime", "Profession", "Gender", "Year", "Ship"};
		
		dtm = new DefaultTableModel(columnNames, 0);
		Output.setLayout(null);
		
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
		Buttons.setBounds(55, 123, 129, 464);
		Buttons.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAddShip = new JButton("Add Ship");
		btnAddShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myAdmiral.addShip(getFileName());
				comboBoxShip.addItem(myAdmiral.getCurrentShip().getName());
			}
		});
		Buttons.add(btnAddShip);
		
		JButton btnDisplayByAge = new JButton("Display by Age");
		
		Buttons.add(btnDisplayByAge);
		
		
		JButton btnDisplayByGender = new JButton("Display by Gender");
		Buttons.add(btnDisplayByGender);
		

		JButton btnDisplayAll = new JButton("Display All");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printConvicts((String)comboBoxShip.getSelectedItem(), (String)comboBoxYear.getSelectedItem());
			}
		});
		Buttons.add(btnDisplayAll);
		
		
		JButton btnAddConvict = new JButton("Add Convict");
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
		
		comboBoxYear = new JComboBox();
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
		
		btnDisplayByGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				printByGender();
			}
		});
		
		btnDisplayByAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm.setRowCount(0);
				printByAge();
			}		
		});
		
		
		btnRemoveConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ship = (String)comboBoxShip.getSelectedItem();
				String year = (String)comboBoxYear.getSelectedItem();
				if (ship.equalsIgnoreCase("All Ships") || year.equalsIgnoreCase("All Years")) return;
				else {
					int yearInt = Integer.parseInt(year);
					myAdmiral.removeConvict(ship, yearInt, getConvictString());
				}
			}
		});
		
		btnAddConvict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ship = (String)comboBoxShip.getSelectedItem();
				String yearString = (String)comboBoxYear.getSelectedItem();
				
				if (ship.equalsIgnoreCase("All Ships") || yearString.equalsIgnoreCase("All Years")){
					return;
				} else{
					
					int year = Integer.parseInt(yearString);
					myAdmiral.addConvict(ship, year, getConvictString());
					comboBoxShip.addItem(myAdmiral.getCurrentShip().getName());
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
		
		initGUI();
	}
	
	public static boolean isNumeric(String str)  {  
	  try  {  
	    int i = Integer.parseInt(str);  
	  }  catch(NumberFormatException nfe)  {  
	    return false;  
	  }  
	  return true;  
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
		if (returnVal == JFileChooser.APPROVE_OPTION)
			return fc.getSelectedFile().getPath();
		else
			return null;
	}
	
	private void printConvicts(String shipName, String year){
		
		dtm.setRowCount(0);
		
		if (shipName.equalsIgnoreCase("All Ships")){
			if (year.equalsIgnoreCase("All Years")){
				ShipNode curShip = myAdmiral.getFlagship();
				do {
					YearNode curYear = curShip.getYearPtr();
					do {
						GenderNode curGender = curYear.getRight();
						do{
							if (curGender.getDown() != null){
							ConvictNode curConv = curGender.getDown();
								do{
									dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
											curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), curShip.getName()});
									curConv = curConv.getNext();
								} while(curConv != curGender.getDown());
							}
							curGender = curGender.getRight();
							
						} while(curGender!= null);
						curYear = curYear.getDown();
						
					} while(curYear != curShip.getYearPtr());
					curShip = curShip.getShipPtr();
					
				} while(curShip != myAdmiral.getFlagship());
			} else {
				ShipNode curShip = myAdmiral.getFlagship();
				do {
					YearNode curYear = myAdmiral.getYear(curShip.getName(), Integer.parseInt(year));
						GenderNode curGender = curYear.getRight();
						do{
							if (curGender.getDown() != null){
							ConvictNode curConv = curGender.getDown();
								do{
									dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
											curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), curShip.getName()});
									curConv = curConv.getNext();
								} while(curConv != curGender.getDown());
							}
							curGender = curGender.getRight();
							
						} while(curGender!= null);
					curShip = curShip.getShipPtr();
					
				} while(curShip != myAdmiral.getFlagship());
			}
			
		}
		else {
			if (!year.equalsIgnoreCase("All Years")){
				GenderNode curGender = myAdmiral.getGender(shipName, Integer.parseInt(year), "M");
				do{
					if (curGender.getDown() != null){
					ConvictNode curConv = curGender.getDown();
						do{
							dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
									curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + year, shipName});
							curConv = curConv.getNext();
						} while(curConv != curGender.getDown());
					}
					curGender = curGender.getRight();
					
				} while(curGender!= null);
			} else {
				YearNode curYear = myAdmiral.getShip(shipName).getYearPtr();
				do {
					GenderNode curGender = curYear.getRight();
					do{
						if (curGender.getDown() != null){
						ConvictNode curConv = curGender.getDown();
							do{
								dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
										curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), shipName});
								curConv = curConv.getNext();
							} while(curConv != curGender.getDown());
						}
						curGender = curGender.getRight();
						
					} while(curGender!= null);
					curYear = curYear.getDown();
					
				} while(curYear != myAdmiral.getShip(shipName).getYearPtr());
			}
		}
		
	}
	private void printByAge(){
		if (isNumeric(textFieldAge.getText())){
			String age = textFieldAge.getText();
			String shipName = (String)comboBoxShip.getSelectedItem();
			String year = (String)comboBoxYear.getSelectedItem();
			
			if (shipName.equalsIgnoreCase("All Ships")){
				if (year.equalsIgnoreCase("All Years")){
					ShipNode curShip = myAdmiral.getFlagship();
					do {
						YearNode curYear = curShip.getYearPtr();
						do {
							GenderNode curGender = curYear.getRight();
							do{
								if (curGender.getDown() != null){
								ConvictNode curConv = curGender.getDown();
									do{
										if (age.equalsIgnoreCase(curConv.getAge())){
										dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
												curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), curShip.getName()});
										}
										curConv = curConv.getNext();
									} while(curConv != curGender.getDown());
								}
								curGender = curGender.getRight();
								
							} while(curGender!= null);
							curYear = curYear.getDown();
							
						} while(curYear != curShip.getYearPtr());
						curShip = curShip.getShipPtr();
						
					} while(curShip != myAdmiral.getFlagship());
				} else {
					ShipNode curShip = myAdmiral.getFlagship();
					do {
						YearNode curYear = myAdmiral.getYear(curShip.getName(), Integer.parseInt(year));
							GenderNode curGender = curYear.getRight();
							do{
								if (curGender.getDown() != null){
								ConvictNode curConv = curGender.getDown();
									do{
										if (age.equalsIgnoreCase(curConv.getAge())){
											dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
													curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), curShip.getName()});
											}
										curConv = curConv.getNext();
									} while(curConv != curGender.getDown());
								}
								curGender = curGender.getRight();
								
							} while(curGender!= null);
						curShip = curShip.getShipPtr();
						
					} while(curShip != myAdmiral.getFlagship());
				}
				
			}
			else {
				if (!year.equalsIgnoreCase("All Years")){
					GenderNode curGender = myAdmiral.getGender(shipName, Integer.parseInt(year), "M");
					do{
						if (curGender.getDown() != null){
						ConvictNode curConv = curGender.getDown();
							do{
								if (age.equalsIgnoreCase(curConv.getAge())){
									dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
											curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), year, shipName});
									}
								curConv = curConv.getNext();
							} while(curConv != curGender.getDown());
						}
						curGender = curGender.getRight();
						
					} while(curGender!= null);
				} else {
					YearNode curYear = myAdmiral.getShip(shipName).getYearPtr();
					do {
						GenderNode curGender = curYear.getRight();
						do{
							if (curGender.getDown() != null){
							ConvictNode curConv = curGender.getDown();
								do{
									if (age.equalsIgnoreCase(curConv.getAge())){
										dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
												curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), shipName});
										}
									curConv = curConv.getNext();
								} while(curConv != curGender.getDown());
							}
							curGender = curGender.getRight();
							
						} while(curGender!= null);
						curYear = curYear.getDown();
						
					} while(curYear != myAdmiral.getShip(shipName).getYearPtr());
				}
			}
			
		} else System.out.println("Age is not a number."); 
	}
	
	private void printByGender(){
		String gender;
		if (rdbtnMale.isSelected()) gender = "M";
		else if (rdbtnFemale.isSelected()) gender = "F";
		else return;
		
			String shipName = (String)comboBoxShip.getSelectedItem();
			String year = (String)comboBoxYear.getSelectedItem();
			
			if (shipName.equalsIgnoreCase("All Ships")){
				if (year.equalsIgnoreCase("All Years")){
					ShipNode curShip = myAdmiral.getFlagship();
					do {
						YearNode curYear = curShip.getYearPtr();
						do {
							GenderNode curGender = curYear.getRight();
							if (gender.equals("F")) curGender = curGender.getRight();
							if (curGender.getDown() != null){
								ConvictNode curConv = curGender.getDown();
								do{
									dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
												curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), curShip.getName()});
									curConv = curConv.getNext();
							} while(curConv != curGender.getDown());
							}
							curYear = curYear.getDown();
						} while(curYear != curShip.getYearPtr());
						curShip = curShip.getShipPtr();
					} while(curShip != myAdmiral.getFlagship());
				} else {
					ShipNode curShip = myAdmiral.getFlagship();
					do {
						YearNode curYear = myAdmiral.getYear(curShip.getName(), Integer.parseInt(year));
							GenderNode curGender = curYear.getRight();
							if (gender.equalsIgnoreCase("F"))curGender = curGender.getRight();
							
								if (curGender.getDown() != null){
								ConvictNode curConv = curGender.getDown();
									do{
											dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
													curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), curShip.getName()});
										curConv = curConv.getNext();
									} while(curConv != curGender.getDown());
								}
						curShip = curShip.getShipPtr();
						} while(curShip != myAdmiral.getFlagship());
					} 
				}else {
					if (!year.equalsIgnoreCase("All Years")){
						GenderNode curGender = myAdmiral.getGender(shipName, Integer.parseInt(year), "M");
						if(gender.equalsIgnoreCase("F")) curGender = curGender.getRight();
							if (curGender.getDown() != null){
							ConvictNode curConv = curGender.getDown();
								do{
										dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
												curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), year, shipName});
									curConv = curConv.getNext();
								} while(curConv != curGender.getDown());
							}
							curGender = curGender.getRight();
				} else {
					YearNode curYear = myAdmiral.getShip(shipName).getYearPtr();
					do {
						GenderNode curGender = curYear.getRight();
						if(gender.equalsIgnoreCase("F")) curGender = curGender.getRight();
							if (curGender.getDown() != null){
								ConvictNode curConv = curGender.getDown();
								do{
										dtm.addRow(new Object[]{curConv.getLastName(), curConv.getFirstName(), curConv.getAge(), curConv.getWhereConvicted(), curConv.getJailSentence(), 
												curConv.getHomeAdd(), curConv.getCrime(), curConv.getProfession(), curGender.getGender(), "" + curYear.getYearSailed(), shipName});
									curConv = curConv.getNext();
								} while(curConv != curGender.getDown());
							}
						curYear = curYear.getDown();
					} while(curYear != myAdmiral.getShip(shipName).getYearPtr());
				}
			}
	}
}

