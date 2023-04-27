package ml.cloverkit.exceptions;

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("MyException");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
            System.out.println("getClass().getName(): " + e.getClass().getName());
            System.out.println("getClass().getSimpleName(): " + e.getClass().getSimpleName());
        }
    }
}
