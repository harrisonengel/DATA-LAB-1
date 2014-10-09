/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Classes;
import java.util.ArrayList;

public class ShipNode {
	private ShipNode shipPtr;
	private YearNode yearPtr;
	private String shipName;
	private ArrayList availableYears;
	
	/****************************************************
	 * 						ShipNode
	 * The ShipNode object represents a ship in our fleet.
	 * It contains a shipPtr that links to the next ShipNode
	 * and a yearPtr that links to a head YearNode.
	 * The ArrayList availableYears contains a numerical
	 * representation of the years belonging to this node.
	 * It is used only to give functionality to the dropdown
	 * selection of year in the program.
	 *****************************************************/
	
	public ShipNode(){
		availableYears = new ArrayList();
	}
	
	//Sets the ShipNode's YearPtr
	public void setYearPtr(YearNode ptr){
		this.yearPtr = ptr;
	}
	
	//Gets the YearPtr.
	public YearNode getYearPtr(){
		return this.yearPtr;
	}
	
	//Sets the ShipPtr
	public void setShipPtr(ShipNode ptr){
		this.shipPtr = ptr;
	}
	
	//Gets the ShipPtr
	public ShipNode getShipPtr(){
		return this.shipPtr;
	}
	
	//Sets the ship's Name
	public void setName(String name){
		this.shipName = name;
	}
	
	//Gets the ship's Name
	public String getName(){
		return this.shipName;
	}
	
	//Adds an available year to the ship.
	public void addAvailableYear(int year){
		this.availableYears.add(year);
	}
	
	//Returns an ArrayList containing the years 
	//available to this Ship
	public ArrayList getAvailableYears(){
		return this.availableYears;
	}
}
