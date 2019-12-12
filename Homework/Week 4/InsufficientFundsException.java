/*
InsufficientFundsException.java
Richard Clarke
11-17-19
A class used to define an exception which occurs when an Account attempts to withdraw or
transfer more funds than available.
*/

class InsufficientFundsException extends Exception{
    InsufficientFundsException(String message){
        super(message);
    }
}