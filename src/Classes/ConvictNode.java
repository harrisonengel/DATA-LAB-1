/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Classes;

import Interfaces.ConvictNodeInterface;

public class ConvictNode implements ConvictNodeInterface {
	
	private String lastName;
	private String firstName;
	private String age;
	private String convictionLoc;
	private String jailSentence;
	private String homeAdd;
	private String crime;
	private String profession;
	private ConvictNode nextPtr;
	
	public ConvictNode(String name){
		
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String s){
		this.lastName = s;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String s){
		this.firstName = s;
	}
	public String getAge(){
		return this.age;
	}
	public void setAge(String r){
		this.age = r;
	}
	public String getWhereConvicted(){
		return this.convictionLoc;
	}
	public void setWhereConvicted(String r){
		this.convictionLoc = r;
	}
	public String getJailSentence(){
		return this.jailSentence;
	}
	public void setJailSentence(String js){
		this.jailSentence = js;
	}
	public String getHomeAdd(){
		return this.homeAdd;
	}
	public void setHomeAdd(String ha){
		this.homeAdd = ha;
	}
	public String getCrime(){
		return this.crime;
	}
	public void setCrime(String c){
		this.crime = c;
	}
	public String getProfession(){
		return this.profession;
	}
	public void setProfession(String p){
		this.profession = p;
	}
	public ConvictNode getNext(){
		return this.nextPtr;
	}
	public void setNext(ConvictNode ptr){
		this.nextPtr = ptr;
	}
}
