/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Classes;

import java.util.StringTokenizer;

/*This is the class used to handle the manipulation of all of our 
 * various nodes.
 */

public class Admiral {
	private ShipNode flagship;
	private ShipNode currentShip;
	private int fleetSize;

	public Admiral() {

	}

	public void setFlagship(ShipNode ship) {
		this.flagship = ship;
	}

	public ShipNode getFlagship() {
		return this.flagship;
	}

	public int getSize() {
		return fleetSize;
	}

	public void addShip(String fileName) {

		EasyReader inFile = new EasyReader(fileName);
		if (inFile.bad()) {
			System.err.println("Can't open " + fileName);
			return;
		}

		String shipName = inFile.readLine();
		ShipNode newShip = new ShipNode();
		newShip.setName(shipName);
		this.fleetSize++;

		if (this.flagship == null) {
			this.flagship = newShip;
			newShip.setShipPtr(flagship);
			System.out.println("Flagship " + flagship.getName() + " Created!");
		} else {
			ShipNode cur = flagship;
			ShipNode next = flagship.getShipPtr();

			while (next != flagship) {
				cur = next;
				next = next.getShipPtr();
			}

			next.setShipPtr(newShip);
			newShip.setShipPtr(flagship);
			System.out.println("Ship Added to the Fleet!");
		}

		this.currentShip = newShip;
		
		String nextLine = inFile.readLine();
		this.addYearNode(nextLine);

		while (!inFile.eof()) {
			nextLine = inFile.readLine();
			if (nextLine.equals("*****")) {
				String seeNext = inFile.readLine();
				if (seeNext == null){
					System.out.println("*********END OF SHIP*********");
					return;
				} else this.addYearNode(seeNext);
			} else
				this.addConvict(nextLine);
		}
	}

	public void addConvict(String convictInfo) {
		
		ConvictNode newConvict = new ConvictNode();

		StringTokenizer convTokenizer = new StringTokenizer(convictInfo, "/");

		String gender = convTokenizer.nextToken();
		newConvict.setLastName(convTokenizer.nextToken());
		newConvict.setFirstName(convTokenizer.nextToken());
		newConvict.setAge(convTokenizer.nextToken());
		newConvict.setWhereConvicted(convTokenizer.nextToken());
		newConvict.setJailSentence(convTokenizer.nextToken());
		newConvict.setHomeAdd(convTokenizer.nextToken());
		newConvict.setCrime(convTokenizer.nextToken());
		newConvict.setProfession(convTokenizer.nextToken());

		GenderNode currentGender = this.currentShip.getCurrentYear().getRight();
		if (!gender.equals("M"))
			currentGender = currentGender.getRight();

		if (currentGender.getDown() == null) {
			currentGender.setDown(newConvict);
			newConvict.setNext(newConvict);
		} else {
			ConvictNode prev = currentGender.getDown();
			ConvictNode next = prev.getNext();

			while (next != currentGender.getDown()) {
				prev = next;
				next = next.getNext();
			}
			prev.setNext(newConvict);
			newConvict.setNext(currentGender.getDown());
			System.out.println(currentGender.getGender() + " Convict " + newConvict.getFirstName() + " On Board!");
			System.out.println();
		}
	}

	public void addYearNode(String year) {
		StringTokenizer tooManySpaces = new StringTokenizer(year);
		String realYear = tooManySpaces.nextToken();
		YearNode newYear = new YearNode(Integer.parseInt(realYear));

		if (this.currentShip.getYearPtr() == null) {
			this.currentShip.setYearPtr(newYear);
			newYear.setDown(newYear);
		} else {
			YearNode prev = this.currentShip.getYearPtr();
			YearNode next = prev.getDown();
			while (next != this.currentShip.getYearPtr()) {
				prev = next;
				next = next.getDown();
			}
			
			prev.setDown(newYear);
			newYear.setDown(this.currentShip.getYearPtr());
		}

		this.currentShip.setCurrentYear(newYear);
		
		GenderNode femaleNode = new GenderNode('F');
		GenderNode maleNode = new GenderNode('M');
		
		maleNode.setRight(femaleNode);
		newYear.setRight(maleNode);
	}


	public ShipNode getCurrentShip(){
		return this.currentShip;
	}
	
}