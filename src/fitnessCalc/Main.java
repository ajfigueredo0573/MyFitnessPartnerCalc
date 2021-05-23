package fitnessCalc;
//Alejandro Figueredo
/*This program has the idea of helping the user set goals towards lifting, 
 * and help them achieve those goals by telling them the process they are making.
 * 			§ Byte:  saving memory in large arrays.
			§ Short:   same as byte.
			§ Int: represent an unsigned 32-bit integer.
			§ Long: use when in need of a wider range than those provided by int.
			§ Float: saving memory in large arrays (use this instead of double).
			§ Double: default for decimal values.
			§ Boolean: true or false conditions.
			§ Char: single (Unicode) character.*/
//Variable are boxes that you can put code in.
//Scope is when a variable is accessible only in the method where it was defined
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name:");
		String clientOne = scan.nextLine();
		System.out.println("Hello " + clientOne + "!");
		
		System.out.println("Welcome to Your Fitness Partner Calculator!!");
		boolean enjoyToWorkout = false;
		final double LBS_IN_KG;
		LBS_IN_KG = 2.2;
		//A final variable is a value that cannot be modified
		System.out.println("Does people enjoy working out alone?" + enjoyToWorkout + ".");
		System.out.print("Why? Because sometimes finding motivation by yourself is hard");
		System.out.println(" here it's an app that can help you with that.");
		
		UserData alejandro = new UserData();
		alejandro.age = 21;
		alejandro.weight = 250;
		
	}

}
