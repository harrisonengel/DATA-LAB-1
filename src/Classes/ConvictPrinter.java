package Classes;


import javax.swing.table.*;

public class ConvictPrinter {

	private ConvictPrinter(){
		
	}
	
	public static void printAllConvicts(String shipName, String year,
			DefaultTableModel dtm, Admiral myAdmiral) {

		dtm.setRowCount(0);

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
