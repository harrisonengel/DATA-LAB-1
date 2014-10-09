package Classes;

import javax.swing.table.*;

/************************************************************************************
 * 								Convict Printer
 * PLEASE READ
 * This is a special object used to print results to a table. Each of the four following
 * methods are very similar, with only minor variations depending on the situation,
 * and I will therefore NOT put comments in all of them.
 * 
 * They all work generally the same way. Based on what options are selected the method
 * finds a specific group of nested do-while loops. Every linked-list that will have
 * its elements traversed requires a loop. For example, if we are to print out all convicts
 * from all years on a ship, there needs to be a loop for the YearNodes (all years), Gender
 * Nodes(both genders), and ConvictNodes (all convicts), resulting in a 3 do-while loops,
 * with the highest level (YearNodes) as the outermost loop and lowest Level (ConvictNodes) as the
 * innermost loop. Each convict in this inner-most group that meets the criteria is then
 * printed to a DefaultTableModel, resulting in it being displayed in the associated table.
 ************************************************************************************/
public class ConvictPrinter {

	private ConvictPrinter(){
		
	}
	
	public static void printAllConvicts(String shipName, String year,
			DefaultTableModel dtm, Admiral myAdmiral) {
		
		dtm.setRowCount(0);//Makes sure the table is clear before we add to it.
		
		if (shipName.equalsIgnoreCase("All Ships")) {
			if (year.equalsIgnoreCase("All Years")) {
				ShipNode curShip = myAdmiral.getFlagship();
				do { //Loop through all ships
					YearNode curYear = curShip.getYearPtr();
					do {//Loop through all Years
						GenderNode curGender = curYear.getRight();
						do {//Loop through all Genders. There are only two possible genders
							//so a do-while loop isn't necessary. I built it using a do-while loop
							//becauseI wanted to keep the logical structure are uniform as possible.
							if (curGender.getDown() != null) {
								ConvictNode curConv = curGender.getDown();
								do { //Loop through all Convicts
									//This next chunk of code prints all of the information about each convict
									//to the DefaultTableModel dtm.
									dtm.addRow(new Object[] {
											curConv.getLastName(),
											curConv.getFirstName(),
											curConv.getAge(),
											curConv.getWhereConvicted(),
											curConv.getJailSentence(),
											curConv.getHomeAdd(),
											curConv.getCrime(),
											curConv.getProfession(),
											curGender.getGender(),
											"" + curYear.getYearSailed(),
											curShip.getName() });
									curConv = curConv.getNext();
								} while (curConv != curGender.getDown());
							}
							curGender = curGender.getRight();

						} while (curGender != null);
						curYear = curYear.getDown();

					} while (curYear != curShip.getYearPtr());
					curShip = curShip.getShipPtr();

				} while (curShip != myAdmiral.getFlagship());
			} else {
				/*IMPORTANT!!
				 * This else statement is NOT reachable with the current program as currently,
				 * if All Ships is selected, the only option for years is All Years.
				 * However, I left it in here to show how one could quickly convert the
				 * program to be able to print out by allowing the user to input any year
				 * they desire instead of giving them a drop down to select from.
				 */
				ShipNode curShip = myAdmiral.getFlagship();
				do {
					YearNode curYear = myAdmiral.getYear(curShip.getName(),
							Integer.parseInt(year));
					GenderNode curGender = curYear.getRight();
					do {
						if (curGender.getDown() != null) {
							ConvictNode curConv = curGender.getDown();
							do {
								dtm.addRow(new Object[] {
										curConv.getLastName(),
										curConv.getFirstName(),
										curConv.getAge(),
										curConv.getWhereConvicted(),
										curConv.getJailSentence(),
										curConv.getHomeAdd(),
										curConv.getCrime(),
										curConv.getProfession(),
										curGender.getGender(),
										"" + curYear.getYearSailed(),
										curShip.getName() });
								curConv = curConv.getNext();
							} while (curConv != curGender.getDown());
						}
						curGender = curGender.getRight();

					} while (curGender != null);
					curShip = curShip.getShipPtr();

				} while (curShip != myAdmiral.getFlagship());
			}

		} else {
			if (!year.equalsIgnoreCase("All Years")) {
				GenderNode curGender = myAdmiral.getGender(shipName,
						Integer.parseInt(year), "M");
				do {
					if (curGender.getDown() != null) {
						ConvictNode curConv = curGender.getDown();
						do {
							dtm.addRow(new Object[] { curConv.getLastName(),
									curConv.getFirstName(), curConv.getAge(),
									curConv.getWhereConvicted(),
									curConv.getJailSentence(),
									curConv.getHomeAdd(), curConv.getCrime(),
									curConv.getProfession(),
									curGender.getGender(), "" + year, shipName });
							curConv = curConv.getNext();
						} while (curConv != curGender.getDown());
					}
					curGender = curGender.getRight();

				} while (curGender != null);
			} else {
				
				YearNode curYear = myAdmiral.getShip(shipName).getYearPtr();
				do {
					GenderNode curGender = curYear.getRight();
					do {
						if (curGender.getDown() != null) {
							ConvictNode curConv = curGender.getDown();
							do {
								dtm.addRow(new Object[] {
										curConv.getLastName(),
										curConv.getFirstName(),
										curConv.getAge(),
										curConv.getWhereConvicted(),
										curConv.getJailSentence(),
										curConv.getHomeAdd(),
										curConv.getCrime(),
										curConv.getProfession(),
										curGender.getGender(),
										"" + curYear.getYearSailed(), shipName });
								curConv = curConv.getNext();
							} while (curConv != curGender.getDown());
						}
						curGender = curGender.getRight();

					} while (curGender != null);
					curYear = curYear.getDown();

				} while (curYear != myAdmiral.getShip(shipName).getYearPtr());
			}
		}

	}

	public static void printByGender(String shipName, String year, String gender,
			DefaultTableModel dtm, Admiral myAdmiral) {

		if (shipName.equalsIgnoreCase("All Ships")) {
			if (year.equalsIgnoreCase("All Years")) {
				ShipNode curShip = myAdmiral.getFlagship();
				do {
					YearNode curYear = curShip.getYearPtr();
					do {
						GenderNode curGender = curYear.getRight();
						if (gender.equals("F"))
							curGender = curGender.getRight();
						if (curGender.getDown() != null) {
							ConvictNode curConv = curGender.getDown();
							do {
								dtm.addRow(new Object[] {
										curConv.getLastName(),
										curConv.getFirstName(),
										curConv.getAge(),
										curConv.getWhereConvicted(),
										curConv.getJailSentence(),
										curConv.getHomeAdd(),
										curConv.getCrime(),
										curConv.getProfession(),
										curGender.getGender(),
										"" + curYear.getYearSailed(),
										curShip.getName() });
								curConv = curConv.getNext();
							} while (curConv != curGender.getDown());
						}
						curYear = curYear.getDown();
					} while (curYear != curShip.getYearPtr());
					curShip = curShip.getShipPtr();
				} while (curShip != myAdmiral.getFlagship());
			} else {
				ShipNode curShip = myAdmiral.getFlagship();
				do {
					YearNode curYear = myAdmiral.getYear(curShip.getName(),
							Integer.parseInt(year));
					GenderNode curGender = curYear.getRight();
					if (gender.equalsIgnoreCase("F"))
						curGender = curGender.getRight();

					if (curGender.getDown() != null) {
						ConvictNode curConv = curGender.getDown();
						do {
							dtm.addRow(new Object[] { curConv.getLastName(),
									curConv.getFirstName(), curConv.getAge(),
									curConv.getWhereConvicted(),
									curConv.getJailSentence(),
									curConv.getHomeAdd(), curConv.getCrime(),
									curConv.getProfession(),
									curGender.getGender(),
									"" + curYear.getYearSailed(),
									curShip.getName() });
							curConv = curConv.getNext();
						} while (curConv != curGender.getDown());
					}
					curShip = curShip.getShipPtr();
				} while (curShip != myAdmiral.getFlagship());
			}
		} else {
			if (!year.equalsIgnoreCase("All Years")) {
				GenderNode curGender = myAdmiral.getGender(shipName,
						Integer.parseInt(year), "M");
				if (gender.equalsIgnoreCase("F"))
					curGender = curGender.getRight();
				if (curGender.getDown() != null) {
					ConvictNode curConv = curGender.getDown();
					do {
						dtm.addRow(new Object[] { curConv.getLastName(),
								curConv.getFirstName(), curConv.getAge(),
								curConv.getWhereConvicted(),
								curConv.getJailSentence(),
								curConv.getHomeAdd(), curConv.getCrime(),
								curConv.getProfession(), curGender.getGender(),
								year, shipName });
						curConv = curConv.getNext();
					} while (curConv != curGender.getDown());
				}
				curGender = curGender.getRight();
			} else {
				YearNode curYear = myAdmiral.getShip(shipName).getYearPtr();
				do {
					GenderNode curGender = curYear.getRight();
					if (gender.equalsIgnoreCase("F"))
						curGender = curGender.getRight();
					if (curGender.getDown() != null) {
						ConvictNode curConv = curGender.getDown();
						do {
							dtm.addRow(new Object[] { curConv.getLastName(),
									curConv.getFirstName(), curConv.getAge(),
									curConv.getWhereConvicted(),
									curConv.getJailSentence(),
									curConv.getHomeAdd(), curConv.getCrime(),
									curConv.getProfession(),
									curGender.getGender(),
									"" + curYear.getYearSailed(), shipName });
							curConv = curConv.getNext();
						} while (curConv != curGender.getDown());
					}
					curYear = curYear.getDown();
				} while (curYear != myAdmiral.getShip(shipName).getYearPtr());
			}
		}
	}
	
	public static void printByAge(String shipName, String year, String age,
			DefaultTableModel dtm, Admiral myAdmiral) {
		if (isNumeric(age)) {

			if (shipName.equalsIgnoreCase("All Ships")) {
				if (year.equalsIgnoreCase("All Years")) {
					ShipNode curShip = myAdmiral.getFlagship();
					do {
						YearNode curYear = curShip.getYearPtr();
						do {
							GenderNode curGender = curYear.getRight();
							do {
								if (curGender.getDown() != null) {
									ConvictNode curConv = curGender.getDown();
									do {
										if (age.equalsIgnoreCase(curConv
												.getAge())) {
											dtm.addRow(new Object[] {
													curConv.getLastName(),
													curConv.getFirstName(),
													curConv.getAge(),
													curConv.getWhereConvicted(),
													curConv.getJailSentence(),
													curConv.getHomeAdd(),
													curConv.getCrime(),
													curConv.getProfession(),
													curGender.getGender(),
													""
															+ curYear
																	.getYearSailed(),
													curShip.getName() });
										}
										curConv = curConv.getNext();
									} while (curConv != curGender.getDown());
								}
								curGender = curGender.getRight();

							} while (curGender != null);
							curYear = curYear.getDown();

						} while (curYear != curShip.getYearPtr());
						curShip = curShip.getShipPtr();

					} while (curShip != myAdmiral.getFlagship());
				} else {
					ShipNode curShip = myAdmiral.getFlagship();
					do {
						YearNode curYear = myAdmiral.getYear(curShip.getName(),
								Integer.parseInt(year));
						GenderNode curGender = curYear.getRight();
						do {
							if (curGender.getDown() != null) {
								ConvictNode curConv = curGender.getDown();
								do {
									if (age.equalsIgnoreCase(curConv.getAge())) {
										dtm.addRow(new Object[] {
												curConv.getLastName(),
												curConv.getFirstName(),
												curConv.getAge(),
												curConv.getWhereConvicted(),
												curConv.getJailSentence(),
												curConv.getHomeAdd(),
												curConv.getCrime(),
												curConv.getProfession(),
												curGender.getGender(),
												"" + curYear.getYearSailed(),
												curShip.getName() });
									}
									curConv = curConv.getNext();
								} while (curConv != curGender.getDown());
							}
							curGender = curGender.getRight();

						} while (curGender != null);
						curShip = curShip.getShipPtr();

					} while (curShip != myAdmiral.getFlagship());
				}

			} else {
				if (!year.equalsIgnoreCase("All Years")) {
					GenderNode curGender = myAdmiral.getGender(shipName,
							Integer.parseInt(year), "M");
					do {
						if (curGender.getDown() != null) {
							ConvictNode curConv = curGender.getDown();
							do {
								if (age.equalsIgnoreCase(curConv.getAge())) {
									dtm.addRow(new Object[] {
											curConv.getLastName(),
											curConv.getFirstName(),
											curConv.getAge(),
											curConv.getWhereConvicted(),
											curConv.getJailSentence(),
											curConv.getHomeAdd(),
											curConv.getCrime(),
											curConv.getProfession(),
											curGender.getGender(), year,
											shipName });
								}
								curConv = curConv.getNext();
							} while (curConv != curGender.getDown());
						}
						curGender = curGender.getRight();

					} while (curGender != null);
				} else {
					YearNode curYear = myAdmiral.getShip(shipName).getYearPtr();
					do {
						GenderNode curGender = curYear.getRight();
						do {
							if (curGender.getDown() != null) {
								ConvictNode curConv = curGender.getDown();
								do {
									if (age.equalsIgnoreCase(curConv.getAge())) {
										dtm.addRow(new Object[] {
												curConv.getLastName(),
												curConv.getFirstName(),
												curConv.getAge(),
												curConv.getWhereConvicted(),
												curConv.getJailSentence(),
												curConv.getHomeAdd(),
												curConv.getCrime(),
												curConv.getProfession(),
												curGender.getGender(),
												"" + curYear.getYearSailed(),
												shipName });
									}
									curConv = curConv.getNext();
								} while (curConv != curGender.getDown());
							}
							curGender = curGender.getRight();

						} while (curGender != null);
						curYear = curYear.getDown();

					} while (curYear != myAdmiral.getShip(shipName)
							.getYearPtr());
				}
			}

		} else
			System.out.println("Age is not a number.");
	}
	
	public static boolean isNumeric(String str) { //Borrowed from Stack Overflow answer by Jimmy T. 
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
