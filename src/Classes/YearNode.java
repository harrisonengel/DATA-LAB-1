/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Classes;

import Interfaces.YearNodeInterface;

/*************************************************************************
 * 								YearNode
 * YearNodes represent voyages on a specific ship. They contain pointers
 * to the next YearNode (down) and a male GenderNode(right)
 * The ship field is never used and is only in the Node because it must 
 * be inherited from the YearNodeInterface.
 *************************************************************************/

public class YearNode implements YearNodeInterface {
	
	private int year;
	private String ship;
	private YearNode down;
	private GenderNode right;
	
	//Creates a YearNode with the specified year.
	public YearNode(int year){
		this.year = year;
	}
	
	//Gets the ship name associated wit the year node (Never Used)
	public String getShipName(){
		return this.ship;
	}
	
	//Sets the ship name (Never Used)
		public void setShipName(String sn){
			this.ship = sn;
	}
		
	//Returns the year.
		public int getYearSailed(){
			return year;
	}
	
	//Sets the year.
		public void setYearSailed(int ng){
		this.year = ng;
	}
	
	//Gets the next YearNode.
		public YearNode getDown(){
			return down;
	}
	
	//Sets the next YearNode.
		public void setDown(YearNode ptr){
			this.down = ptr;
	}
	
	//Returns the male GenderNode
		public GenderNode getRight(){
		return right;
	}
		
	//Sets the right GenderNode (should be male)
		public void setRight(GenderNode ptr){
		this.right = ptr;
	}

}
