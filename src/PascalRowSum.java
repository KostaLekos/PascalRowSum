import java.lang.Math;

public class PascalRowSum {

    public static long pascalRowSumRecursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return pascalRowSumRecursive(n - 1) * 2l;
        }
    }

    public static long pascalRowSumIterative(int n) {
        return Math.powExact(2l, n);
    }

    public static void main(String[] args) {
        System.out.println(pascalRowSumIterative(1));
        System.out.println(pascalRowSumIterative(2));
        System.out.println(pascalRowSumIterative(3));
        System.out.println(pascalRowSumIterative(4));
        System.out.println(pascalRowSumIterative(5));
        System.out.println(pascalRowSumIterative(33));
        System.out.println(pascalRowSumRecursive(1));
        System.out.println(pascalRowSumRecursive(2));
        System.out.println(pascalRowSumRecursive(3));
        System.out.println(pascalRowSumRecursive(4));
        System.out.println(pascalRowSumRecursive(5));
        System.out.println(pascalRowSumRecursive(32));
    }
}