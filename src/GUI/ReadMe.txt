Lab 1

Program Name: meShip v 1.0

Student Name:     Harrison Engel
Semester:         Fall 2014
Class & Section:  20803-035 
Instructor:       Dr. Comer
Due Date:         10/9/2014

Program Overview:
	This application allows a user(the Admiral) to manage a fleet of ships full of convicts. 
	The user inputs ships in the form of text files of a specific format(see below). Convicts
	can also be added or removed via inputs on the right side of the window.

Input Types:

	Add Ship- Make sure to select a .txt file formatted with the following rules:
		1) The first row MUST be the Ship's name.
		2) The second row MUST be an integer year.
		3) After this, any number of convicts may be added in the format:
		Gender[M|F]/Last Name/First Name/Age/Conviction Location/Sentence Length/Crime/Proffession/
		each on a separate line.
		4) After all of the convict lines for a voyage, the next line MUST be ***** 
		5) Repeat 2-4 until all years and convicts are in the file.
	
	
	Display by Age- Displays all convicts of the age specified in the "Age" text-box. Make sure
			is an integer.
	
	Display by Gender- Displays a table of all convicts of a specified gender (M or F).
			   If "All Ships" is selected in the Ship dropdown menue, convicts of a
			   specific gender will be selected from All ships and all years.
			   Selecting a specific ship with all years prints all convicts of that 
			   gender for the ship. Selecting a specific ship and a specific year
			   gives all the convicts of that gender from that ship in that year.
	
	Display All- 	Displays all convicts from the selected ship (or "All Ships" and "All years")
			and the selected year (or "All years" if a specific ship is selected).
	
	Add Convict- 	Adds a Convict with the values input in the text boxes on the right.
			Make sure a ship and a year are selected, a gender is selected,
			and that all text boxes are filled.
	
	Remove Convict- Removes a convict based on the Ship, Year, Name, and Age specified. In v1.0
			if two convicts have the exact same data for these 4 parameters then only
			one will be deleted.
 
	Save Ship-	Saves the currently selected ship. A File Chooser pops up that allows you to
			select where your ship is saved. This is currently in beta testing, so make
			sure to select the original text file you created the ship from for best 
			results. 