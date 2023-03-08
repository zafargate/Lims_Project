package collectionFrameWorkPractice;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo2 {
	public static void main(String[] args) {

		ArrayList al = new ArrayList();

		al.add("x");
		al.add("a");
		al.add("z");
		al.add("b");
		al.add("c");
		al.add("d");
		al.add("e");
		al.add("f");

		ArrayList dp = new ArrayList();

		dp.addAll(al);
		System.out.println(dp);

		dp.removeAll(al);
		System.out.println(dp);

		Collections.sort(al);
		System.out.println(al);
		Collections.sort(al, Collections.reverseOrder());
		System.out.println(al);

		// Shuffling
		Collections.shuffle(al);
		System.out.println(al);

	}

}
