// ATTENTION TO GITHUB VIEWERS: This code is purposefully made to not use 2 ^ n to calculate a pascal row sum. 
// For an actual implementation, 2 ^ n would be vastly more efficent.

public class PascalRowSum {

    public static long[] buildPascalRow(int n) {
        long[] row = new long[n];

        if (n == 1) {
            row[0] = 1;
        } else {
            long[] prevRow = buildPascalRow(n - 1);

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    row[0] = 1;
                } else if (i >= n - 1) {
                    row[i] = 1;
                } else {
                    row[i] = prevRow[i] + prevRow[i - 1];
                }
            }
        }
        return row;
    }


    public static long pascalRowSumRecursive(int n) {
        if (n == 1) return 1;

        long[] row = buildPascalRow(n);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += row[i];
        }
        return sum;
    }

    public static long pascalRowSumIterative(int n) {
        if (n == 1) {
            return 1;
        }

        long[] row = null;
        long[] prevRow = new long[1];
        prevRow[0] = 1;

        for (int i = 2; i <= n; i++) { // i is new row length
            row = new long[i];

            for (int j = 0; j < i; j++) { // j is index
                if (j == 0) {
                    row[0] = 1;
                } else if (j >= i - 1) {
                    row[j] = 1;
                } else {
                    row[j] = prevRow[j] + prevRow[j - 1];
                }
            }
            prevRow = row;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += row[i];
        }
        return sum;
    }

    public static void printTableRow(int n, boolean recursive) {
        long prevTime;
        long time;
        if (recursive) {
            prevTime = System.nanoTime();
            pascalRowSumRecursive(n);
            time = System.nanoTime() - prevTime;
        } else {
            prevTime = System.nanoTime();
            pascalRowSumIterative(n);
            time = System.nanoTime() - prevTime;
        }
        System.out.println("pascalRowSum" + (recursive ? ("Recursive\t| ") : ("Iterative\t| ")) + n + "\t\t| " + time);
    }

    public static void main(String[] args) {
        System.out.println("Method\t\t\t| Input (n)\t| Time (ns)");
        System.out.println("------------------------|---------------|-----------");

        printTableRow(1, false);
        printTableRow(2, false);
        printTableRow(3, false);
        printTableRow(4, false);
        printTableRow(5, false);
        printTableRow(33, false);

        printTableRow(1, true);
        printTableRow(2, true);
        printTableRow(3, true);
        printTableRow(4, true);
        printTableRow(5, true);
        printTableRow(33, true);
    }
}