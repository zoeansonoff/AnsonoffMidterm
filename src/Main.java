import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		String make, model;
		int year, mpgE, mpg;
		double price;
		Vehicle[] log = new Vehicle[10];
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		Scanner keyboard = new Scanner(System.in);
		int choice, count = 0;
		File BINARYFILE = new File("Vehicles.dat");


		// Maintain an array (named log) of Vehicle objects, with a length of 10.


		//When the program first runs (before the user prompt), open the binary file (named "Vehicles.dat")
		// for reading and read all the Vehicle objects into the array.
		System.out.println("~~~Previously Recorded Vehicles~~~");

		// If the file does not exist or is empty, display the message "[No vehicles recorded.]"
		// Otherwise, loop through the array and print each of the Vehicle objects to the console.
		System.out.println("[No vehicles recorded.]");


		// In a separate loop, prompt the user with 3 options to record an EVCar (option 1),
		// GasCar (option 2) in the log. Option 3 is to display all vehicles,
		// their average price and the Vehicle with the highest price.  Option 4 is to exit.
		do {
			System.out.print(
					"\n********************************************************************\n"
							+ "**                                                                **\n"
							+ "**                 WELCOME TO THE VEHICLE LOG                     **\n"
							+ "**                                                                **\n"
							+ "********************************************************************\n"
							+ "** Please select from the following choices:                      **\n"
							+ "** 1) Record Electric Vehicle (EV) Car Data                       **\n"
							+ "** 2) Record Gas Car Data                                         **\n"
							+ "** 3) Display entire log (w/ stats)                               **\n"
							+ "** 4) Exit                                                        **\n"
							+ "********************************************************************\n"
							+ ">> ");
			choice = keyboard.nextInt();
			switch (choice) {
				case 1:

					System.out.println("Enter year  : ");
					year = keyboard.nextInt();
					System.out.println("Enter make  : ");
					keyboard.nextLine();
					make = keyboard.nextLine();
					System.out.println("Enter model : ");
					model = keyboard.nextLine();
					System.out.println("Enter price $ ");
					price = keyboard.nextDouble();
					System.out.println("Enter mpgE  : ");
					mpgE = keyboard.nextInt();

					log[count++] = new EVCar(year, make, model, price, mpgE);
					System.out.println(log[count - 1]);
					break;
				case 2:
					try {
						System.out.print("Enter year  : ");
						year = keyboard.nextInt();
						System.out.print("Enter make  : ");
						keyboard.nextLine();
						make = keyboard.nextLine();
						System.out.print("Enter model : ");
						model = keyboard.nextLine();
						System.out.print("Enter price $ ");
						price = keyboard.nextDouble();
						System.out.print("Enter mpg   : ");
						mpg = keyboard.nextInt();
						if (mpg > 250) {
							throw new TheoreticalMPGSurpassedException();
						}
						log[count++] = new GasCar(year, make, model, price, mpg);
						System.out.println(log[count - 1]);
					} catch (TheoreticalMPGSurpassedException e) {
						System.err.println(e.getMessage());
					}

					break;
				case 3:
					System.out.println("~~~ All Recorded Vehicles ~~~");
					for (int i = 0; i < count; i++) {
						System.out.println(log[i]);
					}
					System.out.println();

					System.out.println("\nThe average price of the vehicles = " + currency.format(calculateAveragePrice(log, count)));

					System.out.println("\n~~~ The Most Expensive Vehicle ~~~" + findVehicleWithHighestPrice(log, count));
					break;
				case 4:
					try {
						ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARYFILE));
						fileWriter.writeObject(log);
						fileWriter.close();
					} catch (IOException e) {
						System.err.println(e.getMessage());
					}
					break;
			}
		} while (choice != 4);

		keyboard.close();


		// If the user enters option 1, prompt for year, make, model, price, and mpgE
		// Create a new EVCar object and add it to the array.


		// Else if the user enters option 1, prompt for year, make, model, price, and mpg
		// Create a new GasCar object and add it to the array.

		// Else if the user enters option 3, display all the (non-null) objects in the array,
		// the average price of all Vehicles (formatted as currency)
		// and the Vehicle with the highest price.


		//System.out.println("\n~~~         For (+5 Points) Extra Credit           ~~~");
		//System.out.println("~~~ The 2024 Electric Vehicle w/ Highest MPGe ~~~");


		// Else if the user enters option 4 (exit), your program should write the array to the binary file
		// (named "Vehicles.dat") and exit.
		System.out.println("Have a happy and healthy spring break!");


	}

	// Create a helper method named public static double calculateAveragePrice(Vehicle[] log, int count)
	// that will find average price of ALL the vehicles in the log. Use this in your main method (under case 3).


	// Create a helper method named public static Vehicle findVehicleWithHighestPrice(Vehicle[] log, int count)
	// that will find the Vehicle with the highest price. Use this in your main method (under case 3).


	// +5 points extra credit] Create a helper method named public static EVCar find2024HighestMPGE(Vehicle[] log, int count)
	// that will find the EVCar (ignore GasCar) in 2024 (no other years) with the highest mpgE. Use this in your main method (under case 3).


	public static double calculateAveragePrice(Vehicle[] log, int count) {
		double total = 0.0;
		for (int i = 0; i < count; i++) {
			total += log[i].getPrice();
		}
		return total/count;
	}

	public static Vehicle findVehicleWithHighestPrice(Vehicle[] log, int count) {
		int HighestPrice = Integer.MIN_VALUE;
		Vehicle maxPrice = null;
		for (int i = 0; i < count; i++) {
			if (log[i] instanceof Vehicle m) {
				if (m.getPrice() > HighestPrice) {
					HighestPrice = (int) m.getPrice();
					maxPrice = m;
				}
			}



		}
		return maxPrice;
	}
}
