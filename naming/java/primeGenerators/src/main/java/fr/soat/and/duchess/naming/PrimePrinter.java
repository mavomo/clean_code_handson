package fr.soat.and.duchess.naming;
/**
 * This class Generates prime numbers up to a user specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * <p>
 * Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya --
 * d. c. 194, Alexandria. The first man to calculate the
 * circumference of the Earth. Also known for working on
 * calendars with leap years and ran the library at Alexandria.
 * <p>
 * The algorithm is quite simple. Given an array of integers
 * starting at 2. Cross out all multiples of 2. Find the next
 * uncrossed integer, and cross out all of its multiples.
 * Repeat untilyou have passed the square root of the maximum
 * value.
 *
 */
public class PrimePrinter {

    public static void main(String[] args) {
        // generation limit
        final int M = 1000;
        // row count per page
        final int RR = 50;
        // column count per page
        final int CC = 4;
        // number of potential prime squares
        final int ORDMAX = 30;
        // prime array
        int P[] = new int[M + 1];
        // current page number
        int PAGENUMBER;
        // current page offset
        int PAGEOFFSET;
        // current row offset
        int ROWOFFSET;
        // current column number
        int C;
        // potential prime - tested number
        int J;
        // prime count
        int K;
        // isPrime flag
        boolean JPRIME;
        // array index of squares
        int ORD;
        // next potential square
        int SQUARE;
        // potential divisor
        int N = 0;
        // array of squares
        int MULT[] = new int[ORDMAX + 1];

        J = 1;
        K = 1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;

        while (K < M) {
            do {
                J = J + 2;
                if (J == SQUARE) {
                    ORD = ORD + 1;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J)
                        MULT[N] = MULT[N] + P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME = false;
                    N = N + 1;
                }
            } while (!JPRIME);
            K = K + 1;
            P[K] = J;
        }

        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= M) {
            System.out.println("The First " + M + " Prime numbers --- Page " + PAGENUMBER);
            System.out.println("");
            for (ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + RR; ROWOFFSET++) {
                for (C = 0; C < CC; C++)
                    if (ROWOFFSET + C * RR <= M)
                        System.out.format("%10d", P[ROWOFFSET + C * RR]);
                System.out.println("");
            }
            System.out.println("\f");
            PAGENUMBER = PAGENUMBER + 1;
            PAGEOFFSET = PAGEOFFSET + RR * CC;
        }
    }

}
