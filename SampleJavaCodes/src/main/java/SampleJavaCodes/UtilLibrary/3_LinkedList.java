/**
 * The linked list is a linked list, which has a queue like structure. 
 * It also allows random access to elements.
 * 
 */

package SampleJavaCodes.UtilLibrary;
import java.util.*;

class LinkedListExample{
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<String>();

        linkedList.add("Parmi");
        linkedList.add("Entre");
        linkedList.addLast("Add this item to the end");
        System.out.println(linkedList);

        linkedList.remove(); // Removes the head, which is the first element.
        System.out.println(linkedList);

        linkedList.remove(0); // Removes the zeroth element.
        System.out.println(linkedList);
        
    }
}