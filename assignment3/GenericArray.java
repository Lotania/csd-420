//Anthony Nguyen, CSD-420, 09/28/2025
//THE PURPOSE OF THIS PROGRAM IS TO DEMONSTRATE BASIC GENERICS, USING SETS

import java.util.*;//for arraylist, linkedhashset, and random

public class GenericArray {
	//generic method will take any array and remove duplicated
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){//only one type <E> is needed
		//use a LinkedHashSet, which maintains order; unlike Set, which arranges everything
		LinkedHashSet<E> editedList = new LinkedHashSet<>(list);
		return new ArrayList<E>(editedList);
	}
	
	public static void main(String[] args) {
		//creating arraylist of 50 random integers from 1 to 20
		ArrayList<Integer> randint = new ArrayList<Integer>();
		Random randundant = new Random();
		
		for(int i = 0; i <50; i++){
			randint.add(i, randundant.nextInt(20) + 1);
		}
		
		//two different printlns to compare outputs
		System.out.println("First arraylist result: " + randint);
		ArrayList<Integer> oneoff = removeDuplicates(randint);
		System.out.println("\nSecond arraylist result: " + oneoff);
		//in less than 30 lines of code.
	}
}