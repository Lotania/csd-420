//Anthony Nguyen, CSD-420, Programming Assignment 4
//The purpose of the program is to demonstrate the difference in traverse speeds 
//using different methods with differently sized lists.

//everything is LinkedLists, so we only need to import these three
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.List;

public class LinkedListTraversalTest {

    public static void main(String[] args) {
        //establish lists and their sizes
        int num1_size = 50000;
        int num2_size = 500000;
        List<Integer> linkedListSmall = new LinkedList<>();
        List<Integer> linkedListBig = new LinkedList<>();

        //fill the lists with integers
        System.out.println("Writing integers to LinkedLists \nAdding " + num1_size + " numbers...");
        for (int i = 0; i < num1_size; i++) {
            linkedListSmall.add(i);
        }
        System.out.println("Adding " + num2_size + " numbers...");
        for (int i = 0; i < num2_size; i++) {
            linkedListBig.add(i);
        }
        
        // Test traversal using Iterator
        System.out.println("\nTesting traversal using Iterator..."); //nanotime = pretty common in java
        long startTimeIterator1 = System.nanoTime();
        ListIterator<Integer> iterator1 = linkedListSmall.listIterator();
        while (iterator1.hasNext()) {
            iterator1.next();
        }
        long endTimeIterator1 = System.nanoTime();
        long durationIterator1 = (endTimeIterator1 - startTimeIterator1) / 1_000_000; // Convert to milliseconds
        System.out.println("Small list travel time: " + durationIterator1 + " ms");
        
        long startTimeIterator2 = System.nanoTime();
        ListIterator<Integer> iterator2 = linkedListBig.listIterator();
        while (iterator1.hasNext()) {
            iterator1.next();
        }
        long endTimeIterator2 = System.nanoTime();
        long durationIterator2 = (endTimeIterator1 - startTimeIterator2) / 1_000_000; // Convert to milliseconds
        System.out.println("Big list travel time: " + durationIterator1 + " ms");
        
        //next to no time at all. But I think this is beause the iterator is simply iterating over both arraylists
        //the pointer is simply moving from one element to the next with referencing the indexed location of the element
        //it only needs to see that there is an element to point to. If it can point to it, it will and move right along.

        // Test traversal using get(index)
        System.out.println("\nTesting traversal using get(index)...");
        long startTimeGet1 = System.nanoTime();
        for (int i = 0; i < num1_size; i++) {
            linkedListSmall.get(i);
        }
        long endTimeGet1 = System.nanoTime();
        long durationGet1 = (endTimeGet1 - startTimeGet1) / 1_000_000; // Convert to milliseconds
        System.out.println("Small list get time: " + durationGet1 + " ms"); // That's long.
        
        long startTimeGet2 = System.nanoTime();
        for (int i = 0; i < num2_size; i++) {
            linkedListBig.get(i);
        }
        long endTimeGet2 = System.nanoTime();
        long durationGet2 = (endTimeGet2 - startTimeGet2) / 1_000_000; // Convert to milliseconds
        System.out.println("Big list get time: " + durationGet2 + " ms"); // That's even longer...
        
        //This time, the pointer is actively finding the index of the target element by referencing the index
        //of the previous elements, meaning every time an iteration of the loop finishes and a new one begins,
        //the pointer must go back to one of the previous nodes as a reference point, and proceed to the next
        //node, then to the next until it comes across the target for that iteration. Whether that previous point is
        //the preceding element, or all the way back to the beginning, I'm still not sure. Either way, it's
        //still 100 times as long as get(index)ing the small list.
    }
}