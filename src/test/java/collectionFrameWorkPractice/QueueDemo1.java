package collectionFrameWorkPractice;

import java.util.LinkedList;
import java.util.PriorityQueue;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;

public class QueueDemo1 {

	public static void main(String[] args) {
		
	//	PriorityQueue q=new PriorityQueue();
		LinkedList q=new LinkedList();
		
		//Adding element
		q.add("A");
		q.add("B");
		q.add("c");
		q.add("d");
		q.add("f");
		q.add("f");
		q.add(100); // not allowed in queue becouse hetroginious data is not allowed
		
		System.out.println(q);
		
//		//get head Elemet
		System.out.println(q.element());//A in case of empty thow exception
		System.out.println(q.peek()); //A in case of empty return null
//		
//		// return remove element
//		
		System.out.println(q.remove()); // in case of empty he will throw Exception
		System.out.println(q);
    	System.out.println(q.poll());
		System.out.println(q);
		
		java.util.Iterator it = q.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
