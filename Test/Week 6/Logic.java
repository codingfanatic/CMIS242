/*
All its methods must be class (static) methods and no objects should be
able to be generated for that class. It should contain three public methods 
(AND a static int which increments on either the iteration loop or each recursion method call

The first method computeIterative should accept a value of nand return the 
corresponding element in the sequence using iteration.
*/

public class Logic{
    //Static int which increments with each recrusion or iteration
    private static int efficiency = 0;
    private static int[] sequence = {0, 1, 2, 5, 12, 29, 70, 169, 408, 985, 2108};

    public static int computeIterative(int n){
            if (n < 0){
                System.out.println("Please enter a value between 0 and 10");
                return -1;
            }

            else if(n == 0){
                efficiency++;    
                return 0;
            }
                
            else if (n == 1){
                efficiency++;
                return 1;
            }

            else {
                return ((2 * sequence[n - 1]) + sequence[n - 2]);
            }
    }

    public static int computeRecursive(int n){
        if (n < 0){
            System.out.println("Please enter a value between 0 and 10");
            return -1;
        }

        else if(n == 0){
            efficiency++;    
            return 0;
        }
            
        else if (n == 1){
            efficiency++;
            return 1;
        }

        else {
            efficiency++;
            return 2 * (computeIterative(n - 1)) + computeIterative(n - 2);
        }
    }

    public static int getEfficiency(){
        return efficiency;
    }    

    public static void main(String[] args){
        int i = 6;
        System.out.println(computeRecursive(i));
        System.out.println(computeIterative(i));
        System.out.println(getEfficiency());
    }
}