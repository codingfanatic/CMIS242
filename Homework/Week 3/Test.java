public class Test
{
   public static void main(String[] args)
   {
       if (Integer.parseInt(args[0]) == 0)
           throw new Exception("Invalid Command Line Argument");
   }
}