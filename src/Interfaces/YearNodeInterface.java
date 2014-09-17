/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Interfaces;

public interface YearNodeInterface
{
	/* Protocol for YearNodeInterface
	* @author James Comer
	*/
	//******************PUBLIC METHODS******************************************
	public String getShipName();
//--> returns the shipName of the “header” node of the linked list
//
	public void setShipName(String sn);
//--> sets the shipName of the node being pointed to to sn.
//
	public int getYearSailed();
//--> returns the yearSailed field of the YearNode being pointed to
//
	public void setYearSailed(int ng);
//--> sets the age field of the ShipNode being pointed to to ng.
//
	public Classes.YearNode getDown();
//--> returns the value of the downPtr for the specified YearNode
//
	public void setDown(Classes.YearNode ptr);
//--> sets the downPtr of the specified YearNode to ptr
//
	public Classes.GenderNode getRight();
//--> returns the value of the rightPtr for the specified YearNode
//
	public void setRight(Classes.GenderNode ptr);
//--> sets the rightPtr of the specified YearNode to ptr
//**************************************************************************

}