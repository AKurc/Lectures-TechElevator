package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class collectionslecturew2d3 {

	public static void main(String[] args) {
		

		Map<Integer, String> rooms = new HashMap<Integer, String>();
		
		rooms.put(101, "Joe");
		rooms.put(102, "Anna");
		rooms.put(103, "Troy");
		
		System.out.println(rooms.get(103)); //use key to get value back out again//
//not doing for loop behind the sceine- going directly to value//
		
		//a really stupid hash algorithim:
		// 101 = 1 + 0 + 1 = 2   and since key gave goes to the 2 so you put a 2 in the box- see notes//
		
		
		//hash- generates a hash code value for the object (generated from the key) - also means that a new key overwrites what was before//
		//in hash algorithm, there is a for loop and it's just math so it's really fast//
		//hashMap is most common type of map//
		
		//!!!KEYS HAVE TO BE UNIQUE!!!//
		
		
		rooms.put(103, "Bobby");
		rooms.put(104, "Bobby");
		
		rooms.put(420, "Jared");
		
		//remove values AND key from map//
		rooms.remove(420);
		rooms.remove(420, "Bobby"); //so won't remove 420 because it says 'IF' Bobby and that's not true so it doesn't work//
		
		System.out.println(rooms.get(103)); 
		
		rooms.put(420, null); //put 420 as null, but key is still there//
		
		//and now get rid of room//
		rooms.remove(420); //still get null from 420 because it's a key that doesn't exist//
		
		for(Integer key : rooms.keySet()); //for each key that is a map, get a key set that gives us all of the keys//
			System.out.println(key);
			System.out.println(rooms.get(key));//print values associated with keys by essentially just getting them//
			//key is made up- could be anything you want//
			
			//go thru key value pairs to find specific//
			//entry is an object (made for dealing with Maps) that's part of the Map- hold an ( so a integer and a string) key and a value//
			for(Entry<Integer, String> entry : rooms.entrySet()) { //so for each key value pair do line 55//
				if(entry.getValue().equals("Bobby")) {
					System.out.println("Bobby is in room " + entry.getKey());
					break; //if you don't put break it would print "Bobby is in room 103 and Bobby is in room 104"//
				}
			}
		//CREATING A NEW MAP- representing ppl in this room - key can be whatever object you want it to be//
			//making a map and a hashMap that hold a list//
			//string is key and pointing to a list of values//
			Map<String, List<Integer>> students = new HashMap<String, List<Integer>>(); 
			
			List<Integer> heathersStats = new ArrayList<>();
			
			heathersStats.add(22);
			heathersStats.add(66);
			
			students.put("Heather", heathersStats); //key is heather and put object heatherStats into Map//
			
			//key can never have more that one value, but that value can be a list//
			
			//get height back out//
			System.out.println(students.get("Heather").get(1)); 
			//students is the map- Heather is the key - get Heather returns list- git on list- returns height//
			//so only 1 array list in memory because heathersStats and    both go to same place to return//
			
			heathersStats.add(283); //point to same list in memory with new add on//
			
			System.out.println(students.get("Heather").get(2));
			
	}

}
