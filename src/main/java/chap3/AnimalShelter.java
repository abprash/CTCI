package chap3;

import java.util.LinkedList;
import java.util.List;

public class AnimalShelter {
	
	//page 99, 3.6
	//has only cats and dogs
	//shelter operates on a strictly FIFO basis
	//ppl must adopt either
		//the oldest pet which came in first
		//or they get a choice between a cat and a dog, and must take the oldest pet type.
	
	//methods to implement
	//enqueue, dequeueAny, dequeueDog, dequeueCat
	
	//solution
	//have 2 queues - cats and dogs - keep inserting in the end and go on
	//assuming pets are assigned nos. in chronological order
	//lesser num indicates seniority
	
	LinkedList<Integer> catList;
	LinkedList<Integer> dogList;
	
	public AnimalShelter(){
		catList = new LinkedList<Integer>();
		dogList = new LinkedList<Integer>();
	}
	
	public void enqueue(boolean isCat, int petNum){
		if(isCat){
			catList.addLast(petNum);
		}
		else{
			dogList.addLast(petNum);
		}
	}
	
	public Integer dequeueCat(){
		if(!catList.isEmpty())
			return catList.removeFirst();
		else
			return null;
	}
	
	public Integer dequeueDog(){
		if(!dogList.isEmpty())
			return dogList.removeFirst();
		else
			return null;
	}
		public Integer dequeueAny(){
			//get the first element in both lists
			//return the smallest num between the two
			int cat = catList.getFirst();
			int dog = dogList.getFirst();
			//pop the one lesser
			
			return cat < dog ? catList.removeFirst():dogList.removeFirst();
		}
	

}

/*class Pet{
	public String petType;
	public
}*/
