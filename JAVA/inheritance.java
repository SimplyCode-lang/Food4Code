import java.util.*;

public class inheritance{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String dogBreed = scan.next();
		animal a =new animal();
		dog b = new dog();
		b.breed(dogBreed);
		a.move();
		b.move(dogBreed);
		b.move();
		b.food();
		
		scan.close();
	}
}

class animal{
	public void move() {
		System.out.println("Animals can move");
	}
	public void food() {
		System.out.println("They need special diets, consult a vet");
	}
}

class dog extends animal{
	public  void breed(String breed) {
		System.out.println("This dog is a " + breed );
	}
	public void move() {
		System.out.println("Dogs can walk and run");
	}
	public void move(String breed) {
		System.out.println(breed +" can walk and run");
	}
}
