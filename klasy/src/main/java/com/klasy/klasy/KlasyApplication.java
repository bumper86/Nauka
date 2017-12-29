package com.klasy.klasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
interface Employee {

	double calculateSalary();

}

class FixedSalaryEmployee implements Employee {

	private double product;

	public FixedSalaryEmployee(double product) {
		this.product = product;
	}

	public double calculateSalary() {
		return 5 * this.product;
	}

}

class HourlySalaryEmployee implements Employee {

	private double salary;
	private double numberSold;

	public HourlySalaryEmployee(double salary, double numberSold) {
		this.salary= salary;
		this.numberSold = numberSold;
	}

	public double calculateSalary() {
		return this.salary + this.numberSold * 0.2 * this.salary;
	}

}

// Payout
abstract class SalaryPayout {

	private Employee employee;

	public SalaryPayout(Employee employee) {
		this.employee = employee;
	}

	protected abstract void payout();

	public void processPayout() {
		System.out.println("Creating payout for: " + this.employee.calculateSalary() + " PLN");
		this.payout();
		System.out.println("Payout has been completed!");
	}

}

class SalaryPayoutProcessor extends SalaryPayout {

	public SalaryPayoutProcessor(Employee employee) {
		super(employee);
	}

	protected void payout() {
		System.out.println("Sending money to employee");
	}

}

class Application {

	public static void main(String args[]) {

		FixedSalaryEmployee employee = new FixedSalaryEmployee(10);
		HourlySalaryEmployee employee1 = new HourlySalaryEmployee(2000, 0);

		SalaryPayoutProcessor processor = new SalaryPayoutProcessor(employee1);
		processor.processPayout();

		SalaryPayoutProcessor processor2 = new SalaryPayoutProcessor(employee);
		processor2.processPayout();

	}

}