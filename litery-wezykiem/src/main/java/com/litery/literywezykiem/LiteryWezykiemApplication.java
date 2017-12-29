package com.litery.literywezykiem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.lang.*;
import java.io.*;
@SpringBootApplication



class Allocator {

	ArrayList<String> evenNumbersOfLetters = new ArrayList<String>();
	ArrayList<String> oddNumbesOfLetters = new ArrayList<String>();

	public void allocate(ArrayDeque<String> checkAndAssign) {
		while(checkAndAssign.size() != 0 ) {
			int stringLenght = checkAndAssign.peek().length();
			if (stringLenght % 2 == 0) {
				evenNumbersOfLetters.add(checkAndAssign.pop());
			}
			else {
				oddNumbesOfLetters.add(checkAndAssign.pop());
			}
		}
		System.out.println("\n Collection of even: ");
		for (int n=0; n< evenNumbersOfLetters.size(); n++) {
			System.out.println( n + " " + evenNumbersOfLetters.get(n));
		}
		System.out.println("\n Collection of odd: ");
		for (int m=0; m< oddNumbesOfLetters.size(); m++) {
			System.out.println( m + " " + oddNumbesOfLetters.get(m));
		}
	}

}

class Kodilla {
	public static void main (String[] args) {
		ArrayDeque<String> letterA = new ArrayDeque<String>();

		Random theGenerator = new Random();
		System.out.println("Collection : ");
		for(int i=1; letterA.size() < 50; i++){
			Integer  s = theGenerator.nextInt(50)+1;
			String x = "";
			int k = 0 ;
			while(k<s) {
				x = x + "a";
				k++;
			}
			letterA.offer(x);
			System.out.println("Number " + i +" " + x);
		}

		Allocator allocator = new Allocator();
		allocator.allocate(letterA);
	}
}