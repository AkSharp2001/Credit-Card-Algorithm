import java.util.Scanner;

public class CreditCardAlgorithm {
	
	public static void main (String[] args) {
		
		System.out.println("How many digits does your card have?" );
		try (Scanner scan = new Scanner(System.in)) {
			int digits = scan.nextInt();
			System.out.println("Enter your card number: " );
			long cardNumber = scan.nextLong();
			LuhnAlgorithm(digits, cardNumber);
		}
	}
	
	public static void LuhnAlgorithm(int digits, long cardNumber) {
		
		int[] numbers = new int[digits];
		for (int i=0; i<digits; i++) {
			numbers[i] = (int) (cardNumber % 10);
			cardNumber /= 10;
			System.out.print(numbers[i] + " ");
		}
		
		System.out.println();

		for (int i=1; i<digits; i=i+2) {
		    numbers[i]=numbers[i]*2;
		    if (numbers[i] > 9) {
		      numbers[i] -= 9;
		    }
		}
		
		System.out.println();

		for (int i=0; i<digits; i++) {
			System.out.print(numbers[i] + " ");
		}
		
		int sum = 0;

		for (int i=0; i<digits; i++) {
			sum += numbers[i];
	    }
		
		System.out.println("\n");

		
		System.out.println(sum);
		
		System.out.println();

		
		if (sum % 10 == 0) {
			System.out.println("This is a valid credit card number!");
		}
		else {
			System.out.println("This is not a valid credit card number!");
		}
	}
}
