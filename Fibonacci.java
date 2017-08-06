import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
    long even = 0;
    long odd = 1;        
    long toPrint = 0; // use this in printing to prevent stack overflows
	long to_go_to = getLong("Enter the number of terms in the Fibonacci series to which to print (nth number), using 0 as the 0th term. Due to stack overflow errors, the maximum number of terms is 93 (to 92nd term).");
        
    for (long i = 0; i <= to_go_to && (toPrint > 0 || i < 2); i++) {
        if (i %2 == 0) { // an even term no
            toPrint = even;
            even += odd;
        }
        else { // at an odd term no
            toPrint = odd;
            odd += even;
        }
        if (toPrint > 0 || i < 2) System.out.println(i + getOrdinal(i) + " term; value: " + toPrint);
    }
	System.out.println("Program done.");
	}
    
    public static String getOrdinal(long i) {
        byte penDigit = (byte) ((i / 10) % 10); // penultimate - second to last
        byte lastDigit = (byte) (i % 10);
        if (penDigit != 1) {
            if (lastDigit == 1) {
                 return "st";
            }
            if (lastDigit == 2) {
                return "nd";
            }
            if (lastDigit == 3) {
                return "rd";
            }
        } 
        return "th";
    }
    
    public static long getLong(String instructions) {
	System.out.println(instructions);
        boolean inputWasValid = false;
        Scanner reader = new Scanner(System.in);
        long toReturn = -1;
        try {
            long input = (long) reader.nextLong();
            toReturn = input;
            inputWasValid = true;
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Your input was invalid; please give a valid long type numeric value.");
            toReturn = getLong(instructions);
        }
        return toReturn;
    }
}