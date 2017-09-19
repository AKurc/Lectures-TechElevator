package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class MorningLecturew2d2 {

	public static void main(String[] args) {
//	
//		Integer i = new Interger(47); //creates a new integer object in the heap starting in a initialization of 47 (address 47 gets assigned back to i)//
//		
//		System.out.println(i);
//		
//		int n = i;	//this is java autoboxing- trying to put int object into a primative and it does it for you- puts it into the stack//
//		
//		i = n; //puts this into the object variable- autoboxing again- converts 47 into an integer object//
//		
//		//don't do this a lot, but it is possible to do//
//		
//		boolean equals = i == n; //autoboxing again//
		
		//create an array below//
		int [] ports = new int[3];
		ports[0] = 80;
		ports[1] = 8080;
		ports[2] = 443;
		//have to create a new array here if you want to add more ports- to move them over create a for loop to combine them all//
		int[] newPorts = new int[4];
		
		for (int i = 0; i < ports.length; i++) {
			newPorts[i] = ports[i];
		}
		newPorts[newPorts.length - 1] = 23;
		
		
		//don't want an array if you want to be dynamic => use a list!//
		
		//tell it what you want it to hold below- want a list of Integers with '<>' telling list what it's holding//
		List<Integer> goodPorts = new ArrayList<Integer>(); 
				//goodPorts is variable declaration//
			//List is the interface and it defines what the methods are in the object- sort of like a contract//
			//List is the interface while the ArrayList is the implemtation/concrete class that implements to methods the List defines//
			//create variables that point to list not that point to the arraylist- keeps code flexible//
		goodPorts.add(80);
		goodPorts.add(8080);
		goodPorts.add(443);
		System.out.println(goodPorts);
		//to add another port- just add it- and it adds the value, but not the index unless you use the add.index//
		//or remove one (because it uses the index location)//
		goodPorts.add(23);
		goodPorts.add(0, 23);
		System.out.println(goodPorts);
		
		int removedPorts = goodPorts.remove(1);
		System.out.println(goodPorts);
		goodPorts.add(0, removedPorts);
		//then to get this to put (23, 80, 8080) need to remove the goodPorts.remove(1); below//
		goodPorts.remove(1);
		
		System.out.println(goodPorts);
		
		Integer[] allPorts = goodPorts.toArray(new Integer[goodPorts.size()]);
		
		for(int i = 0; i < goodPorts.size(); i++) {
			//.size not .length for lists => .length just for arrays//
			System.out.println("Port " + goodPorts.get(i));
		//if you have int [] a; - it says it gets whatever element is in array- int x= a[0];//	
		//uses size of list and gets elements out of it//
			
		//LinkedList implements all the same methods defined in list interface- doesn't have an array on back end//
			//change line 23 to List<Integer> goodPorts = new LinkedList<Integer>();//
			//changing the object going into variable//
			
			
		//easier way to loop through arrays- for each loops//
		for(Integer port: goodPorts) { //for each integer element in the goodPorts list; also integer has to be declared here NOT before the for loop//
			//':' is really what signifies the difference//
			System.out.println("Foreach Port " + port); //Foreach Port is the string//
			//CANNOT change array while in here- error//
			
			
			
		//set//
		Set<Integer> addresses = new HashSet<Integer>();
		addresses.add(2200);
		addresses.add(1700);
		addresses.add(2200);
		
		System.out.println(addresses);
		//set is nonduplicated, so only get 2 answers back, really no other use//
		
		//new array list of integers- HOMEWORK //
		List<Integer> orderedAddresses = new ArrayList<Integer>(addresses);
		System.out.println(orderedAddresses); //now they're in a list so now you can mess with their order- => deduplicate it)
		
		
		
		//Queue- used in messaging servers and processing//
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(45);
		queue.add(23);
		queue.add(44);
		//adds them in order//
		//while is for loop with no infinites//
		while(queue.peek() !=null) { 
			System.out.println(queue.poll()); //poll takes first element off queue entirely and returns it//
			//if you don't poll you can peek//
		}
		
		
		//Stack//
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(45);
		stack.push(23);
		stack.push(44);
		
		while( ! stack.isEmpty()) {
			System.out.println(stack.pop()); //takes something off stack, while it's not empty, and returns it//
		}
		//while class can be greater than too, not just 0 (where it says it .isEmpty --- use .size() >= 1)//
		}
		}
		
		
		
		
		
	}

}
