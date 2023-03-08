package Vtiger_Project_Practice;

import java.util.Iterator;
import java.util.Random;

public class GanretRandomNumber {
	
	public static void main(String[] args) throws InterruptedException {
		
		Random rendom=new Random();
		int ran=rendom.nextInt(1000);
		String name="Zafar"+ran;
		System.out.println(name);
//	
//		for (int i = 0; i <10; i++) {
//			System.out.println(ran);
//			Thread.sleep(500);
//		}
	}

}
