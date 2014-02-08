/*  Student information for assignment:
 *
 *  On my honor, Woo Ho Song, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:ws6887
 *  email address:woohosong@utexas.edu
 *  Grader name:chris
 *  Number of slip days I am using:0
 */

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NameSurfer { 

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;

	public static final int QUIT = 8;

	// CS314 students, explain your menu option 7 here:


	// CS314 students, Explain your interesting search / trend here:


	// CS314 students, add test code for NameRecord class here:
/*	Test 1 : see if the object retrieves the correct name from the string.
	String testLine1 = "Aaron 193 208 218 274 279 232 132 36 32 31 41";
	boolean result;
	NameRecord test1 = new NameRecord(testLine1, 1900, 11);
	System.out.println("Expected output : Aaron");
	System.out.println("Actual output : "+ test1.getName());
	if (test1.getName().equals("Aaron")){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 2 : see if the Names returns correct year for given decades.
	System.out.println("Expected output : 193");
	System.out.println("Actual output : "+ test1.getDecadeRank(0));
	if (test1.getDecadeRank(0)==193){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 3 : see if the Names returns correct year for given decades.
	System.out.println("Expected output : 41");
	System.out.println("Actual output : "+ test1.getDecadeRank(10));
	if (test1.getDecadeRank(10)==41){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 4 : see if the Names returns the best decade.
	System.out.println("Expected output : 1990");
	System.out.println("Actual output : "+ test1.getBestDecade());
	if (test1.getBestDecade()==1990){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 5 : see if the Names returns the best when its all 0.
	String testLine5 = "Woo Ho 0 0 0 0 0 0 0 0 0 0 0";
	NameRecord test5 = new NameRecord(testLine5, 1900, 11);
	System.out.println("Expected output : 1900");
	System.out.println("Actual output : "+ test5.getBestDecade());
	if (test5.getBestDecade()==1900){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 6 : see if the Names returns the best when there are multiple same ranks.
	String testLine6 = "David 29 0 0 11 6 5 2 4 2 11 16";
	NameRecord test6 = new NameRecord(testLine6, 1900, 11);
	System.out.println("Expected output : 1980");
	System.out.println("Actual output : "+ test6.getBestDecade());
	if (test6.getBestDecade()==1980){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 7 : see if the Names returns the total amount of times the name was in top 1000
	System.out.println("Expected output : 11");
	System.out.println("Actual output : "+ test1.getTotalRanked());
	if (test1.getTotalRanked()==11){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 8 : see if the Names returns the total amount of times the name was in top 1000
	System.out.println("Expected output : 0");
	System.out.println("Actual output : "+ test5.getTotalRanked());
	if (test5.getTotalRanked()==0){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 9 : see if the Names returns the total amount of times the name was in top 1000
	System.out.println("Expected output : 9");
	System.out.println("Actual output : "+ test6.getTotalRanked());
	if (test6.getTotalRanked()==9){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 10 : see if the Names returns true when ranked always in the top 1000
	System.out.println("Expected output : false");
	System.out.println("Actual output : "+ test6.alwaysRanked());
	if (test6.alwaysRanked()==false){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 11 : see if the Names returns true when ranked always in the top 1000
	System.out.println("Expected output : true");
	System.out.println("Actual output : "+ test1.alwaysRanked());
	if (test1.alwaysRanked()==true){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 12 : see if the Names returns true when ranked only once
	String testLine12 = "Dax 0 0 0 0 0 0 0 951 0 0 0";
	NameRecord test12 = new NameRecord(testLine12, 1900, 11);
	System.out.println("Expected output : true");
	System.out.println("Actual output : "+ test12.onceRanked());
	if (test12.onceRanked()==true){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 13 : see if the Names returns true when ranked only once
	System.out.println("Expected output : false");
	System.out.println("Actual output : "+ test1.onceRanked());
	if (test1.onceRanked()==false){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 14 : see if the Names returns correct value for popularity
	String testLine14 = "Amanda 1000 900 800 700 500 400 200 100 50 20 1";
	NameRecord test14 = new NameRecord(testLine14, 1900, 11);
	System.out.println("Expected output : true");
	System.out.println("Actual output : "+ test14.morePopular());
	if (test14.morePopular()==true){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 15 : see if the Names returns correct value for popularity
	String testLine15 = "Amanda 1000 900 800 700 500 400 200 100 50 20 0";
	NameRecord test15 = new NameRecord(testLine15, 1900, 11);
	System.out.println("Expected output : false");
	System.out.println("Actual output : "+ test15.morePopular());
	if (test15.morePopular()==false){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 16 : see if the Names returns correct value for popularity
	String testLine16 = "Amanda 1000 0 800 700 500 400 200 100 50 20 1";
	NameRecord test16 = new NameRecord(testLine16, 1900, 11);
	System.out.println("Expected output : false");
	System.out.println("Actual output : "+ test16.morePopular());
	if (test16.morePopular()==false){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 17 : see if the Names returns correct value for popularity
	String testLine17 = "Amanda 1000 0 0 700 500 400 200 100 50 20 1";
	NameRecord test17 = new NameRecord(testLine17, 1900, 11);
	System.out.println("Expected output : false");
	System.out.println("Actual output : "+ test17.morePopular());
	if (test17.morePopular()==false){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 18 : see if the Names returns correct value for declining popularity
	String testLine18 = "Amanda 10 20 40 500 600 700 800 950 999 1000 0";
	NameRecord test18 = new NameRecord(testLine18, 1900, 11);
	System.out.println("Expected output : true");
	System.out.println("Actual output : "+ test18.lessPopular());
	if (test18.lessPopular()==true){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 19 : see if the Names returns correct value for declining popularity
	String testLine19 = "Amanda 10 20 40 0 0 700 800 950 999 1000 0";
	NameRecord test19 = new NameRecord(testLine19, 1900, 11);
	System.out.println("Expected output : false");
	System.out.println("Actual output : "+ test19.lessPopular());
	if (test19.lessPopular()==false){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
	
	Test 20 : see if the Names returns correct value for declining popularity
	String testLine20 = "Amanda 10 20 40 500 500 700 800 950 999 1000 0";
	NameRecord test20 = new NameRecord(testLine20, 1900, 11);
	System.out.println("Expected output : false");
	System.out.println("Actual output : "+ test20.lessPopular());
	if (test20.lessPopular()==false){
		result = true;
	}else {
		result = false;
	}
	System.out.println(result);
	System.out.println("");
}*/

	// main method. Driver for the whole program
	public static void main(String[] args) {
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));

		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		    System.out.println("Unable to set look at feel to local settings. " +
		    		"Continuing with default Java look and feel.");
		}
	    try {
		    System.out.println("Opening GUI to choose file with names data...");
	        // next line for GUI
		    // Scanner fileScanner = new Scanner(getFile());

		    // next line to skip GUI
		    Scanner fileScanner = new Scanner(new File("names.txt"));
			Names n = new Names(fileScanner);
			fileScanner.close();
			int choice;
			Scanner keyboard = new Scanner(System.in);
			do {
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				else
					System.out.println("\n\nGoodbye.");

			} while( choice != QUIT);
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Exiting the program." + e);
		}
	}

	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {

	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {

	}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {

	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data
	private static void search(Names n, Scanner keyboard) {

	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}

	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) {
        System.out.print(prompt);
        while( !s.hasNextInt() ){
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
		// CS314 students fill in other options

		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/* Method to choose a file using a traditional window.
      @return the file chosen by the user. Returns null if no file picked.
     */
    public static File getFile() {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }

}