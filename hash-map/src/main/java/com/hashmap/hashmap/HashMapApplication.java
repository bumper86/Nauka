package com.hashmap.hashmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.lang.*;
import java.io.*;
@SpringBootApplication


class Student{
	String firstName;
	String lastName;
	String peselId;

	public Student(String firstName, String lastName, String peselId){
		this.firstName = firstName;
		this.lastName = lastName;
		this.peselId = peselId;
	}

	public boolean equals(Student e){
		return (this.firstName == e.firstName) && (this.lastName == e.lastName) &&
				(this.peselId == e.peselId);
	}

	public int hashCode(){
		return Integer.parseInt(peselId.substring(0, 5));
	}

	public String toString(){
		return firstName + " " + lastName + " (" + peselId + ")";
	}
}

class Rating {
	Double math;
	Double lang;
	Double sport;
	Double geog;
	Rating(Double math, Double lang, Double sport, Double geog){
		this.math = math;
		this.lang = lang;
		this.sport = sport;
		this.geog = geog;
	}

	public Double getMath() {
		return math;
	}
	public Double getLang() {
		return lang;
	}
	public Double getSport() {
		return sport;
	}
	public Double getGeog() {
		return geog;
	}
	public String toString() {
		return math + " " + lang + " " + sport + " " + geog;
	}
}
class HashMapStudent
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Student student1 = new Student("Janusz", "Kowal", "12345678901");
		Student student2 = new Student("Karol", "Januszewski", "52345898321");
		Student student3 = new Student("Anna", "Krasuk", "87523901297");
		Student student4 = new Student("Janina", "Sam", "35678234901");

		Rating rating1 = new Rating(2.0,3.0,4.0,5.0);
		Rating rating2 = new Rating(5.0,1.0,5.0,6.0);
		Rating rating3 = new Rating(3.0,3.0,2.0,4.0);
		Rating rating4 = new Rating(6.0,6.0,5.0,5.0);

		HashMap<Student, Rating> studentRating = new HashMap<Student,Rating>();

		studentRating.put(student1, rating1);
		studentRating.put(student2, rating2);
		studentRating.put(student3, rating3);
		studentRating.put(student4, rating4);
		Double average = 0.0;
		for(Map.Entry<Student, Rating> entry : studentRating.entrySet()) {
			average = (entry.getValue().math + entry.getValue().lang + entry.getValue().sport + entry.getValue().geog) / studentRating.size();
			System.out.println("Student of " + entry.getKey() + " has average =  " + average);
		}
	}
}