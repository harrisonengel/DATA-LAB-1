/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Classes;

public class ShipNode {
	private ShipNode shipPtr;
	private YearNode yearPtr;
	private String shipName;
	private YearNode currentYear;
	
	public ShipNode(){
		
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
}
