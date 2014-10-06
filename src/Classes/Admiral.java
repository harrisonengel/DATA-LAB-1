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

			cur.setShipPtr(newShip);
			newShip.setShipPtr(flagship);
			System.out.println("Ship Added to the Fleet!");
		}

		this.currentShip = newShip;
		
		String nextLine = inFile.readLine();
		String currentYear = nextLine;
		this.addYearNode(shipName, currentYear);

		while (!inFile.eof()) {
			nextLine = inFile.readLine();
			if (nextLine.startsWith("*****")) {
				String seeNext = inFile.readLine();
				if (seeNext == null){
					System.out.println("*********END OF SHIP*********");
					return;
				} else {
					this.addYearNode(shipName, seeNext);
					currentYear = seeNext;
				}
			} else
				this.addConvict(shipName, Integer.parseInt(currentYear), nextLine);
		}
	}

	public void addConvict(String shipName, int year, String convictInfo) {
		
		ConvictNode newConvict = new ConvictNode(convictInfo);

		StringTokenizer convTokenizer = new StringTokenizer(convictInfo, "/");
		String gender = convTokenizer.nextToken();
		
		ShipNode findShip = this.getFlagship();
		while(!findShip.getName().equals(shipName)){
			findShip = findShip.getShipPtr();
		}
		
		YearNode findYear = findShip.getYearPtr();
		while(findYear.getYearSailed() != year){
			findYear = findYear.getDown();
		}

		GenderNode currentGender = findYear.getRight();
		if (!gender.startsWith("M"))
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
			
			System.out.println(currentGender.getGender() + " Convict " + newConvict.getFirstName() + " On Board The " + getShip(shipName).getName() + " In The Year " + getYear(shipName, year).getYearSailed());
			System.out.println();
		}
	}

	public void addYearNode(String shipName, String year) {
		ShipNode findShip = this.flagship;
		while(!findShip.getName().equals(shipName)){
			findShip = findShip.getShipPtr();
		}
		
		StringTokenizer tooManySpaces = new StringTokenizer(year);
		String realYear = tooManySpaces.nextToken();
		findShip.addAvailableYear(Integer.parseInt(realYear));
		YearNode newYear = new YearNode(Integer.parseInt(realYear));

		if (findShip.getYearPtr() == null) {
			findShip.setYearPtr(newYear);
			newYear.setDown(newYear);
		} else {
			YearNode prev = findShip.getYearPtr();
			YearNode next = prev.getDown();
			while (next != findShip.getYearPtr()) {
				prev = next;
				next = next.getDown();
			}
			
			prev.setDown(newYear);
			newYear.setDown(findShip.getYearPtr());
		}

		this.currentShip.setCurrentYear(newYear);
		
		GenderNode femaleNode = new GenderNode('F');
		GenderNode maleNode = new GenderNode('M');
		
		maleNode.setRight(femaleNode);
		newYear.setRight(maleNode);
	}
	
	public void removeConvict(String shipName, int year, String convictInfo){
		
		
		StringTokenizer convTokenizer = new StringTokenizer(convictInfo, "/");
		String gender = convTokenizer.nextToken();
		
		ConvictNode toRemove = new ConvictNode(convictInfo);
		GenderNode findGender = getGender(shipName, year, gender);
		
		ConvictNode prev = findGender.getDown();
		ConvictNode curNode = prev.getNext();
		ConvictNode nextNode = curNode.getNext();
		
		while (!(compareConvicts(toRemove, curNode))){
			prev = prev.getNext();
			curNode = curNode.getNext();
			nextNode = nextNode.getNext();
			if(prev == findGender.getDown()) return;
		}
		
		prev.setNext(nextNode);
	}
	
	public ArrayList<ConvictNode> getAllConvicts(ShipNode startingShip){
		ArrayList<ConvictNode> allNodes = new ArrayList<ConvictNode>();
		
		while(startingShip.getCurrentYear() != startingShip.getYearPtr()){
			ConvictNode maleConvictNode = startingShip.getCurrentYear().getRight().getDown();
			ConvictNode femaleConvictNode = startingShip.getCurrentYear().getRight().getRight().getDown();
			
			allNodes.add(maleConvictNode);
			maleConvictNode = maleConvictNode.getNext();
			
			while(maleConvictNode.getNext() != startingShip.getCurrentYear().getRight().getDown()){
				maleConvictNode = maleConvictNode.getNext();
				allNodes.add(maleConvictNode);
			}
			
			allNodes.add(femaleConvictNode);
			femaleConvictNode = femaleConvictNode.getNext();
			
			while(femaleConvictNode.getNext() != startingShip.getCurrentYear().getRight().getRight().getDown()){
				allNodes.add(femaleConvictNode);
				femaleConvictNode = femaleConvictNode.getNext();
			}
			
			startingShip.setCurrentYear(startingShip.getCurrentYear().getDown());
		}
		
		return allNodes;
	}

	public ShipNode getCurrentShip(){
		return this.currentShip;
	}
	public YearNode getYear(String shipName, int i){
		YearNode findYear = getShip(shipName).getYearPtr();
		while (findYear.getYearSailed() != i){
			findYear = findYear.getDown();
		}
		return findYear;
	}
	public ShipNode getShip(String shipName){
		ShipNode findShip = this.getFlagship();
		while(!findShip.getName().equals(shipName)){
			findShip = findShip.getShipPtr();
		}
		return findShip;
	}
	public GenderNode getGender(String shipName, int i, String gender){
		YearNode curYear = getYear(shipName, i);
		if (gender.startsWith("M")) return curYear.getRight();
		else return curYear.getRight().getRight();
	}
	public boolean compareConvicts(ConvictNode a, ConvictNode b){
		return (a.getLastName().equals(b.getLastName()) && a.getFirstName().equals(b.getFirstName()) && a.getAge().equals(b.getAge()) && a.getWhereConvicted().equals(b.getWhereConvicted())
					&& a.getJailSentence().equals(b.getJailSentence()) && a.getHomeAdd().equals(b.getHomeAdd()) && a.getCrime().equals(b.getCrime()) && a.getProfession().equals(b.getProfession()));	
	}
	
}