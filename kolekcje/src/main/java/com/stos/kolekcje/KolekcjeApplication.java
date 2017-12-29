package com.stos.kolekcje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.*;
@SpringBootApplication


class Book {
	String title;
	String author;
	Integer yearEdition;
	public Book(String title, String author, Integer yearEdition) {
		this.title = title;
		this.author = author;
		this.yearEdition = yearEdition;
	}
	public String toString(){
		return "Title: \"" + title + "\", author: " + author + ", (" + yearEdition + ")";
	}
	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public Integer getYearEdition(){
		return yearEdition;
	}
}
class Application {
	public static void main (String[] args) {
		Book book1 = new Book("50 shades of Grey", "Jan Kowalski",  2000);
		Book book2 = new Book("Sherlock Holmes", "Zbigniew Kama", 2015);
		Book book3 = new Book("The Last Mohikan", "James Smith", 2019);
		Book book4 = new Book("The infinity", "Samantha Fils", 1992);
		Book book5 = new Book("Better Call Soul", "Karol Malusinski", 1987);

		ArrayDeque<Book> theBooks = new ArrayDeque<Book>();

		System.out.println("Library has: " +theBooks.size() + " books");
		System.out.println();

		theBooks.push(book1);
		theBooks.push(book2);
		theBooks.push(book3);
		theBooks.push(book4);
		theBooks.push(book5);

		System.out.println("Library has: " + theBooks.size() + " books\n");

		Book theLast = null;

		while(!theBooks.isEmpty()) {
			theLast = theBooks.pop();
		}

		System.out.println("Library has: " + theBooks.size() + " books \n");
		System.out.println("The last one book was:\n " + theLast);


	}
}