import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("This program will print out the Fibonacci sequence to a specified term number, or will print the number at a specified term number in the sequence.");
        String input = getString("Please choose whether to print the whole sequence (input \"S\") or only the number (input \"N\") at the specified term number.");
        while (!input.equals("S") && !input.equals("N")) {
            input = getString("That was an invalid input, please try again.\n Please choose whether to print the whole sequence (input \"S\") or only the number (input \"N\") at the specified term number.");
        }
        if (input.equals("S")) {
            printSequence();
        }
        else {
            printNumber();
        }
    }

	public static void printSequence() {
    System.out.println("This method prints the Fibonacci sequence to a specified term number, e.g. the 1st, 3rd, or 100th term.");
    System.out.println();
        
    BigInteger even = new BigInteger("0");
    BigInteger odd = new BigInteger("1");
    BigInteger toPrint = new BigInteger("0"); // use this in printing to prevent stack overflows
	long to_go_to = getLong("Please give the term number in the Fibonacci sequence to print to (e.g. 0th, 2nd, or 53rd).");
        
    System.out.println();
    System.out.println("Program now printing the Fibonacci sequence to the " + addCommas(to_go_to) + getOrdinal(to_go_to) + " term.");
        
    for (long i = 0; i <= to_go_to; i++) {
        if (i %2 == 0) { // an even term no
            toPrint = even;
            even = even.add(odd); // even += odd
        }
        else { // at an odd term no
            toPrint = odd;
            odd  = odd.add(even); // odd += even
        }
        System.out.println(addCommas(i) + getOrdinal(i) + " term in the Fibonacci sequence: " + toPrint.toString());
    }
    System.out.println("Program done.");
	}

	public static void printNumber() {
	    System.out.println("This method prints the number in the Fibonacci sequence at a specified term number, e.g. the 1st, 3rd, or 100th term.");
        System.out.println();

        BigInteger even = new BigInteger("0");
        BigInteger odd = new BigInteger("1");
        BigInteger toPrint = new BigInteger("0"); // use this in printing to prevent stack overflows
        long to_go_to = getLong("Please give the term number in the Fibonacci sequence to print (e.g. 0th, 2nd, or 53rd).");

        System.out.println();
        System.out.println("Program now printing the number at the " + addCommas(to_go_to) + getOrdinal(to_go_to) + " term in the Fibonacci sequence.");

        for (long i = 0; i <= to_go_to; i++) {
            if (i %2 == 0) { // an even term no
                toPrint = even;
                even = even.add(odd); // even += odd
            }
            else { // at an odd term no
                toPrint = odd;
                odd  = odd.add(even); // odd += even
            }
        }
        System.out.println("The number at the " + addCommas(to_go_to) + getOrdinal(to_go_to) + " term in the Fibonacci sequence is: \n" + toPrint.toString() + "\nProgram done.");
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
            System.out.println("Your input was invalid; please give a valid, postive, long type numeric value.");
            toReturn = getLong(instructions);
        }
        if (toReturn < 0) {
            System.out.println();
            System.out.println("Your input was invalid; please give a valid, postive, long type numeric value.");
            toReturn = getLong(instructions);
        }
        return toReturn;
    }

    public static String getString(String instructions) {
        System.out.println(instructions);
        Scanner reader = new Scanner(System.in);
        try {
            return (String) (reader.next().toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Your input was invalid; please give a valid String input.");
            return getString(instructions);
        }
    }

    public static String addCommas(long numIn) {
        String numAsString = (String) (String.valueOf(numIn));
        String commaString = "";

        if (numAsString.length() > 3) {
            for (int i = numAsString.length() - 1; i >= 0; i--) {
                if (i < numAsString.length() - 2 && numAsString.length() > 3) {
                    if ((i + 2) % 3 == 0) {
                        commaString = "," + numAsString.substring(numAsString.length() - 3, numAsString.length()) + commaString;
                        numAsString = numAsString.substring(0, numAsString.length() - 3);
                    }
                } else if (numAsString.length() < 4) {
                    commaString = numAsString + commaString;
                    numAsString = "";
                }
            }
        }
        else commaString = numAsString;
        return commaString;
    }
}