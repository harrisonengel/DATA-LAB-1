package Interfaces;
/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

public interface GenderNodeInterface {
	/**
	* Protocol for GenderNodeInterface
	* @author James Comer
	*/
	// ******************PUBLIC METHODS******************************************
	public String getGender();
	// --> returns the gender field of the GenderNode being pointed to
	//
	public void setGender(String g);
	// --> sets the gender field of the GenderNode being pointed to to g.
	//
	public Classes.ConvictNode getDown();
	// --> returns the value of the downPtr for the specified GenderNode
	//
	public void setDown(Classes.ConvictNode ptr);
	// --> sets the downPtr of the specified GenderNode to ptr
	//
	public Classes.GenderNode getRight();
	// --> returns the value of the rightPtr for the specified GenderNode
	//
	public void setRight(Classes.GenderNode ptr);
	// --> sets the rightPtr of the specified GenderNode to ptr
	//**************************************************************************
}
