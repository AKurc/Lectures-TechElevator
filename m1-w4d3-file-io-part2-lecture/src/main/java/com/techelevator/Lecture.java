package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Lecture {

	public static void main(String[] args) throws IOException {
		//System.in. --methods of sys.in-- barbaric-- DON'T USE THIS METHOD- use a stream reader, UNLESS working with binary data
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		//Scanner is specifically used for text (user input) -- manipulate jpeg or gif- use binary input streams
		
		/* 
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and 
		 * modify file system objects.
		 * 
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 * 
		 * A new instance of File can be created from a String that contains a file system path 
		 */
		
		System.out.print("Enter the path of a file or directory >>> ");
		String path = userInput.readLine();
		File f = new File(path);

		/* 
		 * The File class allows us to inspect various attributes of a file system object 
		 // is an object represented on the hard drive
		 */
		 
		/* ***************************
		 * INSPECTING THE FILESYSTEM 
		 * ***************************/
		
		System.out.println();
		if(f.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			System.out.println("name: "+f.getName());
			System.out.println("absolutePath: "+f.getAbsolutePath()); //getAbsPath starts at root of HD and looks through to where you're working to find file
			if(f.isDirectory()) {
				System.out.println("type: directory");// directory is sort of a file- has a description on HD
			} else if(f.isFile()) {
				System.out.println("type: file");
			}
			System.out.println("size : "+f.length()); //length should have been called size (returns in bytes)
		} else {
			System.out.println(f.getAbsolutePath()+" does not exist.");
		}
		
		/* 
		 * The File class also allows us to manipulate file system objects 
		 * */
		 
		/* ************************
		 * CREATING A DIRECTORY 
		 * ************************/
		
		System.out.println();
		System.out.println("Let's create a new directory.");
		System.out.print("Enter the path of the new directory >>> ");
		path = userInput.readLine();
		File newDirectory = new File(path);
		
		if(newDirectory.exists()) {
			System.out.println("Sorry, "+newDirectory.getAbsolutePath()+" already exists.");
			System.exit(1);
		} else { //if pathways doesn't exist, it goes to else
			if(newDirectory.mkdir()) {
				System.out.println("New directory created at "+newDirectory.getAbsolutePath());
			} else { //can't create directory- tells you that
				System.out.println("Could not create directory.");
				System.exit(1);
			}
		}
		 
		/* ************************
		 * CREATING A FILE 
		 * ************************/
		
		System.out.println();
		System.out.println("Now let's put a file in the directory.");
		System.out.print("Enter a name for the new file >>> ");
		String fileName = userInput.readLine();
		File newFile = new File(newDirectory, fileName); //new file is a new object
		
		newFile.createNewFile(); //empty new file with that name in that directory
		System.out.println();
		System.out.println("name: "+newFile.getName());
		System.out.println("absolutePath: "+newFile.getAbsolutePath());
		System.out.println("size : "+newFile.length());
		
		 
		/* ************************
		 * WRITING TO A FILE 
		 * ************************/
		
		System.out.println();
		System.out.println("Now let's write something in the new file.");
		System.out.print("Enter a message to be stored in the new file >>> ");
		String message = userInput.readLine();
		
		try(PrintWriter writer = new PrintWriter(newFile)) { //PrintWriter is way we will open files for writing-- pass in a file object
			writer.println(message); //auto flush built in to object
		} // When we exit the try block, this cause the file to be closed and an automatic flush of the buffer to trigger
		
		System.out.println();
		System.out.println("name: "+newFile.getName());
		System.out.println("absolutePath: "+newFile.getAbsolutePath());
		System.out.println("size : "+newFile.length());
		
	}

}
