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

import Interfaces.ConvictNodeInterface;
/*************************************************************************
 * 								ConvictNode
 * Each ConvictNode represents a convict in the Linked List. They have a
 * first and last name, age, conviction location, sentence length, home address,
 * crime, and profession. Each Node also points to another node, with the head
 * node being designated by its association with a GenderNode pointing to it.
 *************************************************************************/

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
	
	//creates an empty convict node
	public ConvictNode(){
	}
	//Creates a ConvictNode using a specially formatted convictInfo String
	//(See ReadMe)
	public ConvictNode(String convictInfo){
		StringTokenizer convTokenizer = new StringTokenizer(convictInfo, "/");
		convTokenizer.nextToken();
		this.lastName = convTokenizer.nextToken();
		this.firstName = convTokenizer.nextToken();
		this.age = convTokenizer.nextToken();
		this.convictionLoc = convTokenizer.nextToken();
		this.jailSentence = convTokenizer.nextToken();
		this.homeAdd = convTokenizer.nextToken();
		this.crime = convTokenizer.nextToken();
		this.profession = convTokenizer.nextToken();
	}
	
	//Returns the lastName.
	public String getLastName(){
		return this.lastName;
	}
	
	//Sets the lastName
	public void setLastName(String s){
		this.lastName = s;
	}
	
	//Gets the FirstName
	public String getFirstName(){
		return this.firstName;
	}
	
	//Sets the firstName
	public void setFirstName(String s){
		this.firstName = s;
	}
	
	//Gets the Age
	public String getAge(){
		return this.age;
	}
	
	//Sets the Age
	public void setAge(String r){
		this.age = r;
	}
	
	//Gets where they were convicted
	public String getWhereConvicted(){
		return this.convictionLoc;
	}
	
	//Sets where the convict was convicted
	public void setWhereConvicted(String r){
		this.convictionLoc = r;
	}
	
	//Gets the sentence length
	public String getJailSentence(){
		return this.jailSentence;
	}
	
	//Sets the sentence length
	public void setJailSentence(String js){
		this.jailSentence = js;
	}
	
	//Gets the convict's Home
	public String getHomeAdd(){
		return this.homeAdd;
	}
	
	//Sets the convict's Home
	public void setHomeAdd(String ha){
		this.homeAdd = ha;
	}
	
	//Gets the convicts crime
	public String getCrime(){
		return this.crime;
	}
	
	//Sets the convict's crime
	public void setCrime(String c){
		this.crime = c;
	}
	
	//Gets the convict's profession
	public String getProfession(){
		return this.profession;
	}
	
	//Sets the convict's profession
	public void setProfession(String p){
		this.profession = p;
	}
	
	//Returns the next ConvictNode
	public ConvictNode getNext(){
		return this.nextPtr;
	}
	
	//Sets the next ConvictNode
	public void setNext(ConvictNode ptr){
		this.nextPtr = ptr;
	}
	
}
