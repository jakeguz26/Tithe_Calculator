package app;
import java.util.*;
import java.io.*;
import java.text.*	;

public class Calculator {
	
	// Declaration for the ArrayList object
	private ArrayList<Double> incomeList;
	private double totalIncome = 0;
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
	
	// Constructor for my Calculator object
	public Calculator () {
		
		incomeList = new ArrayList<Double>();
	}
	
	public void CalculateTotal() {
		
		for (Double income : incomeList) {
			totalIncome += income;
		}
		
		String formattedAmount = currencyFormatter.format(totalIncome);
		System.out.println("Your total income is: " + formattedAmount);
	}
	
	public void CalculateTithe() {
		
		// Calculate the tithe amount and then pass the value to the currencyFormatter object
		double titheAmount = (totalIncome * .12);
		String formattedAmount = currencyFormatter.format(titheAmount);
		
		System.out.println("You should tithe: " + formattedAmount);
	}
	
	public void CalculateSavings() {
		
		double saveAmount = (totalIncome * .09);
		String formattedAmount = currencyFormatter.format(saveAmount);
		
		System.out.println("You should save: " + formattedAmount);
	}
	
	// Getter for my incomeList element
	public ArrayList<Double> getIncomeList() {
		
		return incomeList;
	}

	// MAIN METHOD //
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		String filePath = "INCOME.txt";
		
		try { 
			
			Scanner scanner = new Scanner(new File(filePath));
			
			while(scanner.hasNextDouble()) {
				
				double income = scanner.nextDouble();
				calculator.getIncomeList().add(income);
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			
			System.err.println("File not found: " + filePath);
            e.printStackTrace();
		}
		
		calculator.CalculateTotal();
		calculator.CalculateTithe();
		calculator.CalculateSavings();
	}

}
