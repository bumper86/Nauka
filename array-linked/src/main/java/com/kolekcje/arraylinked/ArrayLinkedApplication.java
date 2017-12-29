package com.kolekcje.arraylinked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.lang.*;
import java.io.*;
@SpringBootApplication


class Book {
	String title;
	int year;

	public Book (String title, int year) {
		this.title = title;
		this.year = year;
	}
	public String toString() {
		return title + " " + year;
	}
}
class Kodilla {
	public static void main (String[] args) {
		System.out.println("Zadanie 1.");
		ArrayList<Integer> it = new ArrayList<Integer>();
		it.add(5);
		it.add(6);
		it.add(2);
		it.add(1);
		it.add(4);
		it.add(4);
		it.add(3);
		it.add(6);
		it.add(2);
		it.add(1);
		int max = it.get(0);
		int min = it.get(0);
		double sum = 0;
		for(Integer user : it){
			if (user>max) {
				max = user;
			}
			if (user<min) {
				min = user;
			}
			sum = (sum + user);
		}

		System.out.println("Average of IT is " + (sum - min - max) / (it.size() - 2));

		System.out.println();
		System.out.println("Zadnie 2.");

		LinkedList<Book> books = new LinkedList<>();

		books.add(new Book("50 shades of Grey", 2000));
		books.add(new Book("Sherlock Holmes", 1995));
		books.add(new Book("The Last Mohikan", 2009));
		books.add(new Book("The infinity", 1992));
		books.add(new Book("Better Call Soul", 1987));
		books.add(new Book("A Journey Into the Earth", 2001));
		books.add(new Book("Binary Death", 2005));

		for(Book name: books) {
			if (name.year >= 2000) {
				System.out.println(name);
			}

		}
	}
}