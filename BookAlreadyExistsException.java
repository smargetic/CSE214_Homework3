public class BookAlreadyExistsException extends Exception {
    public BookAlreadyExistsException() {
        super("This book is already in the stack.");
    }
    public BookAlreadyExistsException(String message){
        super(message);
    }
}
