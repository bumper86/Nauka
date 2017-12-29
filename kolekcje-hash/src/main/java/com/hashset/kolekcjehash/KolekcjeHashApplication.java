package com.hashset.kolekcjehash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.*;
@SpringBootApplication


class Employee {
	String firstName;
	String lastName;
	LocalDate birthDate;

	public Employee(String firstName, String lastName, int yearOfBirth,
					int monthOfBirth, int dayOfBirth){
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public int hashCode(){
		return birthDate.getYear() * 100 + birthDate.getMonthValue();
	}

	public boolean equals(Object o){
		Employee e = (Employee) o;
		return (firstName.equals(e.getFirstName())) &&
				(lastName.equals(e.getLastName())) &&
				(birthDate.getYear() == e.getBirthDate().getYear()) &&
				(birthDate.getMonthValue() == e.getBirthDate().getMonthValue()) &&
				(birthDate.getDayOfMonth() == e.getBirthDate().getDayOfMonth());
	}

	public String toString(){
		return firstName + ", " + lastName + ", born: " + birthDate;
	}

	// getters
	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public LocalDate getBirthDate(){
		return birthDate;
	}
}

class HashSetExample
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Employee worker1 = new Employee("Steven", "Newmack", 1987, 6, 30);
		Employee worker2 = new Employee("Jennifer", "Nowak", 1988, 2, 28);
		Employee worker3 = new Employee("Robert", "Greenfield", 1987, 6, 15);
		Employee worker4 = new Employee("Monica", "Smith", 1984, 10, 18);
		Employee worker5 = new Employee("Stephanie", "Jackson", 1985, 4, 3);

		HashSet<Employee> workersSet = new HashSet<Employee>();
		workersSet.add(worker1);
		workersSet.add(worker2);
		workersSet.add(worker3);
		workersSet.add(worker4);
		workersSet.add(worker5);

		for(Employee theWorker: workersSet){
			if(theWorker.getBirthDate().getYear() >= 1986){
				System.out.println(theWorker);
			};
		}
	}
}