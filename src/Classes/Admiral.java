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
import java.util.ArrayList;

/*************************************************************************
 * Admiral Class - This class is for the Admiral object which is used to
 * manipulate the various Nodes and keep track of the head node.
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
	 * year it represents. It is then placed into the list 
	 *********************************************************************/
	public void addYearNode(String shipName, String year) {
		
		ShipNode findShip = this.getShip(shipName);
		
		StringTokenizer tooManySpaces = new StringTokenizer(year);
		String realYear = tooManySpaces.nextToken();
		findShip.addAvailableYear(Integer.parseInt(realYear));
		YearNode newYear = new YearNode(Integer.parseInt(realYear));

		if (findShip.getYearPtr() == null) {
			findShip.setYearPtr(newYear);
			newYear.setDown(newYear);
		} else {
			YearNode curYear = findShip.getYearPtr();

			while (curYear.getDown() != findShip.getYearPtr()) {
				curYear = curYear.getDown();
			}
			curYear.setDown(newYear);
			newYear.setDown(findShip.getYearPtr());
		}

		GenderNode femaleNode = new GenderNode('F');
		GenderNode maleNode = new GenderNode('M');

		maleNode.setRight(femaleNode);
		newYear.setRight(maleNode);
	}

	public void removeConvict(String shipName, String year, String age,
			String firstName, String lastName) {

		YearNode findYear = getYear(shipName, Integer.parseInt(year));
		GenderNode curGender = findYear.getRight();
		do {
			ConvictNode prevNode = curGender.getDown();
			ConvictNode curNode = prevNode.getNext();
			ConvictNode nextNode = curNode.getNext();
			while (true) {
				prevNode = prevNode.getNext();
				curNode = curNode.getNext();
				nextNode = nextNode.getNext();
				if (prevNode == curGender.getDown())
					break;
				if (curNode.getAge().equalsIgnoreCase(age)
						&& curNode.getFirstName().equalsIgnoreCase(firstName)
						&& curNode.getLastName().equalsIgnoreCase(lastName))
					prevNode.setNext(nextNode);
				if (curNode == curGender.getDown())
					curGender.setDown(nextNode);
			}
			curGender = curGender.getRight();
		} while (curGender.getRight() != null);
	}

	public ArrayList<ConvictNode> getAllConvicts(ShipNode startingShip) {
		ArrayList<ConvictNode> allNodes = new ArrayList<ConvictNode>();

		while (startingShip.getCurrentYear() != startingShip.getYearPtr()) {
			ConvictNode maleConvictNode = startingShip.getCurrentYear()
					.getRight().getDown();
			ConvictNode femaleConvictNode = startingShip.getCurrentYear()
					.getRight().getRight().getDown();

			allNodes.add(maleConvictNode);
			maleConvictNode = maleConvictNode.getNext();

			while (maleConvictNode.getNext() != startingShip.getCurrentYear()
					.getRight().getDown()) {
				maleConvictNode = maleConvictNode.getNext();
				allNodes.add(maleConvictNode);
			}

			allNodes.add(femaleConvictNode);
			femaleConvictNode = femaleConvictNode.getNext();

			while (femaleConvictNode.getNext() != startingShip.getCurrentYear()
					.getRight().getRight().getDown()) {
				allNodes.add(femaleConvictNode);
				femaleConvictNode = femaleConvictNode.getNext();
			}

			startingShip
					.setCurrentYear(startingShip.getCurrentYear().getDown());
		}

		return allNodes;
	}

	public YearNode getYear(String shipName, int i) {

		YearNode findYear = getShip(shipName).getYearPtr();
		while (findYear.getYearSailed() != i) {
			findYear = findYear.getDown();
		}
		return findYear;
	}

	public ShipNode getShip(String shipName) {
		ShipNode findShip = this.getFlagship();
		while (!findShip.getName().equalsIgnoreCase(shipName)) {
			findShip = findShip.getShipPtr();
		}
		return findShip;
	}

	public GenderNode getGender(String shipName, int i, String gender) {

		YearNode curYear = getYear(shipName, i);
		if (gender.startsWith("M")){
			return curYear.getRight();
		}
		else{
			return curYear.getRight().getRight();
		}
			
	}

	public boolean compareConvicts(ConvictNode a, ConvictNode b) {
		return (a.getLastName().equalsIgnoreCase(b.getLastName())
				&& a.getFirstName().equalsIgnoreCase(b.getFirstName())
				&& a.getAge().equalsIgnoreCase(b.getAge())
				&& a.getWhereConvicted()
						.equalsIgnoreCase(b.getWhereConvicted())
				&& a.getJailSentence().equalsIgnoreCase(b.getJailSentence())
				&& a.getHomeAdd().equalsIgnoreCase(b.getHomeAdd())
				&& a.getCrime().equalsIgnoreCase(b.getCrime()) && a
				.getProfession().equalsIgnoreCase(b.getProfession()));
	}

}