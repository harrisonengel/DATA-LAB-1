/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Interfaces;

public interface ConvictNodeInterface {
	/**
	* Protocol for ConvictNodeInterface
	* @author James Comer
	*/
	// ******************PUBLIC METHODS******************************************
	public String getLastName();
	// --> returns the lastName field of the specified ConvictNode
	//
	public void setLastName(String s);
	// --> sets the lastName field of the specified ConvictNode to s
	//
	public String getFirstName();
	// --> returns the firstName field of the specified ConvictNode
	//
	public void setFirstName(String s);
	// --> sets the firstName field of the specified ConvictNode to s
	//
	public String getAge();
	// --> returns the age field of the specified ConvictNode
	//
	public void setAge(String r);
	// --> sets the age field of the specified ConvictNode to r
	//
	public String getWhereConvicted();
	// --> returns the convictionLoc field of the specified ConvictNode
	//
	public void setWhereConvicted(String r);
	// --> sets the convictionLoc field of the specified ConvictNode to r
	//
	public String getJailSentence();
	// --> returns the jailSentence field of the specified ConvictNode
	//
	public void setJailSentence(String js);
	// --> sets the jailSentence field of the specified ConvictNode to r
	//
	public String getHomeAdd();
	// --> returns the homeAdd field of the specified ConvictNode
	//
	public void setHomeAdd(String ha);
	// --> sets the homeAdd field of the specified ConvictNode to r
	//
	public String getCrime();
	// --> returns the crime field of the specified ConvictNode
	//
	public void setCrime(String c);
	// --> sets the crime field of the specified ConvictNode to r
	//
	public String getProfession();
	// --> returns the profession field of the specified ConvictNode
	//
	public void setProfession(String p);
	// --> sets the profession field of the specified ConvictNode to r
	//
	public Classes.ConvictNode getNext();
	// --> returns the nextPtr of the specified ConvictNode
	//
	public void setNext(Classes.ConvictNode ptr);
	// --> sets the nextPtr of the specified ConvictNode to ptr
	//****************************************************************************
}
	
