import java.util.Scanner;

public class RecursiveExponent{
    private static int recursiveExponents(int n){
        int square = 0;

        if (n == 1)
            return 1;
        
        square = n * n;
        return square + recursiveExponents(n - 1);
    }

    private static int iterativeExponents(int n){
        int output = 0;
            for (int i = 1; i <= n; i++){
                output += i * i;
            }
        return output;
    }

    public static void main (String[] args){
        int n;
        Scanner stdin = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        n = stdin.nextInt();
        
        System.out.println("Recursive Sum for 5 is: " + recursiveExponents(n));
        System.out.println("Iterative Sum for 5 is: " + iterativeExponents(n));
    }
}