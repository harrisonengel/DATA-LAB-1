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

public class YearNode implements YearNodeInterface {
	
	private int year;
	private String ship;
	private YearNode down;
	private GenderNode right;
	
	public YearNode(int year){
		this.year = year;
	}
	public String getShipName(){
		return this.ship;
	}
		public void setShipName(String sn){
			this.ship = sn;
	}
		public int getYearSailed(){
			return year;
	}
		public void setYearSailed(int ng){
		this.year = ng;
	}
		public YearNode getDown(){
			return down;
	}
		public void setDown(YearNode ptr){
			this.down = ptr;
	}
		public GenderNode getRight(){
		return right;
	}
		public void setRight(GenderNode ptr){
		this.right = ptr;
	}

}
