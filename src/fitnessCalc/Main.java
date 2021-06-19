package fitnessCalc;

//Alejandro Figueredo
/*This program has the idea of helping the user set goals towards lifting, 
 * and help them achieve those goals by telling them the process they are making.
 * 			§ byte:  saving memory in large arrays.
			§ short:   same as byte.
			§ int: represent an unsigned 32-bit integer.
			§ long: use when in need of a wider range than those provided by int.
			§ float: saving memory in large arrays (use this instead of double).
			§ double: default for decimal values.
			§ boolean: true or false conditions.
			§ char: single (Unicode) character.*/
//Variable are boxes that you can put code in.
//Scope is when a variable is accessible only in the method where it was defined
/* operator precedence:
*= += -= *= /= %=	AssignmentRight to left
? :	Ternary conditional	Right to left
||	Logical OR	Left to right
&&	Logical AND	Left to right
|	Bitwise inclusive OR	Left to right
^	Bitwise exclusive OR	Left to right
&	Bitwise AND	Left to right
!= ==	Relational is not equal to  Relational is equal to	Left to right
< <= > >= instanceof	Relational less than Relational less than or equal Relational greater than Relational greater than or equal
Type comparison (objects only)	Left to right
>> <<> >>	Bitwise right shift with sign extension
Bitwise left shift
Bitwise right shift with zero extension	Left to right
- +	Subtraction Addition	Left to right
* / %	Multiplication Division Modulus	Left to right
- + ~ ! ( type)	Unary minus
++ --	Unary post-increment Unary post-decrement	Right to left
· () []	Dot operator Parentheses Array subscript	Left to Right
Inheritance is the process when one class acquires the properties of another one. 
With the use of inheritance the information is made manageable in a hierarchical order (using the keyword extend)
Polymorphism is define to a principle in which an organism can have many different forms (stages).*/
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name:");
		String clientOne = scan.nextLine();
		String greetings = "Hello";
		greetings += " ";
		greetings += clientOne;
		greetings += "!";
		System.out.println(greetings);

		System.out.println("Welcome to Your Fitness Partner Calculator!!");
		boolean enjoyToWorkout = false;
		System.out.println("Does people enjoy working out alone? " + enjoyToWorkout + ".");
		System.out.printf("Why?\nBecause sometimes finding motivation by yourself is hard");
		System.out.println(" here it's an app that can help you with that.");

		firstClient firstClient = new firstClient();
		System.out.println("Enter your age: ");
		int yourAge = 0;
		boolean correctInput = false;
		while(correctInput == false) {
			try {
			yourAge = scan.nextInt();
			correctInput = true;
			}
			catch(Exception e) {
				System.out.println("Incorrect input. Please insert a whole number! ");
				scan.nextLine();
			}	
		}
		System.out.println("Enter your weight: ");
		double yourWeight = scan.nextDouble();
		firstClient.setAge(yourAge);
		firstClient.setWeight(yourWeight);
		System.out.println("Your age is " + firstClient.getAge());
		System.out.println("Your weight is " + firstClient.getWeight());
		System.out.println("Is this information right? true or false ");
		boolean response = scan.nextBoolean();
		while (response != true) {
			System.out.println("Sorry! Try again");
			scan.nextLine();
		}

		System.out.println("Great");

		double weightInKg = convertLbsToKg(firstClient.getWeight());
		System.out.println("Your weight in KG is " + weightInKg);

		int hoursPlannedToExercise;
		do {
			System.out.println("Enter hours planned to spend exercising(0-5):");
			hoursPlannedToExercise = scan.nextInt();
			if (hoursPlannedToExercise >= 0 && hoursPlannedToExercise <= 5) {
				break; // stops the loop immediately
			} else {
				continue; // opposite of break statement. It forces the loop to the next iteration.
			}
		} while (hoursPlannedToExercise < 0 && hoursPlannedToExercise > 5);
		System.out.println("The goal is to exercise " + hoursPlannedToExercise + "");

		System.out.println("How many goals related to fitness do you have? (0-1)");
		int numberOfGoals = scan.nextInt();
		for (int goalSet = 0; goalSet < numberOfGoals; goalSet++) {
			System.out.println("Name your goal:");
			String goalByUser = scan.nextLine();
			System.out.println(goalByUser);
		}

		System.out.println("Let's calculate you Body Mass Index (BMI):");
		System.out.println("How tal are you? (inch)");
		int userHeight = scan.nextInt();
		double heightInMeter = (double) (convertInchToMeter(userHeight));
		System.out.println("Your height in KG is " + heightInMeter);

		int BMI;
		BMI = (int) (weightInKg / Math.pow(heightInMeter, 2));
		// casting is when you assign a value of one primitive data type to another type
		// (shown above)
		System.out.println("Your Body Mass Index is " + BMI);
		if (BMI < 18.5) {
			System.out.println("Underweight");
		} else if (BMI >= 18.5 && BMI < 24.9) {
			System.out.println("Normal weight");
		} else if (BMI >= 25 && BMI < 29.9) {
			System.out.println("Overweight");
		} else {
			System.out.println("Overweight");
		}

		System.out
				.println("Your Basal Metabolic Rate is " + calculationOfBMRForMen(weightInKg, heightInMeter, yourAge));

		double BRMForMen = calculationOfBMRForMen(weightInKg, heightInMeter, yourAge);
		double max = BRMForMen > BMI ? BRMForMen : BMI;
		System.out.println("Your max is your " + max);

		System.out.println("Rate your reaction after seeing your esults using this scale:");
		System.out.print("1.Sad  ");
		System.out.print("2.Shocked  ");
		System.out.println("3.Happy");
		String userReaction = scan.nextLine();
		if (userReaction == "sad" || userReaction == "shocked") {
			System.out.println("No need to be. Let's get to work!");
		} else {
			System.out.println("Good work! Let's keep working!");
		}

		Random exerciseList = new Random();
		int numberExercise = 1 + exerciseList.nextInt(3);
		String typeOfExercise;
		switch (numberExercise) {
		case 1:
			typeOfExercise = "squats";
			break;
		case 2:
			typeOfExercise = "barbell bench";
			break;
		case 3:
			typeOfExercise = "deadlift";
			break;
		default:
			typeOfExercise = "Invalid";
			break;
		}
		System.out.println(typeOfExercise);

		String exercise1 = "deadlift", exercise2 = "bench";
		int comparison = exercise1.compareTo(exercise2);
		if (comparison < 0) {
			System.out.println("deadlift is greater than bench");
		} else if (comparison == 0) {
			System.out.println("deadlift is equal to bench");
		} else {
			System.out.println("deadlift is less than bench");
		}

		System.out.println(exercise1.equals(exercise2));
		/*
		 * == operator is used to compare two or more than two objects. If they are
		 * referring to the same object then return true, otherwise return false.
		 */
		double idealWeightForSquat = yourWeight * 1.5;

		System.out.println("Let us find the minimun value of your squatting so far");
		System.out.println("How many values would you like to compare?");
		int valuesBeingCompared = scan.nextInt();
		int[] liftingNum = new int[valuesBeingCompared];
		System.out.println("Insert first number: ");
		liftingNum[0] = scan.nextInt();
		int smallestValue = liftingNum[0];
		int indexOfMax = 0;
		boolean found = false;
		for (int num = 1; num < liftingNum.length; num++) {
			System.out.println("Insert next number: ");
			liftingNum[num] = scan.nextInt();
			if (liftingNum[num] < smallestValue) {
				smallestValue = liftingNum[num];
			}
		}
		while (found == false && indexOfMax < liftingNum.length) {
			if (liftingNum[indexOfMax] >= idealWeightForSquat) {
				found = true;
			} else {
				indexOfMax++;
			}
		}

		if (found) {
			System.out.println("You achieve your potential lift on lift number " + (indexOfMax + 1));
		} else {
			System.out.println("You did not achieve your potential lift");
		}

		System.out.println("Your smallest lift value is: " + smallestValue);
		System.out.println("Your smallest lift value is: " + smallestValue);

		int sumOfValues = 0;
		for (int values : liftingNum) {
			sumOfValues += values;
		}
		System.out.println("The accumulation of all your lifts is: " + sumOfValues);
		
		String [][] weightLiftingTable = {
				{"O.R.M","75%","50%"},
				{"100","75","50"},
				{"250","187.5","125"}
		};
		
		for (int row =0; row < weightLiftingTable.length; row++) {
			for(int col = 0; col < weightLiftingTable[row].length; col++) {
				System.out.print(weightLiftingTable[row][col] + "\t");
			}
			System.out.println();
		}
		
		ArrayList<String> chestExercises = new ArrayList <String>();
		chestExercises.add("Flat barbell bench press");
		chestExercises.add("Incline barbell bench press");
		chestExercises.add("Flat dumbbell bench");
		chestExercises.add("Incline dumbbell bench");
		chestExercises.add("Push-ups");
		
		System.out.print("For the days you plan to work upper body (chest day), here are");
		System.out.println(" some exercise that I recommend:");
		System.out.println(chestExercises);
		
		
		scan.close();
	}

	public static double convertLbsToKg(double weight /* this is a parameter */) { // This line is called a header
		double LBS_IN_KG = 3.2;
		--LBS_IN_KG;
		// A final variable is a value that cannot be modified
		double weightInKg = weight / LBS_IN_KG;
		return weightInKg;
		// The variable you pass in a method is called an argument
		// A method is a group of statements that have a name.
	}

	public static double convertInchToMeter(double height /* this is a parameter */) {
		final double INCH_TO_METER = 0.0254;
		double heightInMeter = height * INCH_TO_METER;
		return heightInMeter;
	}

	public static double calculationOfBMRForMen(double weight, double height, int age) {
		double BMRForMale = (10 * weight) + (625 * height) - (5 * age) + (15 % 10);
		return BMRForMale;
	}
}
