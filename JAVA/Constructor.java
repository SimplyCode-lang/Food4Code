import java.util.*;

public class Constructor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		aircraft airbus747 = new aircraft(280, 800, 6789.90, 90.8); //object of class
		System.out.println("Airbus747");
		System.out.println(airbus747.print());
		
		System.out.println("\nDetails of Cars");
		String name = scan.next();
		
		cars newCar = new cars(name, 28, 5, 280);
		System.out.println(newCar.printCar());
		
		scan.close();
	}
}

class aircraft {
	int passanger; //instance variables
	int cruiseSpeed;
	double fuelCapacity;
	double fuelBurnRate;
	
	//declaring a CONSTRUCTOR of a class
	//A constructor of a class is a special method that 
	//gets called when a class is instantiated using the NEW function.
	public aircraft (int passanger, int cruiseSpeed, double fuelCapacity, 
	double fuelBurnRate) {
		this.passanger = passanger;
		this.cruiseSpeed = cruiseSpeed;
		this.fuelBurnRate =  fuelBurnRate;
		this.fuelCapacity = fuelCapacity;
	} // constructor close
	
	
	//method 1 (to the constructor)
	public int getPassanger() {
		return passanger;
	}
	
	//method 2
	public int getSpeed() {
		return cruiseSpeed;
	}
	
	//method 3
	public double getCapacity() {
		return fuelCapacity;
	}
	
	//method 4
	public double getBurnRate() {
		return fuelBurnRate;
	}
	
	//overriding
	public String print() {
		return ("Your aircraft can hold " + this.getPassanger() + 
				" passangers,\nhas the top speed of " + this.getSpeed()
				+ " knotts.\nIt has a fuel capacity " + this.getCapacity()
				+ " gallons,\nand it consumes " +this.getBurnRate() 
				+ " gallons/perhour");
		
	}
	
}

class cars {
	String carName;
	int passangers;
	int milage;
	int topSpeed;
	
	public cars(String carName, int passangers, int milage, int topSpeed) {
		this.carName = carName;
		this.milage = milage;
		this.passangers = passangers;
		this.topSpeed = topSpeed;
	}
	
	public String getName() {
		return carName;
	}
	
	public int getPassangers() {
		return passangers;
	}
	
	public int getMilage() {
		return milage;
	}
	
	public int getSpeed() {
		return topSpeed;
	}
	//overriding
	public String printCar() {
		return(this.getName() +"\n" +this.getMilage() +"\n"+ this.getPassangers() +"\n"+ this.getSpeed());
	}
}
