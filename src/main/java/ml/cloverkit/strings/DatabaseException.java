package ml.cloverkit.strings;

public class DatabaseException extends Exception {
    public DatabaseException(int transactionId, int queryId, String message) {
        super(String.format("(t%d, q%d) %s", transactionId, queryId, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
