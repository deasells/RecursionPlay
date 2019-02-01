package recursionplay;

/**
 * This Java application demonstrates recursion.
 *
 * note: just added a space in the error message so it displays "base-5 number"
 *       instead of "base-5number".
 *
 * @creator DeAndre Sellers
 * @created 02018.10.10
 * @deasells
 */

public class RecursionPlay {

    public static final int BASEN_ERRNO = -1;

    public static void main(String[] argv) {
        countdown(10);
        int[] x = {8, 16, 128, 2048, Short.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " reversed: ");
            reverse_digits(x[i]);
            System.out.println();
        }
        System.out.println("the array sum: " + sum(x, 0, 0));
        int[][] b = {{512, 6}, {314, 8}, {49, 5}, {10101, 2}};
        for (int i = 0; i < b.length; i++) {
            int answer = basen(b[i][0], b[i][1]);
            if (BASEN_ERRNO == answer) {
                System.out.println("***error: " + b[i][0] + " is not a valid base-"
                        + b[i][1] + " number");
            } else {
                System.out.println(b[i][0] + " base-" + b[i][1] + " = " + answer);
            }
        }
    }

    /*
    * TBI (To Be Implemented)...
    *
    * Starting with parameter n, print to the standard output
    * stream  n...n-1...n-2... and print BLAST OFF! when n hits 
    * zero.
    *
    * Example output when parameter n equals 5:
    * 5...4...3...2...1...BLAST OFF!
    *
    * @param n  an int to countdown from
    *
    * implementation note:  countdown(int) cannot
    * contain any repetition control statements
     */
    private static void countdown(int n) {
        if (n == 0) {
            System.out.println("BLAST OFF!");
        } else {
            System.out.print(n + "...");
            countdown(n - 1);
        }
    }

    /*
    * TBI (To Be Implemented)...
    *
    * Print to the standard output stream the digits 
    * of parameter n reversed.
    *
    * Example output when n equals 321:
    * 123
    *
    * @param n  the int to reverse
    *
    * implementation note:  reverse_digits(int) cannot
    * contain any repetition control statements
    *
    * implementation note:  parameter n cannot be converted 
    * into any type of an object
     */
    private static void reverse_digits(int n) {
        System.out.print(n % 10);
        if (n / 10 == 0) {
            return;
        } else {
            reverse_digits(n / 10);
        }
    }

    /*
    * TBI (To Be Implemented)...
    *
    * Recursive method that calculates the sum
    * of the elements of an int[].
    *
    * @param x      an array-of-int
    * @param x_i    current index into x
    * @param total  current sum of x up to x[x_i]
    * @return the sum of the elements in an int[]
    *
    * implementation note:  The number of parameters
    * and/or their types can be changed, but doing so
    * may require changing the main() method.
     */
    private static long sum(int[] x, int x_i, long total) {
        if (x_i == x.length) {
            return 0;
        } else {
            return total = x[x_i] + sum(x, (x_i + 1), total);
        }
    }

    /*
    * TBI (To Be Implemented)...
    *
    * Rewrite the basen() method so that it uses 
    * recursion rather than iteration.
    *
    * @param number      number to convert
    * @param base        base to convert to
    * @return parameter number converted to parameter base
    *         BASEN_ERRNO if number is not valid in the base 
    *
    * implementation note: You can override this basen(int, int)
    * method if you'd like to use additional parameters. In other
    * words, you can write another basen() method that this one calls.
     */
    private static int basen(int number, int base) {
        int placeValue = 1;
        return basen(number, base, placeValue);
    }

    private static int basen(int number, int base, int placeValue) {
        int answer = 0;

        if (number <= 0) {
            return answer;
        } else {
            int digit = number % 10;
            if (digit >= base) {
                return BASEN_ERRNO;
            }
            answer += digit * placeValue;
            placeValue *= base;
            number /= 10;
        }
        return answer += basen(number, base, placeValue);
    }
}
