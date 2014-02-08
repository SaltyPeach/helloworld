import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Names {

	private ArrayList<NameRecord> names = new ArrayList<NameRecord>();
	public static int startingDecade;
	public static int numOfRanks;
	
	/*constructor for names. Makes arraylist filled with NameRecord.*/
	public Names (Scanner fileScanner){
		String line;
		while ( fileScanner.hasNextInt()){
			//first get the starting decade and num of ranks.
			//first two lines should always be integers
			startingDecade = fileScanner.nextInt();
			numOfRanks = fileScanner.nextInt();
		}
		
		//afterwards, the pointer for scanner should be in the name section of the file.
		while ( fileScanner.hasNextLine()){
			line = fileScanner.nextLine();
			//determine if the line has the correct number of ranks.
			Scanner lineScanner = new Scanner(line);
			int rankCounted = 0;
			
			while (lineScanner.hasNext()){
				lineScanner.next();
				rankCounted++;
			}
			
			/*if scanner counted number of ranks plus one for name, make it a NameRecord Obj.
			then add it to the arraylist name.*/
			if(rankCounted == numOfRanks + 1){
				//delete
				System.out.println(names.size());
				NameRecord recorded = new NameRecord(line);
				names.add(recorded);	
			}
			
			lineScanner.close();	
		}
	
	}
	
	/*this method scans the array, and using the getname method, compares strings and returns the appropriate value.*/
	public NameRecord getName(String givenName){
		int size = names.size();
		for (int i = 0; i < size; i++){
			if ((names.get(i)).getName().equals(givenName)){
				return names.get(i);
			}
		}
		return null;
	}
	
	/*this method returns an array of names containing the given substring.*/
	public ArrayList<NameRecord> getMatches(String partialName){
		ArrayList<NameRecord> matches = new ArrayList<NameRecord>();
		int size = names.size();
		for (int i = 0; i < size; i++){
			//convert string to lower case.
			String name = ((names.get(i)).getName()).toLowerCase();
			//see if the name contains the partial name.
			if (name.contains(partialName.toLowerCase())){
				//if true, add the NameRecord from given integer into a new arraylist.
				matches.add(names.get(i));
			}
		}
		return matches;
	}
	
	/*this method returns an arraylist with names that have been ranked every decade.*/
	public ArrayList<String> rankedEveryDecade(){
		//use the method alwaysRanked to check.
		ArrayList<String> ranked = new ArrayList<String>();
		int size = names.size();
		for (int i = 0; i < size; i++){
			if ((names.get(i).alwaysRanked())){
				ranked.add((names.get(i)).getName());
			}
		}
		return ranked;
	}
	
	/*same logic as rankedEveryDecade but only with onceRanked*/
	public ArrayList<String> rankedOnlyOneDecade(){
		//use the method onceRanked to check.
		ArrayList<String> ranked = new ArrayList<String>();
		int size = names.size();
		for (int i = 0; i < size; i++){
			if ((names.get(i).onceRanked())){
				ranked.add((names.get(i)).getName());
			}
		}
		return ranked;
	}
	
	/*same logic as rankedEveryDecade but only with popularity*/
	public ArrayList<String> alwaysMorePopular(){
		//use the method morePopular to check.
		ArrayList<String> popular = new ArrayList<String>();
		int size = names.size();
		for (int i = 0; i < size; i++){
			if ((names.get(i).morePopular())){
				popular.add((names.get(i)).getName());
			}
		}
		return popular;
	}
	
	/*same logic as rankedEveryDecade but only with popularity*/
	public ArrayList<String> alwaysLessPopular(){
		//use the method lessPopular to check.
		ArrayList<String> popular = new ArrayList<String>();
		int size = names.size();
		for (int i = 0; i < size; i++){
			if ((names.get(i).lessPopular())){
				popular.add((names.get(i)).getName());
			}
		}
		return popular;
	}
	
	
}
	

