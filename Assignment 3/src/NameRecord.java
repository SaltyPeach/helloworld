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

public class NameRecord {
	
	private String givenName;
	private int startingDecade = Names.startingDecade;
	private int numOfRanks = Names.numOfRanks;
	private int decade = 10;
	ArrayList<Integer> nameRanking;
	
	

	/*This creates a constructor for NameRecord.*/
	
	public NameRecord(String line){
		//initialize the array list with ranking and determine the name.
		Scanner lineScanner = new Scanner(line);
		ArrayList<Integer> nameRanking = new ArrayList<Integer>(numOfRanks);
		while(lineScanner.hasNext()){
			givenName = lineScanner.next();
			while(lineScanner.hasNextInt()){
				nameRanking.add(lineScanner.nextInt());
			}
		}
		lineScanner.close();
		this.nameRanking = nameRanking;
	}
	
	public NameRecord(String line, int startingDecade, int numOfRanks){
		//initialize the array list with ranking and determine the name.
		this.startingDecade = startingDecade;
		this.numOfRanks = numOfRanks;
		Scanner lineScanner = new Scanner(line);
		ArrayList<Integer> nameRanking = new ArrayList<Integer>(numOfRanks);
		while(lineScanner.hasNext()){
			givenName = lineScanner.next();
			while(lineScanner.hasNextInt()){
				nameRanking.add(lineScanner.nextInt());
			}
		}
		lineScanner.close();
		this.nameRanking = nameRanking;
	}
	
	/*this method returns a string  for the given name in this record.*/
	public String getName(){
		return givenName;
	}

	/*this method returns the given name's rank for the given decade.*/
	//pre:must be within the parameter, (0,numOfRanks-1)
	public int getDecadeRank (int givenDecade){
		if (givenDecade >= numOfRanks || givenDecade < 0){
			throw new IndexOutOfBoundsException("Parameter must be within 0 and "+ (numOfRanks-1));
		}
		return nameRanking.get(givenDecade);
	}
	
	/*returns the year the name was most popular*/
	public int getBestDecade(){
		int topRank = nameRanking.get(0);
		int bestDecade= 0;
		for (int i = 0; i < numOfRanks; i++){
			//if ranking is higher than current rank and its not 0, replace top ranking.
			if (nameRanking.get(i)<=topRank && nameRanking.get(i)!= 0){
				topRank = nameRanking.get(i);
				bestDecade = i;		
			}
		}
		return (startingDecade + decade*bestDecade);
	}
	
	
	/*returns the number of decades this name has been in the top 1000*/
	public int getTotalRanked(){
		int counter=0;
		for (int i = 0; i < numOfRanks; i++){
			if(nameRanking.get(i)<=1000 && nameRanking.get(i)!= 0){
				counter++;
			}
		}
		return counter;
	}
	
	/*returns true if this name has been ranked top 1000 always.*/
	public boolean alwaysRanked(){
		for (int i = 0; i < numOfRanks; i++){
			if(nameRanking.get(i)==0){
				return false;
			}
		}
		return true;
	}
	
	/*returns true only if it was in the top 1000 once in the given years.*/
	public boolean onceRanked(){
		int counter = 0;
		for (int i = 0; i < numOfRanks; i++){
			if(nameRanking.get(i)==0){
				counter++;
			}
		}
		//only once ranked also means every other decade it was never ranked. thus count 0's instead.
		if (counter == numOfRanks-1){
			return true;
		}
		return false;
	}
		
	/*returns true only if the name has been getting popular.*/
	public boolean morePopular(){
		if(nameRanking.get(numOfRanks-1)==0){
			//if the last year of the ranking is 0, it is never getting popular.
			return false;
		}
		for (int i = 0; i < numOfRanks-1; i++){
			//if the ranking is 0, aka unknown, check if there is another 0 next. If so, return false.
			if(nameRanking.get(i)==0){
				if(nameRanking.get(i+1)==0){
					return false;
				}else if(i > 0 && nameRanking.get(i-1) > 0 ){
					//if ranking is unknown, check to see if there was an actual ranking to the left of the 0, so prove that it is popular or not.
					return false;
				}
			}
			//if the unknown test passes, check to see that the number is always decreasing
			if(nameRanking.get(i) <= nameRanking.get(i+1)){
				return false;
			}
		}
		//if all conditions are met, it must be true.
		return true;
	}
	
	/*returns true only if the name has been less popular*/
	public boolean lessPopular(){
		//similar logic as popular, check unknowns first.
		for (int i = 0; i < numOfRanks-1; i++){
			if(nameRanking.get(i)==0){
				//if ranking is unknown, check to the right to see if there was an actual ranking. If it does, it is not always less popular.
				//if ranking is next to zeros, cannot be determined, return false as well.
				if(nameRanking.get(i+1)==0||nameRanking.get(i+1)>0){
					return false;
				}
				//if the unknown test passes, check to see that the number is always decreasing
			}
			if(nameRanking.get(i) >= nameRanking.get(i+1) && nameRanking.get(i+1)!= 0){
				return false;
			}
		}
			//if all conditions are met, must be getting less popular.
			return true;
	}

}
