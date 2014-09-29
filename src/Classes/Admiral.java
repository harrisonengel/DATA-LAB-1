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
	private YearNode currentYear;
	
	public Admiral(){
		
	}
	
	public void setFlagship(ShipNode ship){
		this.flagship = ship;
	}
	
	public ShipNode getFlagship(){
		return this.flagship;
	}

	
	public void addShip(String fileName){
		
		EasyReader inFile = new EasyReader(fileName);
		if (inFile.bad())
			{
			  System.err.println("Can't open " + fileName);
			  return;
			}
		
		String shipName = inFile.readLine();
		ShipNode newShip = new ShipNode();
		newShip.setName(shipName);
		
		if (this.flagship == null){
			this.flagship = newShip;
			newShip.setShipPtr(flagship);
			return;
		}
		else{
			ShipNode cur = flagship;
			ShipNode next = flagship.getShipPtr();
			
			while(next != flagship){
				cur = next;
				next = next.getShipPtr();
			}
			
			next.setShipPtr(newShip);
			newShip.setShipPtr(flagship);
		}
		
		this.currentShip = newShip;
		
		while (!inFile.eof()){
			String nextLine = inFile.readLine();
			
			if (nextLine.length()==4) this.addYearNode(nextLine);
			else if (nextLine.equals("*****")) continue;
			else this.addConvict(nextLine);
		}
	}

	public void addConvict(String convictInfo){
		String gender;
		GenderNode currentGender;

		ConvictNode newConvict = new ConvictNode();
		
		StringTokenizer convTokenizer = new StringTokenizer(convictInfo, "/");
		
		gender = convTokenizer.nextToken();
		newConvict.setLastName(convTokenizer.nextToken());
		newConvict.setFirstName(convTokenizer.nextToken());
		newConvict.setAge(convTokenizer.nextToken());
		newConvict.setWhereConvicted(convTokenizer.nextToken());
		newConvict.setJailSentence(convTokenizer.nextToken());
		newConvict.setHomeAdd(convTokenizer.nextToken());
		newConvict.setCrime(convTokenizer.nextToken());
		newConvict.setProfession(convTokenizer.nextToken());
		
		currentGender = this.currentYear.getRight();
		if (!gender.equals(currentGender.getGender())) currentGender = currentGender.getRight();
		
		if (currentGender.getDown() == null){
			currentGender.setDown(newConvict);
		} else {
			ConvictNode prev = currentGender.getDown();
			ConvictNode next = prev.getNext();
			
			while (next != currentGender.getDown()){
				prev = next;
				next = next.getNext();
			}
			prev.setNext(newConvict);
			newConvict.setNext(currentGender.getDown());
		}
	}
	
	public void addYearNode(String year){
		YearNode newYear = new YearNode(Integer.parseInt(year));
		
		if(this.currentShip.getYearPtr() == null){
			this.currentShip.setYearPtr(newYear);
			newYear.setDown(newYear);
		}
		else {
			YearNode prev = this.currentShip.getYearPtr();
			YearNode next = prev.getDown();
			while(next != this.currentShip.getYearPtr()){
				prev = next;
				next = next.getDown();
			}
			
			prev.setDown(newYear);
			newYear.setDown(this.currentShip.getYearPtr());
		}
		
		this.currentShip.setCurrentYear(newYear);
		
		newYear.setRight(new GenderNode('M'));
		newYear.getRight().setRight(new GenderNode('F'));
	}
}

