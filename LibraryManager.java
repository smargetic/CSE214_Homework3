import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) throws BookAlreadyExistsException, BookDoesNotExistException, InvalidConditionException{
        Scanner scanner = new Scanner(System.in);

        BooksStack stackingBooks = new BooksStack();

        while(true){
            System.out.println("\nMenu:\n");
            System.out.println("\u2022(A)-Add Book");
            System.out.println("\u2022(R)-Remove Book");
            System.out.println("\u2022(G)-Get Book");
            System.out.println("\u2022(P)-Print Books");
            System.out.println("\u2022(S)-Sort Books:");
            System.out.println("\t\u25E6(N)-Name");
            System.out.println("\t\u25E6(A)-Author");
            System.out.println("\t\u25E6(G)-Genre");
            System.out.println("\t\u25E6(Y)-Year");
            System.out.println("\t\u25E6(C)-Condition");
            System.out.println("\t\u25E6(I)-ISBN Number");
            System.out.println("\u2022(Q)-Quit");

            System.out.print("\n\nPlease select an option: ");
            String letter = scanner.nextLine().trim();

            switch (letter) {
                case "a":
                case "A":
                    System.out.println("\nPlease enter the name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("\nPlease enter the author: ");
                    String author = scanner.nextLine().trim();
                    System.out.print("\nPlease enter the genre: ");
                    String genre = scanner.nextLine().trim();
                    System.out.print("\nPlease enter the year it was published: ");
                    String tempYear = scanner.nextLine().trim();
                    int year = Integer.parseInt(tempYear);
                    System.out.print("\nPlease enter the ISBN Number: ");
                    String tempISBN = scanner.nextLine().trim();
                    long ISBN = Long.parseLong(tempISBN);
                    System.out.print("\nPlease enter the condition: ");
                    String condition = scanner.nextLine().trim();

                    if(!(condition.equalsIgnoreCase("OLD") || condition.equalsIgnoreCase("NEW"))) {
                        throw new InvalidConditionException();
                    }
                        //call push function to add new book
                        Book newBook = new Book(ISBN, year, name, author, genre, condition);

                    try {
                        stackingBooks.push(newBook);
                    } catch (Exception BookAlreadyExistsException) {
                        throw new BookAlreadyExistsException();
                     }

                    System.out.println("\n\n" + name + " has been added!");
                    break;
                case "r":
                case "R":
                    System.out.print("\nPlease enter the name of the book:");
                    name = scanner.nextLine().trim();

                    //I call the function to remove the book by name
                    try {
                        stackingBooks.removeBook(name);
                    } catch(Exception BookDoesNotExistException) {
                        throw new BookDoesNotExistException();
                    }

                    System.out.print("\n" + name + " has been removed!");
                    break;
                case "g":
                case "G":
                    System.out.print("\nPlease enter the name of the book: ");
                    name = scanner.nextLine().trim();

                    Book tempBook = stackingBooks.peekBook(name);

                    System.out.println(tempBook.getName() + " was written by " + tempBook.getAuthor() + " in the year " +
                            tempBook.getYearPublished() + ". It is of the " + tempBook.getGenre() + " genre. The ISBN Number is" + tempBook.getISBN()
                            + " and it is" + tempBook.getCondition());

                    break;
                case "p":
                case "P":
                    stackingBooks.printTable();
                    break;
                case "s":
                case "S":
                    System.out.print("\nPlease select by what:");

                    System.out.print("\n\t\u25E6(N)-Name");
                    System.out.print("\n\t\u25E6(A)-Author");
                    System.out.print("\n\t\u25E6(G)-Genre");
                    System.out.print("\n\t\u25E6(Y)-Year");
                    System.out.print("\n\t\u25E6(C)-Condition");
                    System.out.print("\n\t\u25E6(I)-ISBN Number");

                    System.out.print("\nChoose an option: ");
                    String option2 = scanner.nextLine().trim();

                    //CALL SORT FUNCTION
                    stackingBooks.sort(option2);

                    break;
                case "q":
                case "Q":
                    System.out.print("\nSorry to see you go!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("That is not an option, please try again.");
                    break;
            }
        }
    }
}
