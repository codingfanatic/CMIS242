/*
All its methods must be class (static) methods and no objects should be
able to be generated for that class. It should contain three public methods 
(AND a static int which increments on either the iteration loop or each recursion method call
*/

class Logic{
    //Static int which increments with each recrusion or iteration
    private static int efficiency = 0;
    private static int[10] sequence = {0, 1, 2, 5, 12, 29, 70, 169, 408, 985}

    public static int computeIterative(int n){
        
        return efficiency;
    }

    public static int computeRecursive(int n){
        efficiency++;
        return efficiency;
    }

    public static int getEfficiency(){
        return efficiency;
    }    
}