package com.pomiary.pomiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;


@SpringBootApplication
class Book{
	String title;
	String author;
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	public int hashCode() {
		return Integer.parseInt(author.substring(0,10));
	}
	public boolean equals(Object o) {
		Book e = (Book) o;
		return (title.equals(e.getTitle())) && (author.equals(e.getAuthor()));
	}
	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}
}
class Application {
	public static void main (String[] args) {
		LinkedList<Book> list = new LinkedList<Book>();
		Random theGenerator = new Random();
		for(int i=1 ; list.size() < 2000000; i++){
			Integer  s = theGenerator.nextInt(10)+1;
			String x = "";
			String y = "";
			int k = 0 ;
			int l = 0;
			while(k<s) {
				x = x + "a";
				k++;
			}
			while(l<s) {
				y = y +"b";
				l++;
			}
			Book book = new Book(x,y);
			list.add(book);
		}
		System.out.println(list.size());
		long begin = System.nanoTime();
		list.get(0);
		long end = System.nanoTime();
		System.out.println("Searching first element Map has taken: " + (end - begin) + "ms");
		begin = System.nanoTime();
		list.remove(0);
		end = System.nanoTime();
		System.out.println("Removing first element has taken: " + (end - begin) + "ms");
		begin = System.nanoTime();
		list.get(list.size()-1);
		end = System.nanoTime();
		System.out.println("Searching last element Map has taken: " + (end - begin) + "ms");
		begin = System.nanoTime();
		list.remove(list.size()-1);
		end = System.nanoTime();
		System.out.println("Removing last element has taken: " + (end - begin) + "ms");
		Book book1 = new Book("dama", "stan");
		begin = System.nanoTime();
		list.add(0, book1);
		end = System.nanoTime();
		System.out.println("Adding element at the begining collection has taken: " + (end - begin) + "ms");
		Book book2 = new Book("first", "lama");
		begin = System.nanoTime();
		list.add(book2);
		end = System.nanoTime();
		System.out.println("Adding element at the end of the collection has taken: " + (end - begin) + "ms");

		// zadanie część 2

		HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		int n = 0;
		while (n != 3000000) {
			Integer num1 = theGenerator.nextInt(5000000)+1;
			Integer num2 = theGenerator.nextInt(4000000)+1;
			numbers.put(num1, num2);
			n++;
		}
		System.out.println(numbers.size());
		begin = System.nanoTime();
		for(Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
			entry.getKey();
		}
		end = System.nanoTime();
		System.out.println("Searching key for Map has taken: " + (end - begin) + "ms");
		begin = System.nanoTime();
		numbers.put(300,6);
		end = System.nanoTime();
		System.out.println("Adding element to Map has taken: " + (end - begin) + "ms");
		begin = System.nanoTime();
		numbers.remove(numbers.size()-100);
		end = System.nanoTime();
		System.out.println("Removing element to Map has taken: " + (end - begin) + "ms");


	}
}

