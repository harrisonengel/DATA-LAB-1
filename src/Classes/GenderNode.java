/*******************************************************************/
/*   Program Name:     Lab 1                                       */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package Classes;

import Interfaces.GenderNodeInterface;

public class GenderNode implements GenderNodeInterface {

	private String gender;
	private Classes.ConvictNode downPtr;
	private GenderNode rightPtr;
	
	public GenderNode(char g){
		if (g == 'M') setGender("Male");
		if (g == 'F') setGender("Female");
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String g) {
		this.gender = g;
	}
	
	public Classes.ConvictNode getDown(){
		return downPtr;
	}
	
	public void setDown(ConvictNode ptr){
		this.downPtr = ptr;
	}
	
	public Classes.GenderNode getRight(){
		return rightPtr;
	}
	
	public void setRight(Classes.GenderNode ptr){
		this.rightPtr = ptr;
	}
}
