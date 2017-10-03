package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriter {

	public static void main(String[] args) {
		File writtenPom = new File("pom.xml.1"); //create a file object => pom writing to
		File originalPom = new File("pom.xml");
		try(
				Scanner readPom = new Scanner(originalPom); //scanner reads bytes from string till end--
				PrintWriter writePom = new PrintWriter(writtenPom) ) {  //same line but more readable this way(semicolon is seperator, not end of line)
			
		//1st-- add a clause to fix error
		//created a printReader now need to create a writer =>print writer-- in try so it'll be closed when we're done
		// create a scanner and hasNextLine-- structure to always use in a while loop
			
			while(readPom.hasNextLine()) { //== while(fileRead.hasNextLine()){  //IS STRUCTURE TO USE TO GO THRU LINE-BY-LINE
				String line = readPom.nextLine(); //String line= fileRead.nextLine();
				if(line.contains("<versio>1.0</version>")) {// replace whole string, not just exact 1.0 
					line = line.replace("1.0", "1.5"); 	//use 'line =' because we're using objects		
					}
				writePom.println(line); //takes line 1 from readPalm, to write into a buffer then writes into file of line 1 of pom.xml.1
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //could use here Sys.out.println("The pom.xml doesn't exist");
			System.exit(1); //says that on any exception, this program dies -- so below rename doesn't happen-- just use a 1
		}
		//all files are closed an cleaned up at this point- now move .xml.1 to new spot
		writtenPom.renameTo(originalPom); //renamed so this is the only file left in existence =>rename moves it
	}
	
	
}
