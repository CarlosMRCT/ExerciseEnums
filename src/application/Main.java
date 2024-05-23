package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner tc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter department's name: ");
		String name = tc.nextLine();
		System.out.println("Name: ");
		String workerName = tc.nextLine();
		System.out.println("Level: ");
		String workerLevel = tc.nextLine();
		System.out.println("Base salary: ");
		double baseSalary = tc.nextDouble();
		Department department = new Department (name);
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, department);
		
		System.out.println("How many contracts to this worker? ");
		int x = tc.nextInt();
		for(int i = 0; i < x; i++) {
			System.out.println("Enter contract nº" + (i + 1));
			System.out.println("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(tc.next());
			System.out.println("Value per hour: ");
			double perHour = tc.nextDouble();
			System.out.println("Duration (hours): ");
			int hours = tc.nextInt();
			HourContract contract = new HourContract(contractDate, perHour, hours);
			worker.addContract(contract);
			
		}
		System.out.println();
		System.out.println("Enter Month to calculate income: ");
		int month = tc.nextInt();
		System.out.println("Enter Year to calculate income: ");
		int year = tc.nextInt();
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + month + "/" + year + ": " + worker.income(year, month));
		
		
	}

}
