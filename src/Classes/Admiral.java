/*******************************************************************/
/*   Program Name:     Lab 1    meShip                             */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Classes;

import java.util.StringTokenizer;

/*************************************************************************
 * 								Admiral
 * This class is for the Admiral object which is used to
 * manipulate the various Nodes and keep track of the head node (flagship).
 *************************************************************************/

public class Admiral {
	//The flaship ShipNode is the head node in our linked list
	private ShipNode flagship;

	public Admiral() {
	}
	
	//Sets the flagship to a specific ShipNode
	public void setFlagship(ShipNode ship) {
		this.flagship = ship;
	}

	//Returns the Flagship of an Admiral. It is the method by which the whole
	//linked list is accessed.
	public ShipNode getFlagship() {
		return this.flagship;
	}

	/************************************************************************
	 * 								AddShip
	 * addShip is used to read in a file using an EasyReader(inFile).
	 * It creates a ShipNode from the first line of the file, and then inserts
	 * that ShipNode into the current Linked List.
	 * Then, it parses through the rest of the document making calls to 
	 * addYearNode and addConvict depending one which line it is on.
	 * After calling this method, an entire file is read in and the entire
	 * Linked List created from it.
	 ***************************************************************************/
	public void addShip(String fileName) {
		
		//See EasyReader class for more information.
		EasyReader inFile = new EasyReader(fileName);
		if (inFile.bad()) {
			System.err.println("Can't open " + fileName);
			return;
		}
		
		//Create a ship from the first line
		String shipName = inFile.readLine();
		ShipNode newShip = new ShipNode();
		newShip.setName(shipName);

		//Start at the flagship, then move down the list until we find where the
		//new ship goes.
		if (this.flagship == null) {
			this.flagship = newShip;
			newShip.setShipPtr(flagship);

		} else {
			ShipNode cur = flagship;
			ShipNode next = flagship.getShipPtr();

			while (next != flagship) {
				cur = next;
				next = next.getShipPtr();
			}

			cur.setShipPtr(newShip);
			newShip.setShipPtr(flagship);

		}
		
	/*************************************************
	 * This final part is responsible for looping through
	 * the remainder of the file, adding year nodes, gender
	 * nodes and convict nodes as it goes.
	 * Both addYear and addConvict handle the creation
	 * and placement of their respective node
	 ***************************************************/
		String nextLine = inFile.readLine();
		String currentYear = nextLine;
		this.addYearNode(shipName, currentYear);

		while (!inFile.eof()) {
			
			nextLine = inFile.readLine();
			if (nextLine.startsWith("*****")) {
				String seeNext = inFile.readLine();
				if (seeNext == null) {
					return;
				} else {
					this.addYearNode(shipName, seeNext);
					currentYear = seeNext;
				}
			} else
				this.addConvict(shipName, Integer.parseInt(currentYear),nextLine);
		}
	} //End of method addShip

	/***********************************************************************
	 * 								Add Convict
	 * The addConvict method takes the name of the ship, number of the year,
	 * and the string containing info about the convict in the exact form
	 * it appears as lines in the standard .txt file used in this program.
	 ************************************************************************/
	public void addConvict(String shipName, int year, String convictInfo) {
		
		
		ConvictNode newConvict = new ConvictNode(convictInfo);
		
		//The StringTokenizer is used to grab the first element of the convict info,
		//even if someone "accidentally" puts a / delimiter before the Gender (big no-no)
		
		StringTokenizer convTokenizer = new StringTokenizer(convictInfo, "/");
		String gender = convTokenizer.nextToken();
		
		//Current gender then finds the GenderNode this Convict belongs under.
		//It is explained in further detail later on.
		GenderNode currentGender = getGender(shipName, year, gender);
		
		//This if statement checks for the case that this convict is the first
		//convict belonging to the GenderNode.
		if (currentGender.getDown() == null) {
			currentGender.setDown(newConvict);
			newConvict.setNext(newConvict);
		} else {
			/*
			 * The following while loop is used to find the last convict
			 * in the Linked List, which will have a pointer to the first 
			 * ConvictNode (currentGender.getDown()) which acts as our
			 * head node. If one wanted to sort the convicts in any way
			 * as they entered the list, this would be the place to do it.
			*/
			ConvictNode cur = currentGender.getDown();
			while (cur.getNext() != currentGender.getDown()){

				cur = cur.getNext();
			} 
			cur.setNext(newConvict);
			newConvict.setNext(currentGender.getDown());

		}
	}

	/**********************************************************************
	 * 								addYearNode
	 * addYearNode takes the name of the ship it belongs to as well as the 
	 * year it represents. It is then placed into the list. Note it is NOT
	 * automatically sorted into numeric order. It is up to the creator 
	 * of the file to order years properly if thsi concerns them.
	 *********************************************************************/
	public void addYearNode(String shipName, String year) {
		
		ShipNode findShip = this.getShip(shipName);
		
		//The StringTokenizer is used to account for the occasional
		//Year line in a file that contains extra spaces after the year.
		StringTokenizer tooManySpaces = new StringTokenizer(year);
		String realYear = tooManySpaces.nextToken();
		findShip.addAvailableYear(Integer.parseInt(realYear));
		YearNode newYear = new YearNode(Integer.parseInt(realYear));

		//This first if case accounts for the very first YearNode belonging
		//to a specific ship.
		if (findShip.getYearPtr() == null) {
			findShip.setYearPtr(newYear);
			newYear.setDown(newYear);
		} else { 
			
			//The while loop finds the last YearNode in the specified ship. 
			//It knows which is the last because the last YearNode will point
			//to the YearNode directly pointed to by the Ship.
			YearNode curYear = findShip.getYearPtr();
			while (curYear.getDown() != findShip.getYearPtr()) {
				curYear = curYear.getDown();
			}
			curYear.setDown(newYear);
			newYear.setDown(findShip.getYearPtr());
		}
		
		//Male and Female GenderNodes are automatically created
		//containing null ConvictNode Pointers. The newYear node 
		//is then set to point to a new male node.
		GenderNode femaleNode = new GenderNode('F');
		GenderNode maleNode = new GenderNode('M');

		maleNode.setRight(femaleNode);
		newYear.setRight(maleNode);
	}

	/*************************************************************************
	 * 								removeConvict
	 * This method is used to remove a ConvictNode from the specified ship and year
	 * based on Age, First Name, and Last name.
	 **************************************************************************/
	public void removeConvict(String shipName, String year, String age,
			String firstName, String lastName) {
		
		
		YearNode findYear = getYear(shipName, Integer.parseInt(year));
		GenderNode curGender = findYear.getRight(); 
		
		//Loops through the linked lists on both Male and Female gender Nodes
		//If there were both a male and female of the same name and age it will
		//remove both.
		
		for (int i=0; i<2; i++) {
			//This method requires that three consecutive nodes are kept track of
			//to remove the convict node by pla
			ConvictNode prevNode = curGender.getDown();
			ConvictNode curNode = prevNode.getNext();
			ConvictNode nextNode = curNode.getNext();
			while (true) {
				prevNode = prevNode.getNext();
				curNode = curNode.getNext();
				nextNode = nextNode.getNext();
				//exit the loop when our pointers get back to the start.
				if (prevNode == curGender.getDown())
					break;
				/*The Node to remove is found when its age, first name, and last name
				match what we are looking for. The next if statement checks to see
				if we happened to remove the head node. If this is the case,
				it resets the ConvictNode pointer of the appropriate gender to 
				the next ConvictNode.*/
				if (curNode.getAge().equalsIgnoreCase(age)
						&& curNode.getFirstName().equalsIgnoreCase(firstName)
						&& curNode.getLastName().equalsIgnoreCase(lastName)) {
					prevNode.setNext(nextNode);
					if (curNode == curGender.getDown())
						curGender.setDown(nextNode);
				}
			}
			curGender = curGender.getRight();
		} 
	}

	/******************************************************************************
	 * 							getYear
	 * This method returns a specific YearNode based on a ship name and the year
	 * it represents.		
	 *******************************************************************************/

	public YearNode getYear(String shipName, int i) {

		YearNode findYear = getShip(shipName).getYearPtr();
		while (findYear.getYearSailed() != i) {
			findYear = findYear.getDown();
		}
		return findYear;
	}
	/******************************************************************************
	 * 							getShip
	 * This method returns a specific ShipNode based on the name of the ship you are
	 * looking for.		
	 *******************************************************************************/
	
	public ShipNode getShip(String shipName) {
		ShipNode findShip = this.getFlagship();
		while (!findShip.getName().equalsIgnoreCase(shipName)) {
			findShip = findShip.getShipPtr();
		}
		return findShip;
	}
	
	/******************************************************************************
	 * 							getGender
	 * This method returns a specific GenderNode based on a ship name, the year, and
	 * the gender.
	 *******************************************************************************/

	public GenderNode getGender(String shipName, int i, String gender) {
		YearNode curYear = getYear(shipName, i);
		if (gender.startsWith("M")){
			return curYear.getRight();
		}
		else{ //if the gender isn't male then it must be female (politically incorrect, i know). 
			return curYear.getRight().getRight();
		}
			
	}
}