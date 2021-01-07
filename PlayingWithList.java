package Week4.day1;

import java.util.ArrayList;
import java.util.Collections;

public class PlayingWithList {

	public static void main(String[] args) {
		 ArrayList<String> al = new ArrayList<String>(); 
	        al.add("Black(13)"); 
	        al.add("white(2)"); 
	        al.add("Blue(3)"); 
	        al.add("red(15)"); 
	        al.add("Saff(25)"); 
	  
	        /* Collections.sort method is sorting the 
	        elements of ArrayList in ascending order. */
	        Collections.sort(al, Collections.reverseOrder()); 
	  
	        // Let us print the sorted list 
	        System.out.println("List after the use of" + 
	                           " Collection.sort() :\n" + al); 

	}

}
