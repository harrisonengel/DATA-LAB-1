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
	private YearNode currentYear;
	private ArrayList availableYears;
	
	public ShipNode(){
		availableYears = new ArrayList();
	}
	
	public void setYearPtr(YearNode ptr){
		this.yearPtr = ptr;
	}
	
	public YearNode getYearPtr(){
		return this.yearPtr;
	}
	
	public void setShipPtr(ShipNode ptr){
		this.shipPtr = ptr;
	}
	
	public ShipNode getShipPtr(){
		return this.shipPtr;
	}
	
	public void setName(String name){
		this.shipName = name;
	}
	
	public String getName(){
		return this.shipName;
	}
	
	public void setCurrentYear(YearNode cur){
		this.currentYear = cur;
	}
	public YearNode getCurrentYear(){
		return this.currentYear;
	}
	public void addAvailableYear(int year){
		this.availableYears.add(year);
	}
	public ArrayList getAvailableYears(){
		return this.availableYears;
	}
}
