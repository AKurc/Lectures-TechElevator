package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {
		
		Cow burger = new Cow("Buger", 1500s);
		Chicken nugget = new Chicken("Nugget", 30);
//		Animal sue = new Chicken(); //but cannot say Animal sue = new Animal();
//		
//		nugget.layEgg(); //system has to know it's in the chicken class in order to access chicken code
//		sue.getSound(); //get sound is defined in chicken => will cluck //this line doesn't indicate that sue's a chckn, so it's an animal =>sellable, singable
//		
//		//to get sue to lay an egg- must explicitly cast it back to a chicken
//		Chicken sueTheChicken = (Chicken)sue;
//		sueTheChicken.layEgg();
		
		burger.setSleeping(true);
		
		System.out.println(burger.makeSound()); //want cow to make a sound
		
		Singable[] singables = new Singable[] { burger, nugget, new Tractor(), new Cat() };
		
		for(Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound(); 
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
			System.out.println("With a "+sound+" "+sound+" here");
			System.out.println("And a "+sound+" "+sound+" there");
			System.out.println("Here a "+sound+" there a "+sound+" everywhere a "+sound+" "+sound);
			System.out.println();
		}
		Sellable[] products = new Sellable[] { burger, nugget, new Apple() };
		for(Sellable stuff : products) {
			System.out.println("Hey, we have " + stuff.getName() + " for only $" + stuff.getPrice());
		}
	}
	
	
}